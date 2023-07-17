package com.orange.actions;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.orange.model.DemandEventObs;
import com.orange.service.DemandEventObsLocalService;
import com.orange.service.DemandEventObsLocalServiceUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

import static com.orange.constants.PortletCommunicationPortletKeys.*;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name="+PORTLETCOMMUNICATION,
                "mvc.command.name=" + PATH_LIST_DEMAND
        },
        service = MVCRenderCommand.class
)
public class DemandListMVCRenderCommand implements MVCRenderCommand {
    @Reference
    DemandEventObsLocalService demandEventObsLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        List<DemandEventObs> listDemand = DemandEventObsLocalServiceUtil.getDemandEventObses(0, DemandEventObsLocalServiceUtil.getDemandEventObsesCount());

        boolean allApproved = true;

        for (DemandEventObs demand : listDemand) {
            if (!APPROVED.equals(demand.getStatus())) {
                allApproved = false;
                break;
            }
        }
        renderRequest.setAttribute(MVC_RENDER_COMMAND,PATH_LIST_DEMAND);
        renderRequest.setAttribute(LIST_DEMAND_PARAM,demandEventObsLocalService.findByStatus(WAITING));
        renderRequest.setAttribute(ALL_APPROVED_PARAM,allApproved);
        return LIST_DEMAND_JSP;
    }
}
