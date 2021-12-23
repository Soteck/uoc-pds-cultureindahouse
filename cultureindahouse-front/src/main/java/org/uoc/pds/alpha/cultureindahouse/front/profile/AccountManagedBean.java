package org.uoc.pds.alpha.cultureindahouse.front.profile;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.ProfileLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@SessionScoped
@ManagedBean(name = "accountManagedBean")
public class AccountManagedBean {

	@EJB
	private ProfileLocal profileLocal;

	private boolean isLogin = false;

	@Getter
	@Setter
	private UserVO profile;
	private String message = "";

	public AccountManagedBean() {
		this.profile = new UserVO();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	public void verifyLogin() {
		if (!this.isLogin) {
			doRedirect("login.xhtml");
		}
	}

	public void login() {
		this.profile = this.profileLocal.login(this.profile.getEmail(), this.profile.getPassword());
		if (this.profile != null) {
//			FacesContext.getCurrentInstance().getExternalContext().add
			this.isLogin = true;
			this.message = "";
			doRedirect("welcome.xhtml");
		} else {
			this.message = "Account's Invalid";
			doRedirect("login.xhtml");
		}
	}

	public void logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		this.isLogin = false;
		doRedirect("login.xhtml");
	}

	private void doRedirect(String url) {
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.getExternalContext().redirect(url);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
