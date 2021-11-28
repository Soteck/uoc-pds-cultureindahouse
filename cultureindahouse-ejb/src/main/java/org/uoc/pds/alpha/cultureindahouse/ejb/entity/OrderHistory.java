package org.uoc.pds.alpha.cultureindahouse.ejb.entity;

import com.sun.istack.internal.NotNull;
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

	@ManyToOne
	@JoinColumn(name = "eventId")
	private Event event;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;



}
