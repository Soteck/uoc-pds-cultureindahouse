package org.uoc.pds.alpha.cultureindahouse.api;

import dto.AddOrUpdateEvent;
import dto.AddOrUpdateEventOrganizer;
import helpers.HttpHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.*;

import java.io.IOException;
import java.time.LocalDate;

@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProfileIntegrationTest {


    private static final String ADMINISTRATION_URI = "http://localhost:8080/api/services/administration/";

    private static final String PROFILE_URI = "http://localhost:8080/api/services/profile/";

    private static CategoryVO category = new CategoryVO("Test category", "test description category");

    private static EventVO event = new EventVO("testing", "test description event", "Barcelona", "https://picsum.photos/200/300", LocalDate.now(), LocalDate.now().plusMonths(1));

    private static UserVO user = new UserVO("MediaTesting@email.com", "pass", "Admin", "Test");

    private static EventOrganizerVO eventOrganizer = new EventOrganizerVO("Test event", "test description event");

    private static LabelVO label = new LabelVO("Test event", "test description event");


    @Test
    @Order(1)
    public void addEvent() throws IOException {

        CategoryVO cat = HttpHelper.post(ADMINISTRATION_URI + "category", category, CategoryVO.class);
        category.setId(cat.getId());
        log.info("Categoria añadida: " + cat.getId() + ". N: " + cat.getName() + " D: " + cat.getDescription());

        LabelVO lab = HttpHelper.post(ADMINISTRATION_URI + "label", label, LabelVO.class);
        label.setId(lab.getId());
        log.info("Label añadida: " + lab.getId() + ". N: " + lab.getName() + " D: " + lab.getDescription());

        UserVO u = HttpHelper.post(ADMINISTRATION_URI + "administrator", user, UserVO.class);
        user.setId(u.getId());
        log.info("Administrator añadido: " + u.getId() + ". N: " + u.getName() + " S: " + u.getSurname() + " E: " + u.getEmail() + " P: " + u.getPassword());


        EventOrganizerVO ev = HttpHelper.post(ADMINISTRATION_URI + "event-organizer", new AddOrUpdateEventOrganizer(eventOrganizer), EventOrganizerVO.class);
        eventOrganizer.setId(ev.getId());

        EventOrganizerVO assigned = HttpHelper.put(ADMINISTRATION_URI + "event-organizer/assign/" + eventOrganizer.getId(), new AddOrUpdateEventOrganizer(eventOrganizer, user.getEmail()), EventOrganizerVO.class);
        eventOrganizer.setAdministrator((user));

        EventVO e = HttpHelper.post(PROFILE_URI + "events", new AddOrUpdateEvent(event, eventOrganizer.getId(), category.getId()), EventVO.class);
        event.setId(e.getId());
        log.info("Evento añadido: " + e.getId() + ". N: " + e.getName() + " D: " + e.getDescription() + " I: " + e.getImage() + " L: " + e.getLocation() + " ID: " + e.getInitDate() + " ED: " + e.getEndDate());

        assert cat.equals(category) && lab.equals(label) && user.equals(u) && event.equals(e) && eventOrganizer.equals(ev);

    }

    @Test
    @Order(2)
    public void addLabelToEvent() throws IOException {

        HttpHelper.put(PROFILE_URI + "events/" + event.getId() + "/label/" + label.getId(), null);

        LabelVO lab = HttpHelper.get(ADMINISTRATION_URI + "label/" + label.getId(), LabelVO.class);

        assert lab.getEvents().size() > 0;

    }


    @Test
    @Order(3)
    public void updateEvent() throws IOException {

        event.setName("eventTest");

        EventVO e = HttpHelper.put(PROFILE_URI + "events/" + event.getId(), new AddOrUpdateEvent(event, eventOrganizer.getId(), category.getId()), EventVO.class);

        log.info("Evento actualizado: " + e.getId() + ". N: " + e.getName() + " D: " + e.getDescription() + " I: " + e.getImage() + " L: " + e.getLocation() + " ID: " + e.getInitDate() + " ED: " + e.getEndDate());

        assert e != null;

    }


    @Test
    @Order(16)
    public void deleteTesting() throws IOException {

        HttpHelper.delete(PROFILE_URI + "events/" + event.getId());

        HttpHelper.delete(ADMINISTRATION_URI + "category/" + category.getId());

        HttpHelper.delete(ADMINISTRATION_URI + "event-organizer/" + eventOrganizer.getId());

        HttpHelper.delete(PROFILE_URI + "users/" + user.getId());


    }

}
