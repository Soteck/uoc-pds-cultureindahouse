package org.uoc.pds.alpha.cultureindahouse.ejb.bean;


import org.uoc.pds.alpha.cultureindahouse.ejb.entity.*;
import org.uoc.pds.alpha.cultureindahouse.ejb.mapper.EventMapper;
import org.uoc.pds.alpha.cultureindahouse.ejb.mapper.OrderHistoryMapper;
import org.uoc.pds.alpha.cultureindahouse.ejb.mapper.UserMapper;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.OrderHistoryVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.repository.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

@Stateless
public class EventBean implements EventLocal, EventRemote {

	@EJB
	private OrderHistoryRepositoryInterface orderHistoryRepository;

	@EJB
	private EventRepositoryInterface eventRepository;

	@EJB
	private UserRepositoryInterface userRepository;

	@EJB
	private CategoryRepositoryInterface categoryRepository;

	@EJB
	private LabelRepositoryInterface labelRepository;

	@Override
	public OrderHistoryVO orderEvent(int eventId, String email) {

		Event event = eventRepository.get(eventId);

		User user = userRepository.getUserByEmail(email);

		OrderHistoryVO orderHistory = new OrderHistoryVO(Calendar.getInstance().getTime(), EventMapper.toVO(event, true), UserMapper.toVO(user, true));

		OrderHistory order = orderHistoryRepository.add(OrderHistoryMapper.toEntity(orderHistory, true));


		return OrderHistoryMapper.toVO(order, true);
	}

	@Override
	public List<EventVO> listAllEvents() {
		return EventMapper.toVO(eventRepository.list(), true);
	}

	@Override
	public List<EventVO> findEventsByCategory(int categoryId) {

		ArrayList<EventVO> ret = new ArrayList<EventVO>();
		Category category = categoryRepository.get(categoryId);

		Collection<Event> events = category.getEvents();

		if (events != null && !events.isEmpty()) {
			ret = new ArrayList<>(EventMapper.toVO(events, true));
		}

		return ret;
	}

	@Override
	public List<EventVO> findEventsByName(String name) {
		return EventMapper.toVO(eventRepository.getEventsByName(name), true);
	}

	@Override
	public List<EventVO> findEventsByLabel(int labelId) {
		List<EventVO> ret = null;
		Label label = labelRepository.get(labelId);

		List<Event> events = label.getEvents();

		if (events != null && !events.isEmpty()) {
			ret = EventMapper.toVO(events, true);
		}

		return ret;
	}

	@Override
	public EventVO showEvent(int id) {
		return EventMapper.toVO(eventRepository.get(id), true);
	}


	@Override
	public List<OrderHistoryVO> findOrdersByUser(String email) {
		List<OrderHistory> orders = userRepository.getUserByEmail(email).getOrderHistory();
		List<OrderHistoryVO> ret = null;

		if (orders != null && !orders.isEmpty()) {
			ret = OrderHistoryMapper.toVO(orders, false);
		}

		return ret;
	}

	@Override
	public List<OrderHistoryVO> findAllOrders() {


		return OrderHistoryMapper.toVO(orderHistoryRepository.list(), false);
	}

	@Override
	public OrderHistoryVO showOrder(int id) {


		return OrderHistoryMapper.toVO(orderHistoryRepository.get(id), false);
	}
}
