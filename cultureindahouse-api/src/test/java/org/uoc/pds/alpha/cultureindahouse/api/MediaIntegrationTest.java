package org.uoc.pds.alpha.cultureindahouse.api;

import dto.*;
import helpers.HttpHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.*;

import java.io.IOException;
import java.time.LocalDate;

@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MediaIntegrationTest {


    private static final String MEDIA_URI = "http://localhost:8080/api/services/media/";

    private static final String ADMINISTRATION_URI = "http://localhost:8080/api/services/administration/";

    private static final String PROFILE_URI = "http://localhost:8080/api/services/profile/";

    private static CategoryVO category = new CategoryVO("Test category", "test description category");

    private static EventVO event = new EventVO("testing", "test description event", "Barcelona", "https://picsum.photos/200/300", LocalDate.now(), LocalDate.now().plusMonths(1));

    private static UserVO user = new UserVO("MediaTesting@email.com", "pass", "Admin", "Test");

    private static EventOrganizerVO eventOrganizer = new EventOrganizerVO("Test event", "test description event");

    private static CommentVO comment = null;

    private static RatingVO rating = null;

    private static QuestionVO question = null;


    @Test
    @Order(1)
    public void prepareTesting() throws IOException {

        CategoryVO cat = HttpHelper.post(ADMINISTRATION_URI + "category", category, CategoryVO.class);
        category.setId(cat.getId());
        log.info("Categoria añadida: " + cat.getId() + ". N: " + cat.getName() + " D: " + cat.getDescription());

        UserVO u = HttpHelper.post(ADMINISTRATION_URI + "administrator", user, UserVO.class);
        user.setId(u.getId());
        log.info("Administrator añadido: " + u.getId() + ". N: " + u.getName() + " S: " + u.getSurname() + " E: " + u.getEmail() + " P: " + u.getPassword());

        EventOrganizerVO ev = HttpHelper.post(ADMINISTRATION_URI + "event-organizer", new AddOrUpdateEventOrganizer(eventOrganizer), EventOrganizerVO.class);
        eventOrganizer.setId(ev.getId());
        eventOrganizer.setAdministrator((user));

        EventVO e = HttpHelper.post(PROFILE_URI + "events", new AddOrUpdateEvent(event, eventOrganizer.getId(), category.getId()), EventVO.class);
        event.setId(e.getId());
        log.info("Evento añadido: " + e.getId() + ". N: " + e.getName() + " D: " + e.getDescription() + " I: " + e.getImage() + " L: " + e.getLocation() + " ID: " + e.getInitDate() + " ED: " + e.getEndDate());

        assert cat.equals(category) && u.getId() != null && event.equals(e) && eventOrganizer.equals(ev);

    }

    @Test
    @Order(2)
    public void sendCommentByEmail() throws IOException {
        CommentVO com = HttpHelper.post(MEDIA_URI + "/comments/by-email", new SendCommentEmail(event.getId(), user.getEmail(), "Comment text"), CommentVO.class);

        comment = com;

        assert com != null;
    }

    @Test
    @Order(3)
    public void sendCommentByUserId() throws IOException {
        CommentVO com = HttpHelper.post(MEDIA_URI + "/comments/by-user-id", new SendCommentUser(event.getId(), user.getId(), "Comment text 2"), CommentVO.class);

        assert com != null;
    }

    @Test
    @Order(4)
    public void addRatingByEmail() throws IOException {
        RatingVO rat = HttpHelper.post(MEDIA_URI + "/ratings/by-email", new SendRatingEmail(event.getId(), user.getEmail(), 5), RatingVO.class);
        rating = rat;
        assert rat != null;

    }

    @Test
    @Order(5)
    public void addRatingByUserId() throws IOException {
        RatingVO rat = HttpHelper.post(MEDIA_URI + "/ratings/by-user-id", new SendRatingUser(event.getId(), user.getId(), 5), RatingVO.class);

        assert rat != null;
    }

    @Test
    @Order(6)
    public void askQuestion() throws IOException {
        QuestionVO que = HttpHelper.post(MEDIA_URI + "/questions/ask", new AskQuestion(event.getId(), "Question 1", "What do you mean, your people"), QuestionVO.class);

        question = que;

        assert que != null;
    }

    @Test
    @Order(7)
    public void answerQuestion() throws IOException {
        CommentVO com = HttpHelper.post(MEDIA_URI + "/questions/answer", new AnswerQuestion(question.getId(), "Your people"), CommentVO.class);

        assert com != null;
    }


    @Test
    @Order(9)
    public void addToFavoritesByUserId() throws IOException {
        UserVO u = HttpHelper.put(MEDIA_URI + "/events/favorites/by-user-id", new EventUser(user.getId(), event.getId()), UserVO.class);

        assert u.getFavorites().size() > 0;
    }

    @Test
    @Order(10)
    public void listAllFavorites() throws IOException {
        EventVO[] events = HttpHelper.get(MEDIA_URI + "/events/favorites", EventVO[].class);

        assert events.length > 0;
    }

    @Test
    @Order(11)
    public void listAllFavoritesByEmail() throws IOException {
        EventVO[] events = HttpHelper.get(MEDIA_URI + "/events/favorites/email/" + user.getEmail(), EventVO[].class);

        assert events.length > 0;

    }

    @Test
    @Order(12)
    public void listAllFavoritesByUserId() throws IOException {
        EventVO[] events = HttpHelper.get(MEDIA_URI + "/events/favorites/userId/" + user.getId(), EventVO[].class);

        assert events.length > 0;
    }

    @Test
    @Order(13)
    public void getQuestion() throws IOException {
        QuestionVO q = HttpHelper.get(MEDIA_URI + "/questions/" + question.getId(), QuestionVO.class);

        assert q != null;
    }

    @Test
    @Order(14)
    public void getResponse() throws IOException {
        ResponseVO r = HttpHelper.get(MEDIA_URI + "/responses/" + question.getId(), ResponseVO.class);

        assert r != null;

    }

    @Test
    @Order(15)
    public void listAllQuestions() throws IOException {
        QuestionVO[] questions = HttpHelper.get(MEDIA_URI + "/questions/eventId/" + event.getId(), QuestionVO[].class);


        assert questions.length > 0;
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
