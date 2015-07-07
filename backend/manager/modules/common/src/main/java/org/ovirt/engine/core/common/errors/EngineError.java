package org.ovirt.engine.core.common.errors;

import java.util.HashMap;

/**
 * The purpose of this enumaration is to contain all the errors exposed by the Engine. The error codes are not
 * sequential in order to be able to add error codes as development evolves.
 */
public enum EngineError {
    Done(0),
    noVM(1),
    nfsErr(3),
    exist(4),
    noVmType(5),
    down(6),
    copyerr(7),
    sparse(8),
    createErr(9),
    noConPeer(10),
    MissParam(11),
    migrateErr(12),
    imageErr(13),
    outOfMem(14),
    unexpected(16),
    unsupFormat(17),
    ticketErr(18),
    nonresp(19),
    ERR_BAD_PARAMS(21),
    ERR_BAD_ADDR(22),
    ERR_BAD_NIC(23),
    ERR_USED_NIC(24),
    ERR_BAD_BONDING(25),
    ERR_BAD_VLAN(26),
    ERR_BAD_BRIDGE(27),
    ERR_USED_BRIDGE(28),
    ERR_FAILED_IFUP(29),
    MIGRATION_DEST_INVALID_HOSTNAME(39),
    unavail(40),
    FAILED_CHANGE_CD_IS_MOUNTED(41),
    destroyErr(42),
    fenceAgent(43),
    NO_IMPLEMENTATION(44),
    FailedToPlugDisk(45),
    FailedToUnPlugDisk(46),
    MIGRATION_CANCEL_ERROR(47),
    SNAPSHOT_FAILED(48),
    ACTIVATE_NIC_FAILED(49),
    DEACTIVATE_NIC_FAILED(50),
    UPDATE_VNIC_FAILED(56),
    migInProgress(51),
    mergeErr(52),
    balloonErr(53),
    momErr(54),
    replicaErr(55),
    UpdateDevice(56),
    hwInfoErr(57),
    ResizeErr(58),
    HOT_PLUG_UNPLUG_CPU_ERROR(60),
    V2V_JOB_DOESNT_EXIST(66),
    V2V_NO_SUCH_OVF(67),
    V2V_JOB_NOT_DONE(68),
    V2V_JOB_ALREADY_EXIST(69),
    HOT_PLUG_MEM(70),
    UnsupportedOperationErr(75),
    freezeErr(76),
    thawErr(77),
    recovery(99),
    GeneralException(100),
    StorageException(200),
    VolumeDoesNotExist(201),
    IncorrectFormat(202),
    VolumeIsBusy(203),
    VolumeImageHasChildren(204),
    VolumeCreationError(205),
    VolumeExtendingError(206),
    VolumeMetadataReadError(207),
    VolumeMetadataWriteError(208),
    VolumeAccessError(209),
    VolumeUnlinkError(210),
    OrphanVolumeError(211),
    VolumeAlreadyExists(212),
    VolumeNonWritable(213),
    VolumeNonShareable(214),
    VolumeOwnershipError(215),
    VolumeCannotGetParent(216),
    CannotCloneVolume(217),
    CannotShareVolume(218),
    SharedVolumeNonWritable(219),
    InternalVolumeNonWritable(220),
    CannotModifyVolumeTime(221),
    CannotDeleteVolume(222),
    CannotDeleteSharedVolume(223),
    NonLeafVolumeNotWritable(224),
    VolumeCopyError(225),
    createIllegalVolumeSnapshotError(226),
    prepareIllegalVolumeError(227),
    createVolumeRollbackError(228),
    createVolumeSizeError(229),
    VOLUME_WAS_NOT_PREPARED_BEFORE_TEARDOWN(230),
    IncorrectType(231),
    VolumeResizeValueError(232),
    VolumeNotSparse(233),
    CannotSparsifyVolume(234),
    ImagesActionError(250),
    TemplateCreationError(251),
    MergeSnapshotsError(252),
    MoveImageError(253),
    ImagePathError(254),
    ImageValidationError(255),
    ImageDeleteError(256),
    ImageIsNotEmpty(257),
    ImageIsEmpty(258),
    SourceImageActionError(259),
    DestImageActionError(260),
    CopyImageError(261),
    ImageIsNotLegalChain(262),
    CouldNotValideTemplateOnTargetDomain(263),
    MultipleMoveImageError(264),
    OverwriteImageError(265),
    MoveTemplateImageError(266),
    MergeVolumeRollbackError(267),
    ImageDoesNotExistInDomainError(268),
    StoragePoolActionError(300),
    StoragePoolCreationError(301),
    StoragePoolConnectionError(302),
    StoragePoolDisconnectionError(303),
    StoragePoolMasterNotFound(304),
    StorageUpdateVmError(305),
    ReconstructMasterError(306),
    StoragePoolTooManyMasters(307),
    StoragePoolDestroyingError(308),
    StoragePoolUnknown(309),
    StoragePoolHasPotentialMaster(310),
    StoragePoolInternalError(311),
    ImageMissingFromVm(312),
    StoragePoolNotConnected(313),
    GetIsoListError(314),
    GetFloppyListError(315),
    StoragePoolAlreadyExists(316),
    IsoCannotBeMasterDomain(317),
    StoragePoolCheckError(318),
    BackupCannotBeMasterDomain(319),
    MissingOvfFileFromVM(320),
    ImageNotOnTargetDomain(321),
    VMPathNotExists(322),
    CannotConnectMultiplePools(323),
    StoragePoolWrongMaster(324),
    StoragePoolConnected(325),
    StoragePoolHigherVersionMasterFound(326),
    StoragePoolDescriptionTooLongError(327),
    TooManyDomainsInStoragePoolError(328),
    IMAGES_NOT_SUPPORTED_ERROR(329),
    GET_FILE_LIST_ERROR(330),
    StorageDomainActionError(350),
    StorageDomainCreationError(351),
    StorageDomainFormatError(352),
    StorageDomainNotInPool(353),
    StorageDomainAttachError(354),
    StorageDomainMasterError(355),
    StorageDomainDetachError(356),
    StorageDomainDeactivateError(357),
    StorageDomainDoesNotExist(358),
    StorageDomainActivateError(359),
    StorageDomainFSNotMounted(360),
    StorageDomainNotEmpty(361),
    StorageDomainMetadataCreationError(362),
    StorageDomainMetadataFileMissing(363),
    StorageDomainMetadataNotFound(364),
    StorageDomainAlreadyExists(365),
    StorageDomainMasterUnmountError(366),
    BlockStorageDomainMasterFSCKError(367),
    BlockStorageDomainMasterMountError(368),
    StorageDomainNotActive(369),
    StorageDomainMasterCopyError(370),
    StorageDomainLayoutError(371),
    StorageDomainTypeError(372),
    GetStorageDomainListError(373),
    VolumesZeroingError(374),
    StorageDomainNotMemberOfPool(375),
    StorageDomainStatusError(376),
    StorageDomainCheckError(377),
    StorageDomainTypeNotBackup(378),
    StorageDomainAccessError(379),
    StorageDomainAlreadyAttached(380),
    StorageDomainStateTransitionIllegal(381),
    StorageDomainActive(382),
    CannotDetachMasterStorageDomain(383),
    FileStorageDomainStaleNFSHandle(384),
    StorageDomainInsufficientPermissions(385),
    StorageDomainClassError(386),
    StorageDomainDescriptionTooLongError(387),
    StorageDomainIsMadeFromTooManyPVs(388),
    TooManyPVsInVG(389),
    StorageDomainIllegalRemotePath(390),
    CannotFormatAttachedStorageDomain(391),
    CannotFormatStorageDomainInConnectedPool(392),
    STORAGE_DOMAIN_REFRESH_ERROR(393),
    UnsupportedDomainVersion(394),
    CurrentVersionTooAdvancedError(395),
    PoolUpgradeInProgress(396),
    NoSpaceLeftOnDomain(397),
    MixedSDVersionError(398),
    StorageDomainTargetUnsupported(399),
    InvalidTask(400),
    UnknownTask(401),
    TaskClearError(402),
    TaskNotFinished(403),
    InvalidTaskType(404),
    AddTaskError(405),
    TaskInProgress(406),
    TaskMetaDataSaveError(407),
    TaskMetaDataLoadError(408),
    TaskDirError(409),
    TaskStateError(410),
    TaskAborted(411),
    UnmanagedTask(412),
    TaskPersistError(413),
    InvalidJob(420),
    InvalidRecovery(430),
    InvalidTaskMng(440),
    TaskStateTransitionError(441),
    TaskHasRefs(442),
    // task was deliberately stopped by someone
    ActionStopped(443),
    StorageServerActionError(450),
    StorageServerConnectionError(451),
    StorageServerDisconnectionError(452),
    StorageServerValidationError(453),
    StorageServeriSCSIError(454),
    MultipathRestartError(455),
    GetiSCSISessionListError(456),
    AddiSCSIPortalError(457),
    RemoveiSCSIPortalError(458),
    RemoveiSCSINodeError(459),
    AddiSCSINodeError(460),
    SetiSCSIAuthError(461),
    SetiSCSIUsernameError(462),
    SetiSCSIPasswdError(463),
    iSCSILoginError(464),
    iSCSISetupError(465),
    DeviceNotFound(466),
    MultipathSetupError(467),
    StorageTypeError(468),
    StorageServerAccessPermissionError(469),
    MountTypeError(470),
    MountParsingError(471),
    InvalidIpAddress(472),
    iSCSIifaceError(473),
    iSCSILogoutError(474),
    iSCSIDiscoveryError(475),
    ISCSI_LOGIN_AUTH_ERROR(476),
    ProblemWhileTryingToMountTarget(477),
    StorageServerConnectionRefIdAlreadyInUse(478),
    StorageServerConnectionRefIdDoesNotExist(479),
    VolumeGroupActionError(500),
    VolumeGroupPermissionsError(501),
    VolumeGroupCreateError(502),
    VolumeGroupExtendError(503),
    VolumeGroupSizeError(504),
    VolumeGroupAlreadyExistsError(505),
    VolumeGroupDoesNotExist(506),
    VolumeGroupRenameError(507),
    VolumeGroupRemoveError(508),
    VolumeGroupUninitialized(509),
    VolumeGroupReadTagError(510),
    VolumeGroupAddTagError(511),
    VolumeGroupRemoveTagError(512),
    VolumeGroupScanError(513),
    GetVolumeGroupListError(514),
    VolumeGroupHasDomainTag(515),
    VolumeGroupReplaceTagError(516),
    VOLUME_GROUP_BLOCK_SIZE_ERROR(517),
    DEVICE_BLOCK_SIZE_NOT_SUPPORTED(518),
    CannotCreateLogicalVolume(550),
    CannotRemoveLogicalVolume(551),
    CannotDeactivateLogicalVolume(552),
    CannotAccessLogicalVolume(553),
    LogicalVolumeExtendError(554),
    LogicalVolumesListError(555),
    LogicalVolumeRefreshError(556),
    LogicalVolumeScanError(557),
    CannotActivateLogicalVolume(558),
    LogicalVolumePermissionsError(559),
    LogicalVolumeAddTagError(560),
    LogicalVolumeRemoveTagError(561),
    GetLogicalVolumeTagError(562),
    GetLogicalVolumesByTagError(563),
    GetAllLogicalVolumeTagsError(564),
    GetLogicalVolumeDevError(565),
    LogicalVolumeRenameError(566),
    CannotWriteAccessLogialVolume(567),
    CannotSetRWLogicalVolume(568),
    LogicalVolumesScanError(569),
    CannotActivateLogicalVolumes(570),
    GetLogicalVolumeDataError(571),
    LogicalVolumeReplaceTagError(572),
    BlockDeviceActionError(600),
    PhysDevInitializationError(601),
    LVMSetupError(602),
    CouldNotRetrievePhysicalVolumeList(603),
    LogicalVolumeAlreadyExists(604),
    CouldNotRetrieveLogicalVolumesList(605),
    InaccessiblePhysDev(606),
    PartitionedPhysDev(607),
    MkfsError(608),
    MissingTagOnLogicalVolume(609),
    LogicalVolumeDoesNotExistError(610),
    LogicalVolumeCachingError(611),
    LogicalVolumeWrongTagError(612),
    VG_METADATA_CRITICALLY_FULL(613),
    SMALL_VG_METADATA(614),
    CouldNotResizePhysicalVolume(615),
    SpmStartError(650),
    AcquireLockFailure(651),
    SpmParamsMismatch(652),
    SpmStopError(653),
    SpmStatusError(654),
    SpmFenceError(655),
    IsSpm(656),
    DomainAlreadyLocked(657),
    DomainLockDoesNotExist(658),
    CannotRetrieveSpmStatus(659),
    ReleaseLockFailure(660),
    AcquireHostIdFailure(661),
    ReleaseHostIdFailure(662),
    HostIdMismatch(700),
    MetaDataGeneralError(749),
    MetaDataKeyError(750),
    MetaDataKeyNotFoundError(751),
    MetaDataSealIsBroken(752),
    MetaDataValidationError(753),
    MetaDataMappingError(754),
    MetaDataParamError(755),
    MetadataOverflowError(756),
    ImportError(800),
    ImportInfoError(801),
    ImportUnknownType(802),
    ExportError(803),
    ReachedMaxNumberOfHostsInDC(804),
    ResourceNamespaceNotEmpty(850),
    ResourceTimeout(851),
    ResourceDoesNotExist(852),
    InvalidResourceName(853),
    ResourceReferenceInvalid(854),
    ResourceAcqusitionFailed(855),
    NoUpServerFoundInRemoteCluster(856),
    FailedToStopMasterVolumeDuringVolumeSnapshotRestore(857),
    FailedToRestoreMasterVolumeDuringVolumeSnapshotRestore(858),
    InvalidParameterException(1000),
    InvalidDefaultExceptionException(1001),
    NotImplementedException(2000),
    MiscFileReadException(2001),
    MiscFileWriteException(2002),
    MiscBlockReadException(2003),
    MiscBlockWriteException(2004),
    OperationInProgress(2005),
    MiscBlockWriteIncomplete(2006),
    MiscBlockReadIncomplete(2007),
    MiscDirCleanupFailure(2008),
    ResourceException(3000),
    VolumeGeneralException(4000),

