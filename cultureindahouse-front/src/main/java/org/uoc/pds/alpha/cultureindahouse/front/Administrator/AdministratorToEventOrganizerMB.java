package org.uoc.pds.alpha.cultureindahouse.front.Administrator;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventOrganizerVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "AdministratorToEventOrganizerMB")
public class AdministratorToEventOrganizerMB {

    @EJB
    private AdministrationLocal administratorToEventLocal;

    @Getter
    @Setter
    protected Integer userId = null;
    private UserVO user;

    public Object addEventOrganizer() {
        administratorToEventLocal.updateAdministrator(userId,user.getName(), user.getSurname(), user.getPassword(), user.getEmail());
        this.userId = null;
        this.user = null;
        return "AdministrationListView.xhtml";
    }


}
