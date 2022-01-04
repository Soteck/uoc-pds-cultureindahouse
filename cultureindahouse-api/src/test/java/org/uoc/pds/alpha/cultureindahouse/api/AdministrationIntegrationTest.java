package org.uoc.pds.alpha.cultureindahouse.api;

import com.google.gson.Gson;
import dto.AddOrUpdateEventOrganizer;
import helpers.HttpHelper;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.CategoryVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventOrganizerVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.LabelVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;

import javax.ws.rs.core.MediaType;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;

@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdministrationIntegrationTest {


    private static final String BASE_URI = "http://localhost:8080/api/services/administration/";

    private static Gson gson = new Gson();

    private static CategoryVO category = new CategoryVO("Test category", "test description category");

    private static EventOrganizerVO eventOrganizer = new EventOrganizerVO("Test event", "test description event");

    private static LabelVO label = new LabelVO("Test event", "test description event");

    private static UserVO user = new UserVO("email@email.com", "pass", "name", "surname");

    private static Integer eventOrganizerUserId = null;

    @Test
    @Order(1)
    public void addCategory() throws IOException {

        CategoryVO cat = HttpHelper.post(BASE_URI + "category", category, CategoryVO.class);

        category.setId(cat.getId());

        log.info("Categoria añadida: " + cat.getId() + ". N: " + cat.getName() + " D: " + cat.getDescription());

        assert cat.equals(category);

    }

    @Test
    @Order(2)
    public void getCategory() throws IOException {

        CategoryVO cat = HttpHelper.get(BASE_URI + "category/" + category.getId(), CategoryVO.class);

        log.info("Categoria: " + cat.getId() + ". N: " + cat.getName() + " D: " + cat.getDescription());

        assert cat.equals(category);


    }

    @Test
    @Order(3)
    public void getCategories() throws IOException {

        CategoryVO[] categories = HttpHelper.get(BASE_URI + "category", CategoryVO[].class);

        boolean founded = false;

        for (CategoryVO cat : categories) {

            if (cat.equals(category)) {
                founded = true;
            }
            log.info("Listando categorias: Categoria " + cat.getId() + ". N: " + cat.getName() + " D: " + cat.getDescription());
        }

        assert founded;


    }

    @Test
    @Order(4)
    public void updateCategory() throws IOException {

        category.setDescription("new test updated category");

        CategoryVO cat = HttpHelper.put(BASE_URI + "category/" + category.getId(), category, CategoryVO.class);

        log.info("Categoria actualizada: " + cat.getId() + ". N: " + cat.getName() + " D: " + cat.getDescription());

        assert cat.equals(category);
    }


    @Test
    @Order(5)
    public void addAdministrator() throws IOException {
        HttpPost request = new HttpPost(BASE_URI + "administrator");

        request.setHeader("Content-Type", MediaType.APPLICATION_JSON);

        request.setEntity(new StringEntity(gson.toJson(user)));


        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        String jsonFromResponse = EntityUtils.toString(response.getEntity());

        var u = gson.fromJson(jsonFromResponse, UserVO.class);

        user.setId(u.getId());

        log.info("User añadido: " + u.getId() + ". N: " + u.getName() + " S: " + u.getSurname() + " E: " + u.getEmail() + " P: " + u.getPassword());

        assert u.equals(user);


    }

    @Test
    @Order(6)
    public void getAdministrator() throws IOException {
        HttpGet request = new HttpGet(BASE_URI + "administrator/" + user.getId());

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        String jsonFromResponse = EntityUtils.toString(response.getEntity());

        var u = gson.fromJson(jsonFromResponse, UserVO.class);

        log.info("User: " + u.getId() + ". N: " + u.getName() + " S: " + u.getSurname() + " E: " + u.getEmail() + " P: " + u.getPassword());

        assert u.equals(user);


    }

    @Test
    @Order(7)
    public void getAdministrators() throws IOException {
        HttpGet request = new HttpGet(BASE_URI + "administrator");

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        String jsonFromResponse = EntityUtils.toString(response.getEntity());

        var users = gson.fromJson(jsonFromResponse, UserVO[].class);

        boolean founded = false;

        for (UserVO u : users) {

            if (u.equals(user)) {
                founded = true;
            }
            log.info("Listando Users:  User " + u.getId() + ". N: " + u.getName() + " S: " + u.getSurname() + " E: " + u.getEmail() + " P: " + u.getPassword());
        }

        assert founded;


    }

    @Test
    @Order(8)
    public void updateAdministrator() throws IOException {
        HttpPut request = new HttpPut(BASE_URI + "administrator/" + user.getId());

        request.setHeader("Content-Type", MediaType.APPLICATION_JSON);

        user.setAddress("testing address");

        request.setEntity(new StringEntity(gson.toJson(user)));

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        String jsonFromResponse = EntityUtils.toString(response.getEntity());

        var u = gson.fromJson(jsonFromResponse, UserVO.class);

        log.info("User: " + u.getId() + ". N: " + u.getName() + " S: " + u.getSurname() + " E: " + u.getEmail() + " P: " + u.getPassword());

        assert u.equals(user);
    }


    @Test
    @Order(9)
    public void addEventOrganizer() throws IOException {


        EventOrganizerVO ev = HttpHelper.post(BASE_URI + "event-organizer", new AddOrUpdateEventOrganizer(eventOrganizer, user.getId()), EventOrganizerVO.class);

        eventOrganizer = ev;

        log.info("Event Organizer añadido: " + ev.getId() + ". N: " + ev.getName() + " D: " + ev.getDescription());

        assert ev.getAdministrator() != null;


    }

    @Test
    @Order(10)
    public void getEventOrganizer() throws IOException {
        HttpGet request = new HttpGet(BASE_URI + "event-organizer/" + eventOrganizer.getId());

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        String jsonFromResponse = EntityUtils.toString(response.getEntity());

        var ev = gson.fromJson(jsonFromResponse, EventOrganizerVO.class);

        log.info("Event Organizer: " + ev.getId() + ". N: " + ev.getName() + " D: " + ev.getDescription());

        assert ev.equals(eventOrganizer);


    }

    @Test
    @Order(11)
    public void getEventOrganizers() throws IOException {
        HttpGet request = new HttpGet(BASE_URI + "event-organizer");

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        String jsonFromResponse = EntityUtils.toString(response.getEntity());

        var events = gson.fromJson(jsonFromResponse, EventOrganizerVO[].class);

        boolean founded = false;

        for (EventOrganizerVO ev : events) {

            if (ev.equals(eventOrganizer)) {
                founded = true;
            }
            log.info("Listando Event Organizer: Event Organizer " + ev.getId() + ". N: " + ev.getName() + " D: " + ev.getDescription());
        }

        assert founded;


    }

    @Test
    @Order(12)
    public void updateEventOrganizer() throws IOException {

        eventOrganizer.setDescription("new test updated event organizer");
        eventOrganizer.setName("new event organizer test");

        EventOrganizerVO ev = HttpHelper.put(BASE_URI + "event-organizer/" + eventOrganizer.getId(), new AddOrUpdateEventOrganizer(eventOrganizer, user.getId()), EventOrganizerVO.class);

        log.info("Event Organizer actualizado: " + ev.getId() + ". N: " + ev.getName() + " D: " + ev.getDescription());

        assert ev.equals(eventOrganizer);
    }




    @Test
    @Order(13)
    public void addLabel() throws IOException {
        HttpPost request = new HttpPost(BASE_URI + "label");

        request.setHeader("Content-Type", MediaType.APPLICATION_JSON);

        request.setEntity(new StringEntity(gson.toJson(label)));


        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        String jsonFromResponse = EntityUtils.toString(response.getEntity());

        var lab = gson.fromJson(jsonFromResponse, LabelVO.class);

        label.setId(lab.getId());

        log.info("Label añadida: " + lab.getId() + ". N: " + lab.getName() + " D: " + lab.getDescription());

        assert lab.equals(label);


    }

    @Test
    @Order(14)
    public void getLabel() throws IOException {
        HttpGet request = new HttpGet(BASE_URI + "label/" + label.getId());

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        String jsonFromResponse = EntityUtils.toString(response.getEntity());

        var lab = gson.fromJson(jsonFromResponse, LabelVO.class);

        log.info("Label: " + lab.getId() + ". N: " + lab.getName() + " D: " + lab.getDescription());

        assert lab.equals(label);


    }

    @Test
    @Order(15)
    public void getLabels() throws IOException {
        HttpGet request = new HttpGet(BASE_URI + "label");

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        String jsonFromResponse = EntityUtils.toString(response.getEntity());

        var labels = gson.fromJson(jsonFromResponse, LabelVO[].class);

        boolean founded = false;

        for (LabelVO lab : labels) {

            if (lab.equals(label)) {
                founded = true;
            }
            log.info("Listando labels: Label " + lab.getId() + ". N: " + lab.getName() + " D: " + lab.getDescription());
        }

        assert founded;


    }

    @Test
    @Order(16)
    public void updateLabel() throws IOException {
        HttpPut request = new HttpPut(BASE_URI + "label/" + label.getId());

        request.setHeader("Content-Type", MediaType.APPLICATION_JSON);

        label.setDescription("new test updated label");
        label.setName("new label test");

        request.setEntity(new StringEntity(gson.toJson(label)));

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        String jsonFromResponse = EntityUtils.toString(response.getEntity());

        var lab = gson.fromJson(jsonFromResponse, LabelVO.class);

        log.info("Label actualizada: " + lab.getId() + ". N: " + lab.getName() + " D: " + lab.getDescription());

        assert lab.equals(label);
    }


    @Test
    @Order(17)
    public void deleteCategory() throws IOException {

        HttpHelper.delete(BASE_URI + "category/" + category.getId());

        try {
            HttpGet getRequest = new HttpGet(BASE_URI + "category/" + category.getId());

            HttpResponse resp = HttpClientBuilder.create().build().execute(getRequest);

            assert resp.getStatusLine().getStatusCode() == 500;

        } catch (HTTPException e) {
            assert e.getStatusCode() == 500;
        }
    }

    @Test
    @Order(18)
    public void deleteLabel() throws IOException {
        HttpDelete request = new HttpDelete(BASE_URI + "label/" + label.getId());

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        try {
            HttpGet getRequest = new HttpGet(BASE_URI + "label/" + label.getId());

            HttpResponse resp = HttpClientBuilder.create().build().execute(getRequest);

            assert resp.getStatusLine().getStatusCode() == 500;

        } catch (HTTPException e) {
            assert e.getStatusCode() == 500;
        }
    }

    @Test
    @Order(19)
    public void deleteEventOrganizer() throws IOException {

        HttpDelete request = new HttpDelete(BASE_URI + "event-organizer/" + eventOrganizer.getId());

        HttpResponse response = HttpClientBuilder.create().build().execute(request);


        try {
            HttpGet getRequest = new HttpGet(BASE_URI + "event-organizer/" + eventOrganizer.getId());

            HttpResponse resp = HttpClientBuilder.create().build().execute(getRequest);

            assert resp.getStatusLine().getStatusCode() == 500;

        } catch (HTTPException e) {
            assert e.getStatusCode() == 500;
        }
    }


    @Test
    @Order(20)
    public void deleteAdministrator() throws IOException {
        HttpDelete request = new HttpDelete(BASE_URI + "administrator/" + user.getId());

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        try {
            HttpGet getRequest = new HttpGet(BASE_URI + "administrator/" + user.getId());

            HttpResponse resp = HttpClientBuilder.create().build().execute(getRequest);

            assert resp.getStatusLine().getStatusCode() == 500;

        } catch (HTTPException e) {
            assert e.getStatusCode() == 500;
        }
    }



}
