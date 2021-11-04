package org.ovirt.engine.ui.common.widget.uicommon.vm;

import org.ovirt.engine.ui.common.CommonApplicationConstants;
import org.ovirt.engine.ui.common.editor.UiCommonEditorDriver;
import org.ovirt.engine.ui.common.gin.AssetProvider;
import org.ovirt.engine.ui.common.uicommon.model.ModelProvider;
import org.ovirt.engine.ui.common.widget.editor.ListModelListBox;
import org.ovirt.engine.ui.common.widget.editor.generic.StringEntityModelTextBoxOnlyEditor;
import org.ovirt.engine.ui.common.widget.form.FormItem;
import org.ovirt.engine.ui.common.widget.label.StringValueLabel;
import org.ovirt.engine.ui.common.widget.tooltip.WidgetTooltip;
import org.ovirt.engine.ui.common.widget.uicommon.AbstractModelBoundFormWidget;
import org.ovirt.engine.ui.uicommonweb.dataprovider.AsyncDataProvider;
import org.ovirt.engine.ui.uicommonweb.models.vms.ImportSource;
import org.ovirt.engine.ui.uicommonweb.models.vms.VmImportGeneralModel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;

public class VmImportGeneralModelForm extends AbstractModelBoundFormWidget<VmImportGeneralModel> {

    interface Driver extends UiCommonEditorDriver<VmImportGeneralModel, VmImportGeneralModelForm> {
    }

    @Path("name.entity")
    StringEntityModelTextBoxOnlyEditor name = new StringEntityModelTextBoxOnlyEditor();
    StringValueLabel description = new StringValueLabel();
    @UiField(provided = true)
    @Path("operatingSystems.selectedItem")
    ListModelListBox<Integer> operatingSystems;
    @Path("OS")
    StringValueLabel os = new StringValueLabel();
    StringValueLabel template = new StringValueLabel();
    StringValueLabel definedMemory = new StringValueLabel();
    StringValueLabel defaultDisplayType = new StringValueLabel();
    StringValueLabel priority = new StringValueLabel();
    StringValueLabel minAllocatedMemory = new StringValueLabel();
    StringValueLabel guestFreeCachedBufferedMemInfo = new StringValueLabel();
    StringValueLabel usbPolicy = new StringValueLabel();
    StringValueLabel defaultHost = new StringValueLabel();
    StringValueLabel customProperties = new StringValueLabel();
    StringValueLabel domain = new StringValueLabel();
    StringValueLabel compatibilityVersion = new StringValueLabel();
    StringValueLabel vmId = new StringValueLabel();
    StringValueLabel fqdn = new StringValueLabel();
    StringValueLabel cpuInfo = new StringValueLabel();
    StringValueLabel guestCpuCount = new StringValueLabel();
    StringValueLabel quotaName = new StringValueLabel();
    StringValueLabel origin = new StringValueLabel();
    StringValueLabel optimizedForSystemProfile = new StringValueLabel();

    @Ignore
    StringValueLabel monitorCount = new StringValueLabel();

    private static final CommonApplicationConstants constants = AssetProvider.getConstants();

    private final Driver driver = GWT.create(Driver.class);

    public VmImportGeneralModelForm(ModelProvider<VmImportGeneralModel> modelProvider) {
        super(modelProvider, 3, 9);

        operatingSystems = new ListModelListBox<>(new AbstractRenderer<Integer>() {
            @Override
            public String render(Integer object) {
                return AsyncDataProvider.getInstance().getOsName(object);
            }
        });
    }

    @Override
    protected void doEdit(VmImportGeneralModel model) {
        driver.edit(model);

        // Required because of type conversion
        monitorCount.setValue(Integer.toString(getModel().getMonitorCount()));
    }

    @Override
    public void cleanup() {
        driver.cleanup();
    }

    private IsWidget getOperatingSystemWidget() {
        ImportSource source = getModel().getSource();
        return source == ImportSource.EXPORT_DOMAIN ? os : operatingSystems;
    }

