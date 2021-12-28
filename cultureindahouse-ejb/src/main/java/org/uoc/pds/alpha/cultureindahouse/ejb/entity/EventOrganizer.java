package org.uoc.pds.alpha.cultureindahouse.ejb.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "event_organizer", schema = "pra2")
public class EventOrganizer {

	@Id
	@Column(name = "id", updatable = false)
	@SequenceGenerator(name = "pra2.event_organizer_id_seq", sequenceName = "pra2.event_organizer_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pra2.event_organizer_id_seq")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "administrator_id")
	private User administrator;

	@OneToMany(mappedBy = "eventOrganizer", cascade = CascadeType.PERSIST)
	private List<Event> events;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EventOrganizer that = (EventOrganizer) o;
		return Objects.equals(id, that.id) && Objects.equals(name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
}
