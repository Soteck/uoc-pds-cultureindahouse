package org.uoc.pds.alpha.cultureindahouse.ejb.pojo;

import java.util.Date;
import java.util.Objects;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderHistoryVO {

	private Integer id;

	private Date date;

	private EventVO event;

	private UserVO user;

	public OrderHistoryVO(Date date, EventVO event, UserVO user) {
		this.date = date;
		this.event = event;
		this.user = user;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		OrderHistoryVO that = (OrderHistoryVO) o;
		return Objects.equals(id, that.id) && Objects.equals(date, that.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, date);
	}
}
