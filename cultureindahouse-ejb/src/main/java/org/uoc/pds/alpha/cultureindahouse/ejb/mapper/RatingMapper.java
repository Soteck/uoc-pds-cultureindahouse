package org.uoc.pds.alpha.cultureindahouse.ejb.mapper;

import lombok.var;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Rating;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.RatingVO;

import java.util.ArrayList;
import java.util.List;

public class RatingMapper {


    public static Rating toEntity(RatingVO ratingVO) {
        Rating ret = new Rating();

        ret.setId(ratingVO.getId());
        ret.setRating(ratingVO.getRating());

        var event = ratingVO.getEvent();

        if (event != null) {
            ret.setEvent(EventMapper.toEntity(event));
        }
        var user = ratingVO.getUser();

        if (user != null) {
            ret.setUser(UserMapper.toEntity(user));
        }


        return ret;
    }

    public static RatingVO toVO(Rating rating) {

        RatingVO ret = new RatingVO();

        ret.setId(rating.getId());
        ret.setRating(rating.getRating());

        var event = rating.getEvent();

        if (event != null) {
            ret.setEvent(EventMapper.toVO(event));
        }
        var user = rating.getUser();

        if (user != null) {
            ret.setUser(UserMapper.toVO(user));
        }

        return ret;
    }


    public static List<Rating> toEntity(List<RatingVO> categories) {
        List<Rating> ret = new ArrayList<>();
        for (RatingVO rating : categories) {
            ret.add(toEntity(rating));
        }
        return ret;
    }

    public static List<RatingVO> toVO(List<Rating> categories) {
        List<RatingVO> ret = new ArrayList<>();
        for (Rating Rating : categories) {
            ret.add(toVO(Rating));
        }
        return ret;
    }


}
