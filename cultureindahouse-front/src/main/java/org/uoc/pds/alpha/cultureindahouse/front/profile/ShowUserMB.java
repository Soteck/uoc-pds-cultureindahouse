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
@ManagedBean(name = "ShowUserMB")
public class ShowUserMB {

	@EJB
	private AdministrationLocal categoryLocal;

	@Getter
	@Setter
	private Integer userId = null;

	public UserVO getUser(){
		return categoryLocal.showUser(userId);
	}

}
