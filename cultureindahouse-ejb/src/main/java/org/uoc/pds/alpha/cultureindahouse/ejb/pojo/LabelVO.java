package org.uoc.pds.alpha.cultureindahouse.ejb.pojo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Event;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
public class LabelVO {

	private Integer id;

	private String name;

	private String description;

	private Collection<EventVO> events;

	public LabelVO(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LabelVO labelVO = (LabelVO) o;
		return Objects.equals(id, labelVO.id) && Objects.equals(name, labelVO.name) && Objects.equals(description, labelVO.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, description);
	}
}
