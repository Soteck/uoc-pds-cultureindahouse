package org.uoc.pds.alpha.cultureindahouse.ejb.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.*;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user", schema = "pra2")
public  class User {

	@Id
	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "nif")
	private String nif;

	@Column(name = "preferedLanguage")
	private String preferedLanguage;

	@Column(name = "address")
	private String address;

	@Column(name = "isAdministrator")
	private boolean isAdministrator;

	@OneToMany(mappedBy = "orderHistory")
	private Collection<OrderHistory> orderHistory;


}
