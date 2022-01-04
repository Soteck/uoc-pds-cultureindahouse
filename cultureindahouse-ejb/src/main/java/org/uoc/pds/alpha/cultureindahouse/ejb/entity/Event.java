package org.uoc.pds.alpha.cultureindahouse.ejb.entity;

import java.time.LocalDate;
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
	private LocalDate initDate;

	@Column(name = "end_date")
	private LocalDate endDate;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "event_organizer_id")
	private EventOrganizer eventOrganizer;

	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@ToString.Exclude
	private Collection<OrderHistory> orderHistory;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	@ToString.Exclude
	private Category category;


	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name = "label_event",
			schema = "pra2",
			joinColumns = @JoinColumn(name = "event_id"),
			inverseJoinColumns = @JoinColumn(name = "label_id"))
	@ToString.Exclude
	private Collection<Label> labels;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name = "favorites",
			schema = "pra2",
			joinColumns = @JoinColumn(name = "event_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id"))
	@ToString.Exclude
	private Collection<User> userFavorites;

	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@ToString.Exclude
	private Collection<Rating> ratings;

	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@ToString.Exclude
	private Collection<Comment> comments;

	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@ToString.Exclude
	private Collection<Question> questions;

	public Event(String name, String description, String location, String image, LocalDate initDate, LocalDate endDate) {
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
