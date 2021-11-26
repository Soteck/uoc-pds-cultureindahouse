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
@Table(name = "category", schema = "pra2")
public class Category {

	@Id
	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Category category = (Category) o;
		return name != null && Objects.equals(name, category.name);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
