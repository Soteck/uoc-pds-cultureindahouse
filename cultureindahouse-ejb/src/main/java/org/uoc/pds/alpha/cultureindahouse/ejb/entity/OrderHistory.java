package org.uoc.pds.alpha.cultureindahouse.ejb.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "order_history", schema = "pra2")
public class OrderHistory {

	@Id
	@Column(name = "id", updatable = false)
	@SequenceGenerator(name = "pra2.order_history_id_seq", sequenceName = "pra2.order_history_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pra2.order_history_id_seq")
	private Integer id;

	@Column(name = "date")
	private Date date;

	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		OrderHistory that = (OrderHistory) o;
		return Objects.equals(id, that.id) && Objects.equals(date, that.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, date);
	}
}
