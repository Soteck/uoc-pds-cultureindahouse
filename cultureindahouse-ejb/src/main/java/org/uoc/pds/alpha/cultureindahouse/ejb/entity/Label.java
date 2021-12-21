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
	@Column(name = "id", updatable = false)
	@SequenceGenerator(name = "pra2.label_id_seq", sequenceName = "pra2.label_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pra2.label_id_seq")
	private Integer id;


	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;



	//TODO: ADD EVENTID



}
