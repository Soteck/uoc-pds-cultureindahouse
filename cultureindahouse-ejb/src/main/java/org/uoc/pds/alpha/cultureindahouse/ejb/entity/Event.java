package org.uoc.pds.alpha.cultureindahouse.ejb.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
	@Column(name= "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Event.ID")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "image")
	private String image;

	@Column(name = "initDate")
	private Date initDate;

	@Column(name = "endDate")
	private Date endDate;

	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderHistory> orderHistory;

}
