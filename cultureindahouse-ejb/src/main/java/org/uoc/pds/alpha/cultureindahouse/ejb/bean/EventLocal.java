package org.uoc.pds.alpha.cultureindahouse.ejb.bean;

import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.OrderHistoryVO;

import javax.ejb.Local;
import java.util.List;

@Local
public interface EventLocal {

	OrderHistoryVO orderEvent(int eventId, int userId);

	List<EventVO> listAllEvents();

	List<EventVO> findEventsByCategory(int categoryId);

	List<EventVO> findEventsByName(String name);

	List<EventVO> findEventsByLabel(int labelId);

	EventVO showEvent(int id);

	List<OrderHistoryVO> findOrdersByUser(int userId);

	List<OrderHistoryVO> findOrdersByUser(String email);

	List<OrderHistoryVO> findAllOrders();

	OrderHistoryVO showOrder(int id);

}
