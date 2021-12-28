package org.uoc.pds.alpha.cultureindahouse.front.profile;

import org.uoc.pds.alpha.cultureindahouse.ejb.bean.ProfileLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@SessionScoped
@ManagedBean(name = "ListUsersMB")
public class ListUsersMB {

	@EJB
	private ProfileLocal profileLocal;

	public void deleteUser(int userId){ profileLocal.deleteUser(userId); }

	public List<UserVO> getUsers() {
		return profileLocal.listAllUsers();
	}

	public String listCategories() {
		return "listUserView.xhtml";
	}
	public String Administration() { return "administrationView.xhtml"; }

	public String errorAdministration() { return "ErrorView.xhtml"; }
	public String errorEvent() { return "event/ErrorView.xhtml"; }
	public String errorMedia() { return "media/ErrorView.xhtml"; }
	public String errorProfile() { return "private/ErrorView.xhtml"; }

}
