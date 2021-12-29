package org.uoc.pds.alpha.cultureindahouse.ejb.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "label", schema = "pra2")
public class Label {

	@Id
	@Column(name = "id", updatable = false)
	@SequenceGenerator(name = "pra2.label_id_seq", sequenceName = "pra2.label_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pra2.label_id_seq")
	private Integer id;


	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;


	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "label_event",
			schema = "pra2",
			joinColumns = @JoinColumn(name = "label_id"),
			inverseJoinColumns = @JoinColumn(name = "event_id"))
	@ToString.Exclude
	private Collection<Event> events;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Label label = (Label) o;
		return Objects.equals(id, label.id) && Objects.equals(name, label.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
}
