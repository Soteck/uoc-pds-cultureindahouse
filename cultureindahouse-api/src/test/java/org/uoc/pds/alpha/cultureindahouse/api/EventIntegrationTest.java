package org.uoc.pds.alpha.cultureindahouse.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
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
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.*;

import javax.ws.rs.core.MediaType;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EventIntegrationTest {
    protected ObjectMapper mapper = new ObjectMapper();

    private static final String BASE_URI = "http://localhost:8080/api/services/event/";

    private static final String ADMINISTRATION_URI = "http://localhost:8080/api/services/administration/";

    private static final String PROFILE_URI = "http://localhost:8080/api/services/profile/";

    private static Gson gson = new Gson();

    private static CategoryVO category = new CategoryVO("Test category", "test description category");

    private static EventVO event = new EventVO("Test even", "test description event", "Barcelona", "https://picsum.photos/200/300", new Date(), new Date());

    private static LabelVO label = new LabelVO("Test event", "test description event");

    private static UserVO user = new UserVO("email@email.com", "pass", "Admin", "Test");




    @Test
    @Order(1)
    public void PrepareTesting() throws IOException {

        HttpPost categoryRequest = new HttpPost(ADMINISTRATION_URI + "category");
        categoryRequest.setHeader("Content-Type", MediaType.APPLICATION_JSON);
        categoryRequest.setEntity(new StringEntity(gson.toJson(category)));
        HttpResponse categoryResponse = HttpClientBuilder.create().build().execute(categoryRequest);
        String jsonCategory = EntityUtils.toString(categoryResponse.getEntity());
        var cat = gson.fromJson(jsonCategory, CategoryVO.class);
        category.setId(cat.getId());
        log.info("Categoria añadida: " + cat.getId() + ". N: " + cat.getName() + " D: " + cat.getDescription());

        HttpPost labelRequest = new HttpPost(ADMINISTRATION_URI + "label");
        labelRequest.setHeader("Content-Type", MediaType.APPLICATION_JSON);
        labelRequest.setEntity(new StringEntity(gson.toJson(category)));
        HttpResponse labelResponse = HttpClientBuilder.create().build().execute(labelRequest);
        String jsonLabel = EntityUtils.toString(labelResponse.getEntity());
        var lab = gson.fromJson(jsonLabel, LabelVO.class);
        label.setId(lab.getId());
        log.info("Label añadida: " + lab.getId() + ". N: " + lab.getName() + " D: " + lab.getDescription());


        HttpPost adminRequest = new HttpPost(BASE_URI + "administrator");
        adminRequest.setHeader("Content-Type", MediaType.APPLICATION_JSON);
        adminRequest.setEntity(new StringEntity(gson.toJson(user)));
        HttpResponse adminResponse = HttpClientBuilder.create().build().execute(adminRequest);
        String adminJson = EntityUtils.toString(adminResponse.getEntity());
        var u = gson.fromJson(adminJson, UserVO.class);
        user.setId(u.getId());
        log.info("Administrator añadido: " + u.getId() + ". N: " + u.getName() + " S: " + u.getSurname() + " E: " + u.getEmail() + " P: " + u.getPassword());


        HttpPost eventRequest = new HttpPost(BASE_URI + "administrator");
        eventRequest.setHeader("Content-Type", MediaType.APPLICATION_JSON);
        eventRequest.setEntity(new StringEntity(gson.toJson(user)));
        HttpResponse eventResponse = HttpClientBuilder.create().build().execute(eventRequest);
        String eventJson = EntityUtils.toString(eventResponse.getEntity());
        var e = gson.fromJson(eventJson, EventVO.class);
        event.setId(e.getId());
        log.info("Evento añadido: " + e.getId() + ". N: " + e.getName() + " D: " + e.getDescription() + " I: " + e.getImage() + " L: " + e.getLocation() + " ID: " + e.getInitDate() + " ED: " + e.getEndDate());

        assert lab.equals(category);

    }


}
