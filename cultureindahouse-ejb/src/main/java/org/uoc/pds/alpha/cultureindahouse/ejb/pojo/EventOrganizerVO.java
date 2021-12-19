package org.uoc.pds.alpha.cultureindahouse.ejb.pojo;

import lombok.Data;

@Data
public class EventOrganizerVO {

	private Integer id;

	private String name;

	private String description;

	private UserVO administrator;

}
