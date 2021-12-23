package org.uoc.pds.alpha.cultureindahouse.ejb.bean;


import lombok.var;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Event;
import org.uoc.pds.alpha.cultureindahouse.ejb.mapper.EventMapper;
import org.uoc.pds.alpha.cultureindahouse.ejb.mapper.OrderHistoryMapper;
import org.uoc.pds.alpha.cultureindahouse.ejb.mapper.UserMapper;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.OrderHistoryVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.repository.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.criteria.Order;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

        var event = eventRepository.get(eventId);

        var user = userRepository.getUserByEmail(email);

        OrderHistoryVO orderHistory = new OrderHistoryVO(Calendar.getInstance().getTime(), EventMapper.toVO(event), UserMapper.toVO(user));

        var order = orderHistoryRepository.add(OrderHistoryMapper.toEntity(orderHistory));


        return OrderHistoryMapper.toVO(order);
    }

    @Override
    public EventVO addEvent(String name, String description, String location, String image, Date initDate, Date endDate) {

        var event = new Event(name, description, location, image, initDate, endDate);

        return EventMapper.toVO(eventRepository.add(event));
    }

    @Override
    public List<EventVO> listAllEvents() {
        return EventMapper.toVO(eventRepository.list());
    }

    @Override
    public List<EventVO> findEventsByCategory(int categoryId) {

		var ret = new ArrayList<EventVO>();
		var category = categoryRepository.get(categoryId);

		var events = category.getEvents();

		if (events != null && !events.isEmpty()){
			ret = new ArrayList<>(EventMapper.toVO(new ArrayList<>(events)));
		}

		return ret;
    }

    @Override
    public List<EventVO> findEventsByName(String name) {
        return EventMapper.toVO(eventRepository.getEventByName(name));
    }

    @Override
    public List<EventVO> findEventsByLabel(int labelId) {
		var ret = new ArrayList<EventVO>();
		var label = labelRepository.get(labelId);

		var events = label.getEvents();

		if (events != null && !events.isEmpty()){
			ret = new ArrayList<>(EventMapper.toVO(new ArrayList<>(events)));
		}

		return ret;
    }

    @Override
    public EventVO showEvent(int id) {
        return EventMapper.toVO(eventRepository.get(id));
    }


    @Override
    public List<OrderHistoryVO> findOrdersByUser(String email) {
        var orders = userRepository.getUserByEmail(email).getOrderHistory();
        var ret = new ArrayList<OrderHistoryVO>();

        if (orders != null && !orders.isEmpty()){
            ret = new ArrayList<>(OrderHistoryMapper.toVO(new ArrayList<>(orders)));
        }

        return ret;
    }

    @Override
    public List<OrderHistoryVO> findAllOrders() {


        return OrderHistoryMapper.toVO(orderHistoryRepository.list());
    }

    @Override
    public OrderHistoryVO showOrder(int id) {


        return OrderHistoryMapper.toVO(orderHistoryRepository.get(id));
    }
}
