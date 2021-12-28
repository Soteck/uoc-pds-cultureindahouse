package org.uoc.pds.alpha.cultureindahouse.front.Administrator;

import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@SessionScoped
@ManagedBean(name = "ListAdministratorsMB")
public class ListAdministratorsMB {

    @EJB
    private AdministrationLocal administratorLocal;

    public List<UserVO> getAdministrators() {
        return administratorLocal.listAllAdministrators();
    }

    public String listAdministrators() {
        return "AdministratorListView.xhtml";
    }
    public String Administration() { return "administrationView.xhtml"; }
    public String errorLabel() { return "ErrorView.xhtml"; }

}
