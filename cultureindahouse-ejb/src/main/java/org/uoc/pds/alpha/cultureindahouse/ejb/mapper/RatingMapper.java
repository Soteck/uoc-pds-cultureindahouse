package org.uoc.pds.alpha.cultureindahouse.ejb.mapper;

import lombok.var;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Rating;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.RatingVO;

import java.util.ArrayList;
import java.util.List;

public class RatingMapper {


    public static Rating toEntity(RatingVO ratingVO, boolean relations) {
        Rating ret = new Rating();

        ret.setId(ratingVO.getId());
        ret.setRating(ratingVO.getRating());

        var event = ratingVO.getEvent();

        if (relations && event != null) {
            ret.setEvent(EventMapper.toEntity(event, false));
        }
        var user = ratingVO.getUser();

        if (relations && user != null) {
            ret.setUser(UserMapper.toEntity(user, false));
        }


        return ret;
    }

    public static RatingVO toVO(Rating rating, boolean relations) {

        RatingVO ret = new RatingVO();

        ret.setId(rating.getId());
        ret.setRating(rating.getRating());

        var event = rating.getEvent();

        if (relations && event != null) {
            ret.setEvent(EventMapper.toVO(event, relations));
        }
        var user = rating.getUser();

        if (relations && user != null) {
            ret.setUser(UserMapper.toVO(user, relations));
        }

        return ret;
    }


    public static List<Rating> toEntity(List<RatingVO> categories, boolean relations) {
        List<Rating> ret = new ArrayList<>();
        for (RatingVO rating : categories) {
            ret.add(toEntity(rating, relations));
        }
        return ret;
    }

    public static List<RatingVO> toVO(List<Rating> categories, boolean relations) {
        List<RatingVO> ret = new ArrayList<>();
        for (Rating Rating : categories) {
            ret.add(toVO(Rating, relations));
        }
        return ret;
    }


}
