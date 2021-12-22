package org.uoc.pds.alpha.cultureindahouse.ejb.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public  class UserVO {

	public UserVO(String email, String password, String name, String surname) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
	}

	private Integer id;


	private String email;


	private String password;


	private String name;


	private String surname;


	private String nif;


	private String preferedLanguage;


	private String address;


	private boolean isAdministrator;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UserVO userVO = (UserVO) o;
		return Objects.equals(id, userVO.id) && Objects.equals(email, userVO.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, email);
	}
}
