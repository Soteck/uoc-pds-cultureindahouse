package org.uoc.pds.alpha.cultureindahouse.ejb.bean;


import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Event;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Label;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.User;
import org.uoc.pds.alpha.cultureindahouse.ejb.helpers.DateHelper;
import org.uoc.pds.alpha.cultureindahouse.ejb.mapper.EventMapper;
import org.uoc.pds.alpha.cultureindahouse.ejb.mapper.UserMapper;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.repository.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Stateless
public class ProfileBean implements ProfileLocal, ProfileRemote {

	@EJB
	private CategoryRepositoryInterface categoryRepository;
	@EJB
	private UserRepositoryInterface userRepository;
	@EJB
	private EventRepositoryInterface eventRepository;
	@EJB
	private EventOrganizerRepositoryInterface eventOrganizerRepository;
	@EJB
	private LabelRepositoryInterface labelRepository;

	@Override
	public UserVO login(String email, String password) {
		User user = userRepository.getUserByEmail(email);

		if (user != null && user.getPassword().equals(password)) {
			return UserMapper.toVO(user, false);
		}
		return null;
	}

	@Override
	public UserVO registerUser(String nif, String email, String password, String name, String surname, String preferedLanguage, String address) {
		UserVO user = new UserVO(email, password, name, surname, nif, preferedLanguage, address);

		user.setAdministrator(false);
		return UserMapper.toVO(userRepository.add(UserMapper.toEntity(user, false)), false);
	}

	@Override
	public UserVO updateUser(String nif, String email, String password, String name, String surname, String preferedLanguage, String address) {
		User user = userRepository.getUserByEmail(email);

		user.setNif(nif);
		user.setPassword(password);
		user.setName(name);
		user.setSurname(surname);
		user.setPreferedLanguage(preferedLanguage);
		user.setAddress(address);

		return UserMapper.toVO(userRepository.update(user.getId(), user), false);
	}

	@Override
	public UserVO showUser(String email) {
		return UserMapper.toVO(userRepository.getUserByEmail(email), true);
	}

	@Override
	public UserVO showUser(int userId) {
		return UserMapper.toVO(userRepository.get(userId), true);
	}

	@Override
	public List<UserVO> listAllUsers() {
		return UserMapper.toVO(userRepository.list(), true);
	}

	@Override
	public List<EventVO> listAllEvents() {
		return EventMapper.toVO(eventRepository.list(), true);
	}

	@Override
	public void deleteUser(int userId) {
		userRepository.delete(userId);
	}


	public void deleteEvent(int eventId) {
		eventRepository.delete(eventId);
	}

	@Override
	public EventVO addEvent(String name, String description, String location, String image,
							String initDate, String endDate, int eventOrganizerId, int categoryId) {

		Event event = new Event(name, description, location, image, DateHelper.parse(initDate), DateHelper.parse(endDate));

		event.setEventOrganizer(eventOrganizerRepository.get(eventOrganizerId));
		event.setCategory(categoryRepository.get(categoryId));

		return EventMapper.toVO(eventRepository.add(event), true);
	}

	@Override
	public EventVO updateEvent(int eventId, String name, String description, String location, String image,
							   String initDate, String endDate, int eventOrganizerId, int categoryId) {

		Event event = eventRepository.get(eventId);


		event.setName(name);
		event.setDescription(description);
		event.setLocation(location);
		event.setImage(image);
		event.setInitDate(DateHelper.parse(initDate));
		event.setEndDate(DateHelper.parse(endDate));

		event.setEventOrganizer(eventOrganizerRepository.get(eventOrganizerId));
		event.setCategory(categoryRepository.get(categoryId));

		return EventMapper.toVO(eventRepository.add(event), true);
	}



	@Override
	public EventVO showEvent(int id) {
		return EventMapper.toVO(eventRepository.get(id), true);
	}

	@Override
	public EventVO showEventByName(String name) {
		return EventMapper.toVO(eventRepository.getEventByName(name), true);
	}


	@Override
	public void addLabelToEvent(int eventId, int labelId) {

		Label label = labelRepository.get(labelId);
		Event event =  eventRepository.get(eventId);

		Collection<Event> labelEvents = label.getEvents();

		if (labelEvents == null || labelEvents.isEmpty()) {
			labelEvents = new ArrayList<>();
		}

		labelEvents.add(event);

		label.setEvents(labelEvents);

		labelRepository.update(label.getId(), label);
	}

	@Override
	public void removeLabelFromEvent(int eventId, int labelId) {

		Label label = labelRepository.get(labelId);


		Collection<Event> labelEvents = label.getEvents();

		if (labelEvents == null || labelEvents.isEmpty()) {
			labelEvents = new ArrayList<>();
		}

		labelEvents = labelEvents.stream().filter(x -> x.getId() != eventId).collect(Collectors.toList());

		label.setEvents(labelEvents);

		labelRepository.update(label.getId(), label);
	}


}
