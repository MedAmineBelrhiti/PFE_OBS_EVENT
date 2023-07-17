package com.orange.actions;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.orange.service.ContactSupportLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import static com.orange.constants.PortletManagerPortletKeys.*;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" +PORTLETMANAGER,
                "mvc.command.name=addReclamation"
        },
        service = MVCActionCommand.class
)
public class AddReclamationMvcActionCommand extends BaseMVCActionCommand {
    @Reference
    ContactSupportLocalService reclamation;
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        String nom = ParamUtil.getString(actionRequest,NOM);
        String prenom = ParamUtil.getString(actionRequest,PRENOM);
        String entite = ParamUtil.getString(actionRequest,ENTITE);
        String objet = ParamUtil.getString(actionRequest,OBJET);
        String email = ParamUtil.getString(actionRequest,EMAIL);
        String telephone = ParamUtil.getString(actionRequest,TELEPHONE);
        String message = ParamUtil.getString(actionRequest,MESSAGE);

        reclamation.addReclamataion(nom,prenom,entite,objet,email,telephone,message);

    }
}
