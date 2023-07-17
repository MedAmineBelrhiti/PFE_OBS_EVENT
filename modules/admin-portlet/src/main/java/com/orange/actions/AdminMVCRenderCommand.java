package com.orange.actions;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.orange.model.ContactSupport;
import com.orange.service.ContactSupportLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

import static com.orange.constants.AdminPortletKeys.ADMIN;
import static com.orange.constants.AdminPortletKeys.PATH;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" +ADMIN,
                "mvc.command.name=" +PATH
        },
        service = MVCRenderCommand.class
)
public class AdminMVCRenderCommand implements MVCRenderCommand {
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        List<User> users = UserLocalServiceUtil.getUsers(0,UserLocalServiceUtil.getUsersCount());
        List<ContactSupport> reclamations = ContactSupportLocalServiceUtil.getContactSupports(0,ContactSupportLocalServiceUtil.getContactSupportsCount());

        renderRequest.setAttribute("mvcRenderCommandName", PATH);
        renderRequest.setAttribute("users", users);
        renderRequest.setAttribute("reclamations", reclamations);

        return "/view.jsp";
    }
}
