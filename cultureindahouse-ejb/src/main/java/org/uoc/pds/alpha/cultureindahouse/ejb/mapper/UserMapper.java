package org.uoc.pds.alpha.cultureindahouse.ejb.mapper;

import lombok.var;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.User;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static User toEntity(UserVO userVO) {
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

        var eventOrganizers = userVO.getEventOrganizers();

        if (eventOrganizers != null && !eventOrganizers.isEmpty()) {
            ret.setEventOrganizers(EventOrganizerMapper.toEntity(eventOrganizers));
        }

        var orderHistory = userVO.getOrderHistory();

        if (orderHistory != null && !orderHistory.isEmpty()) {
            ret.setOrderHistory(OrderHistoryMapper.toEntity(orderHistory));
        }

        var events = userVO.getFavorites();

        if (events != null && !events.isEmpty()) {
            ret.setFavorites(EventMapper.toEntity(events));
        }

        var ratings = userVO.getRatings();

        if (ratings != null && !ratings.isEmpty()) {
            ret.setRatings(RatingMapper.toEntity(ratings));
        }

        var comments = userVO.getComments();

        if (comments != null && !comments.isEmpty()) {
            ret.setComments(CommentMapper.toEntity(comments));
        }

        return ret;
    }

    public static UserVO toVO(User user) {
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

        var eventOrganizers = user.getEventOrganizers();

        if (eventOrganizers != null && !eventOrganizers.isEmpty()) {
            ret.setEventOrganizers(EventOrganizerMapper.toVO(new ArrayList<>(eventOrganizers)));
        }

        var orderHistory = user.getOrderHistory();

        if (orderHistory != null && !orderHistory.isEmpty()) {
            ret.setOrderHistory(OrderHistoryMapper.toVO(new ArrayList<>(orderHistory)));
        }

        var events = user.getFavorites();

        if (events != null && !events.isEmpty()) {
            ret.setFavorites(EventMapper.toVO(new ArrayList<>(events)));
        }

        var ratings = user.getRatings();

        if (ratings != null && !ratings.isEmpty()) {
            ret.setRatings(RatingMapper.toVO(new ArrayList<>(ratings)));
        }

        var comments = user.getComments();

        if (comments != null && !comments.isEmpty()) {
            ret.setComments(CommentMapper.toVO(new ArrayList<>(comments)));
        }
        return ret;
    }


    public static List<User> toEntity(List<UserVO> categories) {
        List<User> ret = new ArrayList<>();
        for (UserVO User : categories) {
            ret.add(toEntity(User));
        }
        return ret;
    }

    public static List<UserVO> toVO(List<User> categories) {
        List<UserVO> ret = new ArrayList<>();
        for (User User : categories) {
            ret.add(toVO(User));
        }
        return ret;
    }

}
