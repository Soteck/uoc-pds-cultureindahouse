package org.uoc.pds.alpha.cultureindahouse.ejb.mapper;

import lombok.var;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Event;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventVO;

import java.util.ArrayList;
import java.util.List;

public class EventMapper {

    public static Event toEntity(EventVO eventVO) {
        Event ret = new Event();

        ret.setId(eventVO.getId());
        ret.setName(eventVO.getName());
        ret.setDescription(eventVO.getDescription());
        ret.setLocation(eventVO.getLocation());
        ret.setImage(eventVO.getImage());
        ret.setInitDate(eventVO.getInitDate());
        ret.setEndDate(eventVO.getEndDate());

        var eventOrganizer = eventVO.getEventOrganizer();
        if (eventOrganizer != null) {
            ret.setEventOrganizer(EventOrganizerMapper.toEntity(eventOrganizer));
        }

        var orderHistory = eventVO.getOrderHistory();
        if (orderHistory != null && !orderHistory.isEmpty()) {
            ret.setOrderHistory(OrderHistoryMapper.toEntity(orderHistory));
        }

        var user = eventVO.getUser();
        if (user != null) {
            ret.setUser(UserMapper.toEntity(user));
        }

        var category = eventVO.getCategory();
        if (category != null) {
            ret.setCategory(CategoryMapper.toEntity(category));
        }

        var labels = eventVO.getLabels();
        if (labels != null && !labels.isEmpty()) {
            ret.setLabels(LabelMapper.toEntity(labels));
        }

        var ratings = eventVO.getRatings();
        if (ratings != null && !ratings.isEmpty()) {
            ret.setRatings(RatingMapper.toEntity(ratings));
        }
        var comments = eventVO.getComments();
        if (comments != null && !comments.isEmpty()) {
            ret.setComments(CommentMapper.toEntity(comments));
        }
        var questions = eventVO.getQuestions();
        if (questions != null && !questions.isEmpty()) {
            ret.setQuestions(QuestionMapper.toEntity(questions));
        }


        return ret;
    }

    public static EventVO toVO(Event event) {
        EventVO ret = new EventVO();


        ret.setId(event.getId());
        ret.setName(event.getName());
        ret.setDescription(event.getDescription());
        ret.setLocation(event.getLocation());
        ret.setImage(event.getImage());
        ret.setInitDate(event.getInitDate());
        ret.setEndDate(event.getEndDate());

        var eventOrganizer = event.getEventOrganizer();
        if (eventOrganizer != null) {
            ret.setEventOrganizer(EventOrganizerMapper.toVO(eventOrganizer));
        }

        var orderHistory = event.getOrderHistory();
        if (orderHistory != null && !orderHistory.isEmpty()) {
            ret.setOrderHistory(OrderHistoryMapper.toVO(orderHistory));
        }

        var user = event.getUser();
        if (user != null) {
            ret.setUser(UserMapper.toVO(user));
        }

        var category = event.getCategory();
        if (category != null) {
            ret.setCategory(CategoryMapper.toVO(category));
        }

        var labels = event.getLabels();
        if (labels != null && !labels.isEmpty()) {
            ret.setLabels(LabelMapper.toVO(new ArrayList<>(labels)));
        }

        var ratings = event.getRatings();
        if (ratings != null && !ratings.isEmpty()) {
            ret.setRatings(RatingMapper.toVO(new ArrayList<>(ratings)));
        }
        var comments = event.getComments();
        if (comments != null && !comments.isEmpty()) {
            ret.setComments(CommentMapper.toVO(new ArrayList<>(comments)));
        }
        var questions = event.getQuestions();
        if (questions != null && !questions.isEmpty()) {
            ret.setQuestions(QuestionMapper.toVO(new ArrayList<>(questions)));
        }


        return ret;
    }

    public static List<Event> toEntity(List<EventVO> events) {
        List<Event> ret = new ArrayList<>();
        for (EventVO event : events) {
            ret.add(toEntity(event));
        }
        return ret;
    }

    public static List<EventVO> toVO(List<Event> events) {
        List<EventVO> ret = new ArrayList<>();
        for (Event event : events) {
            ret.add(toVO(event));
        }
        return ret;
    }


}