    // Gluster VDSM errors
    GlusterGeneralException(4101),
    GlusterPermissionDeniedException(4102),
    GlusterSyntaxErrorException(4103),
    GlusterMissingArgumentException(4104),
    GlusterCmdExecFailedException(4105),
    GlusterXmlErrorException(4106),
    GlusterVolumeCreateFailed(4122),
    GlusterVolumeStartFailed(4125),
    GlusterVolumeStopFailed(4127),
    AddBricksToGlusterVolumeFailed(4128),
    GlusterVolumeSetOptionFailed(4131),
    GlusterVolumeRebalanceStartFailed(4135),
    GlusterVolumeRebalanceStopFailed(4137),
    GlusterVolumeRebalanceStatusFailedException(4138),
    GlusterVolumeDeleteFailed(4139),
    GlusterVolumeReplaceBrickStartFailed(4142),
    GlusterVolumeListFailed(4149),
    GlusterVolumeRemoveBrickStatusFailed(4152),
    GlusterVolumeRemoveBricksStopFailed(4150),
    GlusterVolumeRemoveBricksCommitFailed(4153),
    GlusterVolumeOptionInfoFailed(4154),
    GlusterVolumeResetOptionsFailed(4155),
    GlusterVolumeRemoveBricksFailed(4156),
    GlusterVolumeRemoveBricksStartFailed(4140),
    GlusterVolumeStatusFailed(4157),
    GlusterVolumeProfileStartFailed(4158),
    GlusterVolumeProfileStopFailed(4159),
    GlusterVolumeProfileInfoFailed(4160),
    GlusterVolumeStatusAllFailedException(4161),
    GlusterGeoRepException(4200),
    GlusterVolumeGeoRepSessionStartFailed(4201),
    GlusterVolumeGeoRepSessionStopFailed(4202),
    GlusterVolumeGeoRepStatusFailed(4203),
    GlusterVolumeGeoRepSessionPauseFailed(4204),
    GlusterVolumeGeoRepSessionResumeFailed(4205),
    GlusterGeoRepConfigFailed(4206),
    GlusterGeoRepPublicKeyFileCreateFailed(4207),
    GlusterGeoRepPublicKeyFileReadError(4208),
    GlusterGeoRepUserNotFound(4209),
    GlusterGeoRepPublicKeyWriteFailed(4210),
    GlusterGeoRepExecuteMountBrokerOptFailed(4211),
    GlusterGeoRepExecuteMountBrokerUserAddFailed(4212),
    GlusterMountBrokerRootCreateFailed(4213),
    GlusterGeoRepSessionCreateFailed(4214),
    GlusterGeoRepSessionDeleteFailedException(4215),
    GlusterHostIsNotPartOfCluster(4403),
    GlusterAddHostFailed(4404),
    GlusterHostRemoveFailedException(4406),
    GlusterPeerListFailed(4407),
    GlusterHostUUIDNotFound(4408),
    GlusterHostStorageDeviceNotFoundException(4409),
    GlusterHostStorageDeviceInUseException(4410),
    GlusterHostStorageDeviceMountFailedException(4411),
    GlusterHostStorageDeviceMkfsFailedException(4412),
    GlusterHostStorageDeviceFsTabFoundException(4413),
    GlusterHostStorageDevicePVCreateFailedException(4414),
    GlusterHostStorageDeviceLVConvertFailedException(4415),
    GlusterHostStorageDeviceLVChangeFailedException(4416),
    GlusterHookFailed(4500),
    GlusterHookListException(4501),
    GlusterHookEnableFailed(4502),
    GlusterHookDisableFailed(4503),
    GlusterHookNotFound(4504),
    GlusterHookConflict(4505),
    GlusterHookUpdateFailed(4506),
    GlusterHookAlreadyExists(4507),
    GlusterHookChecksumMismatch(4508),
    GlusterHookAddFailed(4509),
    GlusterHookRemoveFailed(4510),
    GlusterServicesActionFailed(4550),
    GlusterServiceActionNotSupported(4551),
    GlusterLibgfapiException(4570),
    GlfsStatvfsException(4571),
    GlfsInitException(4572),
    GlfsFiniException(4573),
    GlusterVolumeEmptyCheckFailed(4574),
    GlusterSnapshotScheduleFlagUpdateFailedException(4575),
    GlusterDisableSnapshotScheduleFailedException(4576),
    GlusterVolumeGeoRepStatusDetailFailed(4600),
    GlusterVolumeGeoRepSyncFailed(4601),
    GlusterSnapshotException(4700),
    GlusterSnapshotCreateFailedException(4701),
    GlusterSnapshotDeleteFailedException(4702),
    GlusterSnapshotActivateFailedException(4703),
    GlusterSnapshotDeactivateFailedException(4704),
    GlusterSnapshotRestoreFailedException(4705),
    GlusterSnapshotConfigFailedException(4706),
    GlusterSnapshotConfigSetFailedException(4707),
    GlusterSnapshotConfigGetFailedException(4708),
    GlusterSnapshotInfoFailedException(4709),
    UnsupportedGlusterVolumeReplicaCountError(4710),

