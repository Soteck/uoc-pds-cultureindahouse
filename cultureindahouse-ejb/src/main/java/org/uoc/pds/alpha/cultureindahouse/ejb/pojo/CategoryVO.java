package org.uoc.pds.alpha.cultureindahouse.ejb.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryVO implements Serializable {

	private String name;

	private String description;

}
