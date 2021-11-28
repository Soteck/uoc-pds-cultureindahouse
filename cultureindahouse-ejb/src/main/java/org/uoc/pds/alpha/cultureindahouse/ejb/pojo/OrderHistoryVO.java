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
@NoArgsConstructor
@Table(name = "orderHistory", schema = "pra2")
public class OrderHistory {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "date")
	private Date date;

	@Column(name = "reservationId")
	private String reservationId;

	@Column(name = "orderId")
	private String orderId;

	@Column(name = "eventId")
	private String eventId;

	@Column(name = "userId")
	private String userId;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		OrderHistory that = (OrderHistory) o;
		return id == that.id && Objects.equals(date, that.date) && Objects.equals(reservationId, that.reservationId) && Objects.equals(orderId, that.orderId) && Objects.equals(eventId, that.eventId) && Objects.equals(userId, that.userId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, date, reservationId, orderId, eventId, userId);
	}
}
