package org.uoc.pds.alpha.cultureindahouse.ejb.entity;

import com.sun.istack.internal.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "eventOrganizer", schema = "pra2")
public class EventOrganizer {

	@Id
	@Column(name= "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Event.ID")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@ManyToOne
	private User administrator;

	//TODO: ADD EventOrganizerId on Event


}
