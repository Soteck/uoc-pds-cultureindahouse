package org.uoc.pds.alpha.cultureindahouse.front.profile;

import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.ProfileLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ViewScoped
@ManagedBean(name = "ListUsersMB")
public class ListUsersMB {

	@EJB
	private ProfileLocal profileLocal;


	@EJB
	private AdministrationLocal administratorLocal;

	public void deleteUser(int userId) {
		profileLocal.deleteUser(userId);
	}

	public List<UserVO> getUsers() {
		return profileLocal.listAllUsers();
	}

	public void promoteAdmin(int userId) {
		administratorLocal.promoteAdministrator(userId);
	}

	public void promoteSuperAdmin(int userId) {
		administratorLocal.promoteSuperAdministrator(userId);
	}

	public String Administration() {
		return "administrationView.xhtml";
	}

	public String ProfileView() {
		return "ProfileView.xhtml";
	}

	public String errorLogin() {
		return "ErrorLoginView.xhtml";
	}

	public String errorSALogin() {
		return "ErrorLoginSAView.xhtml";
	}

	public String errorAdministration() {
		return "ErrorView.xhtml";
	}

	public String errorEvent() {
		return "event/ErrorView.xhtml";
	}

	public String errorMedia() {
		return "media/ErrorView.xhtml";
	}

	public String errorProfile() {
		return "private/ErrorView.xhtml";
	}

}
