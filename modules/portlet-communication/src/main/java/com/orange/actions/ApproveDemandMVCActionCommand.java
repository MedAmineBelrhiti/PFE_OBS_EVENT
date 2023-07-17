package com.orange.actions;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.orange.service.DemandEventObsLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ProcessAction;

import static com.orange.constants.PortletCommunicationPortletKeys.*;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + PORTLETCOMMUNICATION,
                "mvc.command.name=" + PATH_APPROVE_DEMAND
        },
        service = MVCActionCommand.class)
public class ApproveDemandMVCActionCommand extends BaseMVCActionCommand {
    @Reference
    DemandEventObsLocalService demandEventObsLocalService;
    @ProcessAction(name = "approveDemand")
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        long idDemand = ParamUtil.getLong(actionRequest,ID_DEMAND);
        demandEventObsLocalService.ApproveDemand(idDemand);
    }
}
