package org.uoc.pds.alpha.cultureindahouse.front.profile;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.ProfileLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.CategoryVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.Objects;

@ViewScoped
@ManagedBean(name = "EditUserMB")
public class EditUserMB {

	@EJB
	private ProfileLocal profileLocal;


	@ManagedProperty("#{accountManagedBean}")
	@Getter
	@Setter
	private AccountManagedBean accountManagedBean;

	@Getter
	@Setter
	private Integer userId = null;

	@Setter
	private UserVO user;

	public UserVO getUser(){
		if(user == null || !(Objects.equals(user.getId(), userId))){
			user = profileLocal.showUser(userId);
		}
		return user;
	}


	public Object updateUser() {
		this.user = profileLocal.updateUser(
				user.getNif(), user.getEmail(), user.getPassword(), user.getName(),
				user.getSurname(), user.getPreferedLanguage(), user.getAddress()
		);
		accountManagedBean.checkUserAndUpdateIfNeeded(this.user);
		this.userId = null;
		this.user = null;
		return "ProfileView.xhtml";
    }
}
