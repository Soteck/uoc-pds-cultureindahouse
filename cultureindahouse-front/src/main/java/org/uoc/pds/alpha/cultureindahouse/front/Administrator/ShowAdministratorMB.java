package org.uoc.pds.alpha.cultureindahouse.front.Administrator;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "ShowAdministratorMB")
public class ShowAdministratorMB {

    @EJB
    private AdministrationLocal administrationLocal;

    @Getter
    @Setter
    private Integer userId = null;

    public UserVO getUser(){
        return administrationLocal.showAdministator(userId);
    }
}
