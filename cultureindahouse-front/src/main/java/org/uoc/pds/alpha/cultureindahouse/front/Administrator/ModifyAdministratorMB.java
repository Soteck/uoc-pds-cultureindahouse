package org.uoc.pds.alpha.cultureindahouse.front.Administrator;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "ModifyAdministratorMB")
public class ModifyAdministratorMB {

    @EJB
    private AdministrationLocal administratorLocal;

    @Getter
    @Setter
    protected Integer userId = null;
    private UserVO user;

    /* Error en la liena 28 NullPointerException otras funciones similares funcionan
    public LabelVO getLabel(){
        if(label == null || !(label.getId() == labelId)){
            label = labelLocal.showLabel(labelId);
        }
        return label;
    }
    */

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
