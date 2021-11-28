package org.uoc.pds.alpha.cultureindahouse.ejb.pojo;
import java.sql.Date;

import lombok.Data;

@Data
public class EventVO {

	private int id;

	private String name;

	private String description;

	private String image;

	private Date initDate;

	private Date endDate;

}
