package org.uoc.pds.alpha.cultureindahouse.ejb.bean;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.OrderHistoryVO;

@Local
public interface EventLocal {

    OrderHistoryVO orderEvent(int eventId, String email);

    List<EventVO> listAllEvents();

    List<EventVO> findEventsByCategory(int categoryId);

    List<EventVO> findEventsByName(String name);

    List<EventVO> findEventsByLabel(int labelId);

    EventVO showEvent(int id);

    EventVO addEvent(String name, String description, String location, String image, Date initDate, Date endDate);

    List<OrderHistoryVO> findOrdersByUser(String email);

    List<OrderHistoryVO> findAllOrders();

    OrderHistoryVO showOrder(int id);

}
