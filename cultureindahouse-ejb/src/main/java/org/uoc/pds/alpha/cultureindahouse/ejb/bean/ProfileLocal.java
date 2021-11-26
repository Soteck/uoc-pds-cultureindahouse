package org.uoc.pds.alpha.cultureindahouse.ejb.bean;

import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.ProfileVO;

import javax.ejb.Local;

@Local
public interface ProfileLocal {


	ProfileVO login(String email, String password);

	ProfileVO registerUser(ProfileVO profile);

	ProfileVO updateUser(ProfileVO profile);

	ProfileVO showUser(String email);

}
