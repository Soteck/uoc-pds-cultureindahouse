package org.uoc.pds.alpha.cultureindahouse.front.profile;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.CategoryVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "RegisterUserMB")
public class RegisterUserMB {

	@EJB
	private AdministrationLocal administrationLocal;

	@Getter
	private UserVO user = new UserVO();

	public Object guardarUsuario() {
		administrationLocal.addUser(user.getEmail(), user.getPassword(), user.getName(), user.getSurname());
		return "listCategoryView.xhtml";
	}
}
