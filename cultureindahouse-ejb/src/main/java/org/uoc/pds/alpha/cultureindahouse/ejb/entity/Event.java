package org.uoc.pds.alpha.cultureindahouse.ejb.entity;

import java.util.*;
import java.util.List;

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

	@Column(name = "location")
	private String location;

	@Column(name = "image")
	private String image;

	@Column(name = "init_date")
	private Date initDate;

	@Column(name = "end_date")
	private Date endDate;

	@ManyToOne
	@JoinColumn(name = "event_organizer_id")
	private EventOrganizer eventOrganizer;

	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<OrderHistory> orderHistory;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;


	@ManyToMany
	@JoinTable(
			name = "label_event",
			joinColumns = @JoinColumn(name = "event_id"),
			inverseJoinColumns = @JoinColumn(name = "label_id"))
	private Collection<Label> labels;

	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<Rating> ratings;

	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<Comment> comments;

	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<Question> questions;

	public Event(String name, String description, String location, String image, Date initDate, Date endDate) {
		this.name = name;
		this.description = description;
		this.location = location;
		this.image = image;
		this.initDate = initDate;
		this.endDate = endDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Event event = (Event) o;
		return Objects.equals(id, event.id) && Objects.equals(name, event.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
}
