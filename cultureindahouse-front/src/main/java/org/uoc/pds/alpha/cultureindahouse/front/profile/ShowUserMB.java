package org.uoc.pds.alpha.cultureindahouse.front.profile;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.ProfileLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "ShowUserMB")
public class ShowUserMB {

	@EJB
	private ProfileLocal profileLocal;

	@Getter
	@Setter
	private Integer userId = null;

	public UserVO getUser(){
		return profileLocal.showUser(userId);
	}



	public String ProfileView() { return "ProfileView.xhtml"; }
}
