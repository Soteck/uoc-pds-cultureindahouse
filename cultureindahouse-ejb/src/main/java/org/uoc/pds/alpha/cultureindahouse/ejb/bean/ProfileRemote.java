package org.uoc.pds.alpha.cultureindahouse.ejb.bean;


import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;

import javax.ejb.Remote;

@Remote
public interface ProfileRemote {


	UserVO login(String email, String password);

	UserVO registerUser(UserVO profile);

	UserVO updateUser(UserVO profile);

	UserVO showUser(String email);

}
