package org.uoc.pds.alpha.cultureindahouse.ejb.entity;


import lombok.*;

import javax.persistence.*;
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
	@Column(name= "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Event.ID")
	private int id;


	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;



	//TODO: ADD EVENTID



}
