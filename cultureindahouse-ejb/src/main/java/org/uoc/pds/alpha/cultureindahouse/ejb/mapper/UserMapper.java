package org.uoc.pds.alpha.cultureindahouse.ejb.mapper;

import lombok.var;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.User;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserMapper {

    public static User toEntity(UserVO userVO, boolean relations) {
        User ret = new User();

        ret.setId(userVO.getId());
        ret.setEmail(userVO.getEmail());
        ret.setPassword(userVO.getPassword());
        ret.setName(userVO.getName());
        ret.setSurname(userVO.getSurname());
        ret.setNif(userVO.getNif());
        ret.setPreferedLanguage(userVO.getPreferedLanguage());
        ret.setAddress(userVO.getAddress());
        ret.setAdministrator(userVO.isAdministrator());
        ret.setSuperAdministrator(userVO.isSuperAdministrator());

        var eventOrganizers = userVO.getEventOrganizers();

        if (relations && eventOrganizers != null && !eventOrganizers.isEmpty()) {
            ret.setEventOrganizers(EventOrganizerMapper.toEntity(eventOrganizers, false));
        }

        var orderHistory = userVO.getOrderHistory();

        if (relations && orderHistory != null && !orderHistory.isEmpty()) {
            ret.setOrderHistory(OrderHistoryMapper.toEntity(orderHistory, false));
        }

        var events = userVO.getFavorites();

        if (relations && events != null && !events.isEmpty()) {
            ret.setFavorites(EventMapper.toEntity(events, false));
        }

        var ratings = userVO.getRatings();

        if (relations && ratings != null && !ratings.isEmpty()) {
            ret.setRatings(RatingMapper.toEntity(ratings, false));
        }

        var comments = userVO.getComments();

        if (relations && comments != null && !comments.isEmpty()) {
            ret.setComments(CommentMapper.toEntity(comments, false));
        }

        return ret;
    }

    public static UserVO toVO(User user, boolean relations) {
        UserVO ret = new UserVO();

        ret.setId(user.getId());
        ret.setEmail(user.getEmail());
        ret.setPassword(user.getPassword());
        ret.setName(user.getName());
        ret.setSurname(user.getSurname());
        ret.setNif(user.getNif());
        ret.setPreferedLanguage(user.getPreferedLanguage());
        ret.setAddress(user.getAddress());
        ret.setAdministrator(user.isAdministrator());
        ret.setSuperAdministrator(user.isSuperAdministrator());

        var eventOrganizers = user.getEventOrganizers();

        if (relations && eventOrganizers != null && !eventOrganizers.isEmpty()) {
            ret.setEventOrganizers(EventOrganizerMapper.toVO(eventOrganizers, false));
        }

        var orderHistory = user.getOrderHistory();

        if (relations && orderHistory != null && !orderHistory.isEmpty()) {
            ret.setOrderHistory(OrderHistoryMapper.toVO(orderHistory, false));
        }

        var events = user.getFavorites();

        if (relations && events != null && !events.isEmpty()) {
            ret.setFavorites(EventMapper.toVO(events, false));
        }

        var ratings = user.getRatings();

        if (relations && ratings != null && !ratings.isEmpty()) {
            ret.setRatings(RatingMapper.toVO(ratings, false));
        }

        var comments = user.getComments();

        if (relations && comments != null && !comments.isEmpty()) {
            ret.setComments(CommentMapper.toVO(comments, false));
        }
        return ret;
    }


    public static List<User> toEntity(Collection<UserVO> users, boolean relations) {
        List<User> ret = new ArrayList<>();
        for (UserVO User : users) {
            ret.add(toEntity(User, relations));
        }
        return ret;
    }

    public static List<UserVO> toVO(Collection<User> categories, boolean relations) {
        List<UserVO> ret = new ArrayList<>();
        for (User User : categories) {
            ret.add(toVO(User,relations));
        }
        return ret;
    }

}
