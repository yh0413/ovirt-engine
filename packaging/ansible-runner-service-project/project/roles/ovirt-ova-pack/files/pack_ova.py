import io
import os
import pwd
import sys
import tarfile
import time


from subprocess import CalledProcessError
from subprocess import call
from subprocess import check_call
from subprocess import check_output

import six

TAR_BLOCK_SIZE = 512
NUL = b"\0"

python2 = sys.version_info < (3, 0)
path_to_offset = {}


def from_bytes(string):
    return (string.decode('utf-8')
            if isinstance(string, six.binary_type) else string)


def create_tar_info(name, size):
    info = tarfile.TarInfo(name)
    info.size = size
    info.mtime = time.time()
    return info


def pad_to_block_size(file):
    remainder = file.tell() % TAR_BLOCK_SIZE
    if remainder:
        padding_size = TAR_BLOCK_SIZE - remainder
        file.write(NUL * padding_size)


def write_ovf(entity, ova_file, ovf):
    print("writing ovf: %s" % ovf)
    tar_info = create_tar_info(entity + ".ovf", len(ovf))
    ova_file.write(tar_info.tobuf())
    ova_file.write(ovf if python2 else ovf.encode())
    pad_to_block_size(ova_file)


def write_file(name, ova_file, data):
    print("writing file: %s" % name)
    tar_info = create_tar_info(name, len(data))
    ova_file.write(tar_info.tobuf())
    ova_file.write(data.encode())
    pad_to_block_size(ova_file)


def convert_disks(ova_path):
    for path, offset in six.iteritems(path_to_offset):
        print("converting disk: %s, offset %s" % (path, offset))
        output = check_output(['losetup', '--find', '--show', '-o', offset,
                               ova_path])
        loop = from_bytes(output.splitlines()[0])
        loop_stat = os.stat(loop)
        call(['udevadm', 'settle'])
        vdsm_user = pwd.getpwnam('vdsm')
        os.chown(loop, vdsm_user.pw_uid, vdsm_user.pw_gid)
        try:
            qemu_cmd = ("qemu-img convert -p -T none -O qcow2 '%s' '%s'"
                        % (path, loop))
            check_call(['su', '-p', '-c', qemu_cmd, 'vdsm'])
        except CalledProcessError as exc:
            print("qemu-img conversion failed with error: ", exc.returncode)
            raise
        finally:
            os.chown(loop, loop_stat.st_uid, loop_stat.st_gid)
            call(['losetup', '-d', loop])


def write_disk_headers(ova_file, disks_info):
    for disk_info in disks_info:
        # disk_info is of the following structure: <full path>::<size in bytes>
        idx = disk_info.index('::')
        disk_path = disk_info[:idx]
        disk_size = int(disk_info[idx+2:])
        print("skipping disk: path=%s size=%d" % (disk_path, disk_size))
        disk_name = os.path.basename(disk_path)
        tar_info = create_tar_info(disk_name, disk_size)
        # write tar info
        ova_file.write(tar_info.tobuf())
        path_to_offset[disk_path] = str(ova_file.tell())
        ova_file.seek(disk_size, 1)


def write_null_blocks(ova_file):
    ova_file.write(NUL * 2 * TAR_BLOCK_SIZE)


if len(sys.argv) < 3:
    print("Usage: pack_ova.py <vm/template> output_path ovf"
          " [disks_info [tpm_data]]")
    sys.exit(2)

entity = sys.argv[1]
ova_path = sys.argv[2]
ovf = sys.argv[3]
disks_info = sys.argv[4]
tpm_data = sys.argv[5]
with io.open(ova_path, "wb") as ova_file:
    write_ovf(entity, ova_file, ovf)
    if len(tpm_data) > 0:
        write_file("tpm.dat", ova_file, tpm_data)
    if len(disks_info) > 0:
        write_disk_headers(ova_file, disks_info.split('+'))
    # write two null blocks at the end of the file
    write_null_blocks(ova_file)
    ova_file.flush()
    os.fsync(ova_file.fileno())
convert_disks(ova_path)
