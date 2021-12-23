package org.uoc.pds.alpha.cultureindahouse.ejb.bean;

import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.*;

import javax.ejb.Remote;
import java.util.Date;
import java.util.List;

@Remote
public interface EventRemote {

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
