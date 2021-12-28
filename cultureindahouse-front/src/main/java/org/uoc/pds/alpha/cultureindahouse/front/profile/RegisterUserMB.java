package org.uoc.pds.alpha.cultureindahouse.front.profile;

import lombok.Getter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.ProfileLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "RegisterUserMB")
public class RegisterUserMB {

	@EJB
	private ProfileLocal profileLocal;

	@Getter
	private UserVO user = new UserVO();

	public Object guardarUsuario() {
		profileLocal.registerUser(user.getNif(),user.getEmail(), user.getPassword(), user.getName(), user.getSurname(), user.getPreferedLanguage(), user.getAddress());
		return "listCategoryView.xhtml";
	}
}
