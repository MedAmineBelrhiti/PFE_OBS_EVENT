package com.orange.actions;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.orange.service.DemandEventObsLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import static com.orange.constants.PortletManagerPortletKeys.*;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + PORTLETMANAGER,
                "mvc.command.name=addDemand"
        },
        service = MVCActionCommand.class )
public class AddDemandMVCActionCommand extends BaseMVCActionCommand {
    @Reference
    DemandEventObsLocalService demandEventObsLocalService;
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        String content = ParamUtil.getString(actionRequest,CONTENT);
        String firstName = ParamUtil.getString(actionRequest,FIRST_NAME);
        String lastName = ParamUtil.getString(actionRequest,LAST_NAME);
        demandEventObsLocalService.addDemand(content,firstName,lastName);
    }
}