    public void initialize() {
        driver.initialize(this);

        name.asValueBox().setWidth("130px"); //$NON-NLS-1$
        name.asValueBox().getElement().getParentElement().getStyle().setTop(0, Style.Unit.PX);
        name.asValueBox().getElement().getParentElement().getStyle().setLeft(-5, Style.Unit.PX);

        operatingSystems.setWidth("130px"); //$NON-NLS-1$

        formBuilder.addFormItem(new FormItem(constants.nameVm(), name, 0, 0));
        formBuilder.addFormItem(new FormItem(constants.osVm(), getOperatingSystemWidget(), 1, 0));
        formBuilder.addFormItem(new FormItem(constants.descriptionVm(), description, 2, 0));
        formBuilder.addFormItem(new FormItem(constants.templateVm(), template, 3, 0));
        formBuilder.addFormItem(new FormItem(constants.videoType(), defaultDisplayType, 4, 0));
        formBuilder.addFormItem(new FormItem(constants.priorityVm(), priority, 5, 0));
        formBuilder.addFormItem(new FormItem(constants.definedMemoryVm(), definedMemory, 6, 0));
        formBuilder.addFormItem(new FormItem(constants.optimizedFor(), optimizedForSystemProfile, 7, 0));

        formBuilder.addFormItem(new FormItem(constants.physMemGauranteedVm(), minAllocatedMemory, 0, 1));
        formBuilder.addFormItem(new FormItem(constants.guestFreeCachedBufferedMemInfo(),
                guestFreeCachedBufferedMemInfo, 1, 1) {
            @Override
            public boolean getIsAvailable() {
                return !getModel().isGuestMemInfoUsingUnusedMem();
            }
        }.withDefaultValue(constants.notConfigured(), () -> getModel().getGuestFreeCachedBufferedMemInfo() == null));
        formBuilder.addFormItem(new FormItem(constants.guestFreeCachedBufferedCombinedMemInfo(),
                guestFreeCachedBufferedMemInfo, 2, 1) {
            @Override
            public boolean getIsAvailable() {
                return getModel().isGuestMemInfoUsingUnusedMem();
            }
        }.withDefaultValue(constants.notConfigured(), () -> getModel().getGuestFreeCachedBufferedMemInfo() == null));
        WidgetTooltip cpuInfoWithTooltip = new WidgetTooltip(cpuInfo);
        cpuInfoWithTooltip.setHtml(SafeHtmlUtils.fromString(constants.numOfCpuCoresTooltip()));
        formBuilder.addFormItem(new FormItem(constants.numOfCpuCoresVm(), cpuInfoWithTooltip, 3, 1));
        formBuilder.addFormItem(new FormItem(constants.GuestCpuCount(), guestCpuCount, 4, 1));
        formBuilder.addFormItem(new FormItem(constants.numOfMonitorsVm(), monitorCount, 5, 1));
        formBuilder.addFormItem(new FormItem(constants.usbPolicyVm(), usbPolicy, 6, 1));

        formBuilder.addFormItem(new FormItem(constants.originVm(), origin, 0, 2));
        formBuilder.addFormItem(new FormItem(constants.runOnVm(), defaultHost, 1, 2));
        formBuilder.addFormItem(new FormItem(constants.customPropertiesVm(), customProperties, 2, 2));
        formBuilder.addFormItem(new FormItem(constants.clusterCompatibilityVersionVm(), compatibilityVersion, 3, 2));
        formBuilder.addFormItem(new FormItem(constants.vmId(), vmId, 4, 2));

        formBuilder.addFormItem(new FormItem(constants.quotaVm(), quotaName, 5, 2) {
            @Override
            public boolean getIsAvailable() {
                return getModel().isQuotaAvailable();
            }
        }.withDefaultValue(constants.notConfigured(), () -> {
            String quotaName = getModel().getQuotaName();
            return quotaName == null || "".equals(quotaName);
        }));
        formBuilder.addFormItem(new FormItem(constants.domainVm(), domain, 6, 2) {
            @Override
            public boolean getIsAvailable() {
                return getModel().getHasDomain();
            }
        });

        formBuilder.addFormItem(new FormItem(constants.fqdn(), fqdn, 7, 2) {
            @Override
            public boolean getIsAvailable() {
                String fqdn = getModel().getFqdn();
                return !(fqdn == null || fqdn.isEmpty());
            }
        });
    }
}
