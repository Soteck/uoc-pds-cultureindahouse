package org.uoc.pds.alpha.cultureindahouse.api;

import com.google.gson.Gson;
import dto.AddOrUpdateEvent;
import dto.AddOrUpdateEventOrganizer;
import dto.EventUser;
import helpers.HttpHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.*;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.time.LocalDate;

@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EventIntegrationTest {

    private static final String EVENT_URI = "http://localhost:8080/api/services/event/";

    private static final String ADMINISTRATION_URI = "http://localhost:8080/api/services/administration/";

    private static final String PROFILE_URI = "http://localhost:8080/api/services/profile/";

    private static Gson gson = new Gson();

    private static CategoryVO category = new CategoryVO("Test category", "test description category");

    private static EventVO event = new EventVO("testing", "test description event", "Barcelona", "https://picsum.photos/200/300", LocalDate.now(), LocalDate.now().plusMonths(1));

    private static LabelVO label = new LabelVO("Test event", "test description event");

    private static UserVO user = new UserVO("EventTesting@email.com", "pass", "Admin", "Test");

    private static EventOrganizerVO eventOrganizer = new EventOrganizerVO("Test event", "test description event");

    private static Integer orderHistoryId = null;


    @Test
    @Order(1)
    public void prepareTesting() throws IOException {

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


        HttpHelper.put(PROFILE_URI + "events/" + event.getId() + "/label/" + label.getId(), null);

        assert cat.equals(category) && lab.equals(label) && u.getId() != null && event.equals(e) && eventOrganizer.equals(ev);

    }


    @Test
    @Order(2)
    public void orderEvent() throws IOException {

        HttpPut request = new HttpPut(EVENT_URI + "order-event");
        request.setHeader("Content-Type", MediaType.APPLICATION_JSON);
        request.setEntity(new StringEntity(gson.toJson(new EventUser(user.getId(), event.getId()))));
        OrderHistoryVO orderHistoryVO = gson.fromJson(EntityUtils.toString(HttpClientBuilder.create().build().execute(request).getEntity()), OrderHistoryVO.class);

        orderHistoryId = orderHistoryVO.getId();

        assert orderHistoryVO.getEvent().getId() == event.getId() && orderHistoryVO.getUser().getId() == user.getId();


    }


    @Test
    @Order(3)
    public void findEventsByCategory() throws IOException {

        HttpGet request = new HttpGet(EVENT_URI + "events/category/" + category.getId());
        EventVO[] events = gson.fromJson(EntityUtils.toString(HttpClientBuilder.create().build().execute(request).getEntity()), EventVO[].class);

        assert events.length > 0 && events[0].getCategory().getId() == category.getId();


    }

    @Test
    @Order(4)
    public void findEventsByName() throws IOException {

        HttpGet request = new HttpGet(EVENT_URI + "events/name/" + event.getName());
        EventVO[] events = gson.fromJson(EntityUtils.toString(HttpClientBuilder.create().build().execute(request).getEntity()), EventVO[].class);

        assert events.length > 0 && events[0].getName().equals(event.getName());


    }

    @Test
    @Order(5)
    public void findEventsByLabel() throws IOException {

        EventVO[] events = HttpHelper.get(EVENT_URI + "events/label/" + label.getId(), EventVO[].class);

        assert events.length > 0;


    }


    @Test
    @Order(6)
    public void showEvent() throws IOException {

        HttpGet request = new HttpGet(EVENT_URI + "events/" + event.getId());
        EventVO e = gson.fromJson(EntityUtils.toString(HttpClientBuilder.create().build().execute(request).getEntity()), EventVO.class);

        assert e.getId() == event.getId();


    }

    @Test
    @Order(7)
    public void findOrdersByUser() throws IOException {

        HttpGet request = new HttpGet(EVENT_URI + "orders/user/" + user.getId());
        OrderHistoryVO[] orders = gson.fromJson(EntityUtils.toString(HttpClientBuilder.create().build().execute(request).getEntity()), OrderHistoryVO[].class);

        assert orders.length > 0;


    }

    @Test
    @Order(8)
    public void findAllOrders() throws IOException {

        HttpGet request = new HttpGet(EVENT_URI + "orders");
        OrderHistoryVO[] orders = gson.fromJson(EntityUtils.toString(HttpClientBuilder.create().build().execute(request).getEntity()), OrderHistoryVO[].class);

        assert orders.length > 0;


    }


    @Test
    @Order(9)
    public void showOrder() throws IOException {

        HttpGet request = new HttpGet(EVENT_URI + "orders/" + orderHistoryId);
        OrderHistoryVO order = gson.fromJson(EntityUtils.toString(HttpClientBuilder.create().build().execute(request).getEntity()), OrderHistoryVO.class);

        assert order.getEvent().getId() == event.getId() && order.getId() == orderHistoryId;


    }

    @Test
    @Order(10)
    public void deleteTesting() throws IOException {

        HttpHelper.delete(PROFILE_URI + "events/" + event.getId());

        HttpHelper.delete(ADMINISTRATION_URI + "label/" + label.getId());

        HttpHelper.delete(ADMINISTRATION_URI + "category/" + category.getId());

        HttpHelper.delete(ADMINISTRATION_URI + "event-organizer/" + eventOrganizer.getId());

        HttpHelper.delete(PROFILE_URI + "users/" + user.getId());


    }


}
