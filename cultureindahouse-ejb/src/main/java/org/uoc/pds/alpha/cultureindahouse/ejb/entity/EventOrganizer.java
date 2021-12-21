package org.uoc.pds.alpha.cultureindahouse.ejb.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "eventOrganizer", schema = "pra2")
public class EventOrganizer {

	@Id
	@Column(name = "id", updatable = false)
	@SequenceGenerator(name = "pra2.eventOrganizer_id_seq", sequenceName = "pra2.eventOrganizer_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pra2.eventOrganizer_id_seq")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@ManyToOne
	private User administrator;

	//TODO: ADD EventOrganizerId on Event


}
