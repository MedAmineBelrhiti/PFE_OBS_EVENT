package com.orange.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;

import static com.orange.constants.AdminPortletKeys.*;

/**
 * @author QJDY2305
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Admin",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=" + PAGE_LIST,
		"javax.portlet.name=" + ADMIN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AdminPortlet extends MVCPortlet {

	@Reference(target = "(&(javax.portlet.name=" + ADMIN +")(mvc.command.name=" + PATH + "))")
	private MVCRenderCommand viewRenderCommand;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		String view = viewRenderCommand.render(renderRequest, renderResponse);
		include(view, renderRequest, renderResponse);
	}
}