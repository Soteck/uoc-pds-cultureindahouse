package org.uoc.pds.alpha.cultureindahouse.ejb.bean;


import lombok.var;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Event;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.User;
import org.uoc.pds.alpha.cultureindahouse.ejb.mapper.EventMapper;
import org.uoc.pds.alpha.cultureindahouse.ejb.mapper.UserMapper;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.repository.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Date;
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
        User user = userRepository.get(email);
        if (user.getPassword().equals(password)) {
            return UserMapper.toVO(user);
        }
        return null;
    }

    @Override
    public UserVO registerUser(String nif, String email, String password, String name, String surname, String preferedLanguage, String address) {
        UserVO user = new UserVO(email, password, name, surname, nif, preferedLanguage, address);

        return UserMapper.toVO(userRepository.add(UserMapper.toEntity(user)));
    }

    @Override
    public UserVO updateUser(String nif, String email, String password, String name, String surname, String preferedLanguage, String address) {
        var user = userRepository.getUserByEmail(email);

        user.setNif(nif);
        user.setPassword(password);
        user.setName(name);
        user.setSurname(surname);
        user.setPreferedLanguage(preferedLanguage);
        user.setAddress(address);

        return UserMapper.toVO(userRepository.update(user.getId(), user));
    }

    @Override
    public UserVO showUser(String email) {
        return UserMapper.toVO(userRepository.getUserByEmail(email));
    }


    @Override
    public EventVO addEvent(String name, String description, String location, String image, Date initDate, Date endDate, int eventOrganizerId) {

        var event = new Event(name, description, location, image, initDate, endDate);

        event.setEventOrganizer(eventOrganizerRepository.get(eventOrganizerId));

        return EventMapper.toVO(eventRepository.add(event));
    }

    @Override
    public EventVO updateEvent(int eventId, String name, String description, String location, String image, Date initDate, Date endDate, int eventOrganizerId) {

        var event = eventRepository.get(eventId);


        event.setName(name);
        event.setDescription(description);
        event.setLocation(location);
        event.setImage(image);
        event.setInitDate(initDate);
        event.setEndDate(endDate);

        event.setEventOrganizer(eventOrganizerRepository.get(eventOrganizerId));

        return EventMapper.toVO(eventRepository.add(event));
    }


    @Override
    public EventVO showEvent(String name) {
        return EventMapper.toVO(eventRepository.getEventByName(name));
    }


    @Override
    public void addCategoryToEvent(int eventId, int categoryId) {

        var category = categoryRepository.get(categoryId);
        var event = eventRepository.get(eventId);

        event.setCategory(category);

        eventRepository.update(event.getId(), event);
    }

    @Override
    public void removeCategoryFromEvent(int eventId) {

        var event = eventRepository.get(eventId);

        event.setCategory(null);

        eventRepository.update(event.getId(), event);
    }

    @Override
    public void addLabelToEvent(int eventId, int labelId) {

        var label = labelRepository.get(labelId);
        var event = eventRepository.get(eventId);

        var labelEvents = label.getEvents();

        if (labelEvents == null || labelEvents.isEmpty()) {
            labelEvents = new ArrayList<>();
        }

        labelEvents.add(event);

        label.setEvents(labelEvents);

        labelRepository.update(label.getId(), label);
    }

    @Override
    public void removeLabelFromEvent(int eventId, int labelId) {

        var label = labelRepository.get(labelId);


        var labelEvents = label.getEvents();

        if (labelEvents == null || labelEvents.isEmpty()) {
            labelEvents = new ArrayList<>();
        }

        labelEvents = labelEvents.stream().filter(x -> x.getId() != eventId).collect(Collectors.toList());

        label.setEvents(labelEvents);

        labelRepository.update(label.getId(), label);
    }


}
