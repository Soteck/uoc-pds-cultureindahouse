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
@Table(name = "event", schema = "pra2")
public class Event {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "image")
	private String image;

	@Column(name = "initDate")
	private String initDate;

	@Column(name = "endDate")
	private String endDate;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Event event = (Event) o;
		return id == event.id && Objects.equals(name, event.name) && Objects.equals(description, event.description) && Objects.equals(image, event.image) && Objects.equals(initDate, event.initDate) && Objects.equals(endDate, event.endDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, description, image, initDate, endDate);
	}
}
