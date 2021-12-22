package org.uoc.pds.alpha.cultureindahouse.ejb.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

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

	@Column(name = "reservation_id")
	private String reservationId;

	@Column(name = "order_id")
	private String orderId;

	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;



}
