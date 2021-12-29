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


	@Getter
	private UserVO loggedUser = null;

	@Getter
	@Setter
	private String email;

	@Getter
	@Setter
	private String password;


	@Getter
	@Setter
	private String message;

	public boolean isLogged(){
		return loggedUser != null;
	}


	public Object login(){
		message = null;
		loggedUser = null;
		loggedUser = profileLocal.login(email, password);
		password = null;
		if(loggedUser == null){
			message = "Username or password not correct";
			return null;
		}

		return "index.xhtml";
	}


	public Object logout(){
		message = null;
		loggedUser = null;
		email = null;
		password = null;

		return "index.xhtml";
	}

}
