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
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "eventOrganizer", schema = "pra2")
public class EventOrganizer {

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EventOrganizer profile = (EventOrganizer) o;
		return Objects.equals(email, profile.email) && Objects.equals(password, profile.password) && Objects.equals(name, profile.name) && Objects.equals(surnames, profile.surnames) && Objects.equals(nif, profile.nif) && Objects.equals(preferedLanguage, profile.preferedLanguage) && Objects.equals(address, profile.address);
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, password, name, surnames, nif, preferedLanguage, address);
	}
}
