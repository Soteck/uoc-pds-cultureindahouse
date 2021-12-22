package org.uoc.pds.alpha.cultureindahouse.ejb.bean;

import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.OrderHistoryVO;

import javax.ejb.Local;
import java.net.URL;
import java.util.List;

@Local
public interface EventLocal {

    void orderEvent(int eventId, String email);

    List<EventVO> listAllEvents();

    List<EventVO> findEventsByCategory(int categoryId);

    List<EventVO> findEventsByName(String name);

    List<EventVO> findEventsByLabel(String label);

    EventVO showEvent(int id);

    EventVO showEvent(String reservationId, URL location);

    List<OrderHistoryVO> findOrdersByUser(String email);

    List<OrderHistoryVO> findAllOrders();

    OrderHistoryVO showOrder(int id);

}
