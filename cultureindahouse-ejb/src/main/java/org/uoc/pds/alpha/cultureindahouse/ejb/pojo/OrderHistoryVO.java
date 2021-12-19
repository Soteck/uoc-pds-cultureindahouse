package org.uoc.pds.alpha.cultureindahouse.ejb.pojo;

import java.util.Date;

import lombok.Data;

@Data
public class OrderHistoryVO {

	private int id;

	private Date date;

	private String reservationId;

	private String orderId;

	private String eventId;

	private String userId;

}
