package org.uoc.pds.alpha.cultureindahouse.ejb.bean;


import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Category;
import org.uoc.pds.alpha.cultureindahouse.ejb.mapper.CategoryMapper;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.*;
import org.uoc.pds.alpha.cultureindahouse.ejb.repository.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.net.URL;
import java.util.List;

@Stateless
public class EventBean implements EventLocal, EventRemote {

	@EJB
	private OrderHistoryRepositoryInterface orderHistoryRepositoryInterface;
	@EJB
	private EventRepositoryInterface eventRepositoryInterface;

	@Override
	public void orderEvent(int eventId, String email, String reservationId) {

	}

	@Override
	public List<EventVO> listAllEvents() {
		return null;
	}

	@Override
	public List<EventVO> findEventsByCategory(int categoryId) {
		return null;
	}

	@Override
	public List<EventVO> findEventsByName(String name) {
		return null;
	}

	@Override
	public List<EventVO> findEventsByLabel(String label) {
		return null;
	}

	@Override
	public EventVO showEvent(int id) {
		return null;
	}

	@Override
	public EventVO showEvent(String reservationId, URL location) {
		return null;
	}

	@Override
	public List<OrderHistoryVO> findOrdersByUser(String email) {
		return null;
	}

	@Override
	public List<OrderHistoryVO> findAllOrders() {
		return null;
	}

	@Override
	public OrderHistoryVO showOrder(int id) {
		return null;
	}
}
