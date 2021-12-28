package org.uoc.pds.alpha.cultureindahouse.front.profile;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.ProfileLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@SessionScoped
@ManagedBean(name = "accountManagedBean")
public class AccountManagedBean {

	@EJB
	private ProfileLocal profileLocal;

//	@PostConstruct
//	public void init() {
//		String remoteUser = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
//
//		user = profileLocal.showUser(remoteUser);
//	}

	private UserVO user;

	public String getUsername(){
		if( user == null){
			return null;
		}
		return user.getName();
	}





}
