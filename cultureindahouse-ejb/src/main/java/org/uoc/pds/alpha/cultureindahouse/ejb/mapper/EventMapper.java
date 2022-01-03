package org.uoc.pds.alpha.cultureindahouse.ejb.mapper;

import org.uoc.pds.alpha.cultureindahouse.ejb.entity.*;
import org.uoc.pds.alpha.cultureindahouse.ejb.helpers.DateHelper;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EventMapper {

    public static Event toEntity(EventVO eventVO, boolean relations) {
        Event ret = new Event();

        ret.setId(eventVO.getId());
        ret.setName(eventVO.getName());
        ret.setDescription(eventVO.getDescription());
        ret.setLocation(eventVO.getLocation());
        ret.setImage(eventVO.getImage());
        ret.setInitDate(DateHelper.parse(eventVO.getInitDate()));
        ret.setEndDate(DateHelper.parse(eventVO.getEndDate()));

        EventOrganizerVO eventOrganizer = eventVO.getEventOrganizer();
        if (relations && eventOrganizer != null) {
            ret.setEventOrganizer(EventOrganizerMapper.toEntity(eventOrganizer, false));
        }

        Collection<OrderHistoryVO> orderHistory = eventVO.getOrderHistory();
        if (relations && orderHistory != null && !orderHistory.isEmpty()) {
            ret.setOrderHistory(OrderHistoryMapper.toEntity(orderHistory, false));
        }

        UserVO user = eventVO.getUser();
        if (relations && user != null) {
            ret.setUser(UserMapper.toEntity(user, false));
        }

        CategoryVO category = eventVO.getCategory();
        if (relations && category != null) {
            ret.setCategory(CategoryMapper.toEntity(category, false));
        }

        Collection<LabelVO> labels = eventVO.getLabels();
        if (relations && labels != null && !labels.isEmpty()) {
            ret.setLabels(LabelMapper.toEntity(labels, false));
        }

        Collection<RatingVO> ratings = eventVO.getRatings();
        if (relations && ratings != null && !ratings.isEmpty()) {
            ret.setRatings(RatingMapper.toEntity(ratings, false));
        }
        Collection<CommentVO> comments = eventVO.getComments();
        if (relations && comments != null && !comments.isEmpty()) {
            ret.setComments(CommentMapper.toEntity(comments, false));
        }
        Collection<QuestionVO> questions = eventVO.getQuestions();
        if (relations && questions != null && !questions.isEmpty()) {
            ret.setQuestions(QuestionMapper.toEntity(questions, false));
        }


        return ret;
    }

    public static EventVO toVO(Event event, boolean relations) {
        EventVO ret = new EventVO();


        ret.setId(event.getId());
        ret.setName(event.getName());
        ret.setDescription(event.getDescription());
        ret.setLocation(event.getLocation());
        ret.setImage(event.getImage());
        ret.setInitDate(DateHelper.toString(event.getInitDate()));
        ret.setEndDate(DateHelper.toString(event.getEndDate()));

        EventOrganizer eventOrganizer = event.getEventOrganizer();
        if (relations && eventOrganizer != null) {
            ret.setEventOrganizer(EventOrganizerMapper.toVO(eventOrganizer, false));
        }

        Collection<OrderHistory> orderHistory = event.getOrderHistory();
        if (relations && orderHistory != null && !orderHistory.isEmpty()) {
            ret.setOrderHistory(OrderHistoryMapper.toVO(orderHistory, false));
        }

        User user = event.getUser();
        if (relations && user != null) {
            ret.setUser(UserMapper.toVO(user, false));
        }

        Category category = event.getCategory();
        if (relations && category != null) {
            ret.setCategory(CategoryMapper.toVO(category, false));
        }

        Collection<Label> labels = event.getLabels();
        if (relations && labels != null && !labels.isEmpty()) {
            ret.setLabels(LabelMapper.toVO(labels, false));
        }

        Collection<Rating> ratings = event.getRatings();
        if (relations && ratings != null && !ratings.isEmpty()) {
            ret.setRatings(RatingMapper.toVO(ratings, false));
        }
        Collection<Comment> comments = event.getComments();
        if (relations && comments != null && !comments.isEmpty()) {
            ret.setComments(CommentMapper.toVO(comments, false));
        }
        Collection<Question> questions = event.getQuestions();
        if (relations && questions != null && !questions.isEmpty()) {
            ret.setQuestions(QuestionMapper.toVO(questions, false));
        }


        return ret;
    }

    public static List<Event> toEntity(Collection<EventVO> events, boolean relations) {
        List<Event> ret = new ArrayList<>();
        for (EventVO event : events) {
            ret.add(toEntity(event, relations));
        }
        return ret;
    }

    public static List<EventVO> toVO(Collection<Event> events, boolean relations) {
        List<EventVO> ret = new ArrayList<>();
        for (Event event : events) {
            ret.add(toVO(event, relations));
        }
        return ret;
    }


}
