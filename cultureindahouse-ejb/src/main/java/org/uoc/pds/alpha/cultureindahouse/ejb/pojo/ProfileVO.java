package org.uoc.pds.alpha.cultureindahouse.ejb.pojo;
import lombok.Data;

@Data
public class ProfileVO {

	private String email;
	private String password;
	private String name;
	private String surnames;
	private String nif;
	private String preferedLanguage;
	private String address;

}
