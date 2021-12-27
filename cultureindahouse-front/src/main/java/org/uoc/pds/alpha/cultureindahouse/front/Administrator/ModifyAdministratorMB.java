package org.uoc.pds.alpha.cultureindahouse.front.Administrator;

import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "ModifyAdministratorMB")
public class ModifyAdministratorMB {

    @EJB
    private AdministrationLocal administratorLocal;


    protected Integer userId = null;
    private UserVO user;

    public UserVO getUser(){
        if(user == null || !(user.getId() == userId)){
            user = administratorLocal.showAdministator(userId);
        }
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }


    public Object actualizarAdministrator() {
        administratorLocal.updateAdministrator(userId,user.getName(), user.getSurname(), user.getPassword(), user.getEmail());
        this.userId = null;
        this.user = null;
        return "AdministrationListView.xhtml";
    }

}
