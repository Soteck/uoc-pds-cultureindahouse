package org.uoc.pds.alpha.cultureindahouse.ejb.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Event;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
public class CategoryVO implements Serializable {


	public CategoryVO(String name, String description) {
		this.name = name;
		this.description = description;
	}

	private Integer id;

	private String name;

	private String description;

	private Collection<EventVO> events;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CategoryVO that = (CategoryVO) o;
		return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, description);
	}
}