    UnicodeArgumentException(4900),

    // oVirt errors
    ENGINE(5001),
    DB(5002),
    UPLOAD_FAILURE(5003),
    // The VDS does not exist in memory
    RESOURCE_MANAGER_VDS_NOT_FOUND(5004),
    IRS_IMAGE_STATUS_ILLEGAL(5006),
    IRS_REPOSITORY_NOT_FOUND(5009),
    MAC_POOL_INITIALIZATION_FAILED(5010),
    MAC_POOL_NOT_INITIALIZED(5011),
    MAC_POOL_NO_MACS_LEFT(5012),
    MAC_ADDRESS_IS_IN_USE(5013),
    VM_POOL_CANNOT_ALLOCATE_VM(5014),
    // Could not allocate VDS for a new VM to run on
    RESOURCE_MANAGER_CANT_ALLOC_VDS_MIGRATION(5015),
    RESOURCE_MANAGER_MIGRATION_FAILED_AT_DST(5016),
    VM_INVALID_SERVER_CLUSTER_ID(5017),
    VM_TEMPLATE_CANT_LOCATE_DISKS_IN_DB(5018),
    USER_FAILED_POPULATE_DATA(5019),
    VDS_FENCE_OPERATION_FAILED(5021),
    VDS_NETWORK_ERROR(5022),
    NO_FREE_VM_IN_POOL(5023),
    ENGINE_ERROR_CREATING_STORAGE_POOL(5024),
    CANT_RECONSTRUCT_WHEN_A_DOMAIN_IN_POOL_IS_LOCKED(5025),
    NO_PARAMETERS_FOR_TASK(5026),
    HOST_ALREADY_EXISTS(5027),
    NO_ACTIVE_ISO_DOMAIN_IN_DATA_CENTER(5028),
    PROVIDER_FAILURE(5050),
    PROVIDER_SSL_FAILURE(5052),
    FAILED_UPDATE_RUNNING_VM(5053),
    VM_NOT_QUALIFIED_FOR_SNAPSHOT_MERGE(5054),
    VM_HOST_CANNOT_LIVE_MERGE(5055),
    PROVIDER_AUTHENTICATION_FAILURE(5056),
    PROVIDER_IMPORT_CERTIFICATE_ERROR(5059),
    REFRESH_LUN_ERROR(5060),

    // Network Labels
    LABELED_NETWORK_INTERFACE_NOT_FOUND(5200),
    NETWORK_LABEL_CONFLICT(5201),

    // SetupNetwork errors
    SETUP_NETWORKS_ROLLBACK(5300),

    // Cinder errors
    CINDER_ERROR(5400),

    // Update num of vfs
    UPDATE_NUM_VFS_FAILURE(5500),

    // Vm Icons
    VM_ICON_NOT_FOUND(5500),

    // Gluster errors
    NO_UP_SERVER_FOUND(7000),
    // error to indicate backend does not recognize the session

    // migration cancel failed, VM doesn't exist
    MIGRATION_CANCEL_ERROR_NO_VM(5100),

    SESSION_ERROR(9999);

    private int intValue;
    private static final HashMap<Integer, EngineError> mappings = new HashMap<Integer, EngineError>();

    static {
        for (EngineError error : values()) {
            mappings.put(error.getValue(), error);
        }
    }

    private EngineError(int value) {
        intValue = value;
    }

    public int getValue() {
        return intValue;
    }

    public static EngineError forValue(int value) {
        return mappings.get(value);
    }
}
