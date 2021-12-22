package org.uoc.pds.alpha.cultureindahouse.ejb.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor

@Table(name = "event", schema = "pra2")
public class Event {

	@Id
	@Column(name = "id", updatable = false)
	@SequenceGenerator(name = "pra2.event_id_seq", sequenceName = "pra2.event_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pra2.event_id_seq")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "image")
	private String image;

	@Column(name = "init_date")
	private Date initDate;

	@Column(name = "end_date")
	private Date endDate;

	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderHistory> orderHistory;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Event event = (Event) o;
		return Objects.equals(id, event.id) && Objects.equals(name, event.name) && Objects.equals(description, event.description) && Objects.equals(image, event.image) && Objects.equals(initDate, event.initDate) && Objects.equals(endDate, event.endDate) && Objects.equals(orderHistory, event.orderHistory) && Objects.equals(user, event.user) && Objects.equals(category, event.category);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, description, image, initDate, endDate, orderHistory, user, category);
	}
}
