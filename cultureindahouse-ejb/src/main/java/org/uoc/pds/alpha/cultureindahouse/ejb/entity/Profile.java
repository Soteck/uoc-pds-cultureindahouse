package org.uoc.pds.alpha.cultureindahouse.ejb.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "profile", schema = "pra2")
public class Profile {

	@Id
	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "name")
	private String name;

	@Column(name = "surnames")
	private String surnames;

	@Column(name = "nif")
	private String nif;

	@Column(name = "preferedLanguage")
	private String preferedLanguage;

	@Column(name = "address")
	private String address;


}
