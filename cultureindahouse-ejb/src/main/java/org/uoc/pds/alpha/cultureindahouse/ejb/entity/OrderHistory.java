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
@Table(name = "orderHistory", schema = "pra2")
public class OrderHistory {

	@Id
	@Column(name = "id", updatable = false)
	@SequenceGenerator(name = "pra2.orderHistory_id_seq", sequenceName = "pra2.orderHistory_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pra2.orderHistory_id_seq")
	private Integer id;

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
