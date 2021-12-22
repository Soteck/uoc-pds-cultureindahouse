package org.uoc.pds.alpha.cultureindahouse.ejb.pojo;

import java.util.Date;

import lombok.Data;

@Data
public class OrderHistoryVO {

	private Integer id;

	private Date date;

	private EventVO event;

	private UserVO user;

}
