package org.uoc.pds.alpha.cultureindahouse.ejb.entity;

import com.sun.istack.internal.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
	@Column(name = "id")
	private int id;

	@NotNull
	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;



}
