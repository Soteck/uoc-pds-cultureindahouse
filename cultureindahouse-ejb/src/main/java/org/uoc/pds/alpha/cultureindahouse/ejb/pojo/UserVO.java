package org.uoc.pds.alpha.cultureindahouse.ejb.pojo;

import lombok.Data;

@Data
public  class UserVO {


	private String email;


	private String password;


	private String name;


	private String surname;


	private String nif;


	private String preferedLanguage;


	private String address;


	private boolean isAdministrator;


}
