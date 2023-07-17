package com.orange.actions;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.orange.model.EvenementObs;
import com.orange.service.EvenementObsLocalServiceUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import java.util.List;

import static com.orange.constants.PortletParticipantPortletKeys.*;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + PORTLETPARTICIPANT,
                "mvc.command.name=" + HOME_PAGE_PATH
        },
        service = MVCRenderCommand.class
)
public class HomeMVCRenderCommand implements MVCRenderCommand {
    @Reference
    User user;
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        List<EvenementObs> events = EvenementObsLocalServiceUtil.getEvenementObses(0,EvenementObsLocalServiceUtil.getEvenementObsesCount());
        renderRequest.setAttribute(MVC_RENDER_COMMAND, HOME_PAGE_PATH);
        renderRequest.setAttribute(EVENEMENT_PARAM,events);
        return HOME_PAGE_PATH_JSP;
    }
}
