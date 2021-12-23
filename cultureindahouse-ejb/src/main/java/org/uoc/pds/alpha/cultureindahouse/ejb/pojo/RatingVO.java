package org.uoc.pds.alpha.cultureindahouse.ejb.pojo;

import lombok.*;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Event;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.User;

import javax.persistence.*;
import java.util.Objects;

@Data
@NoArgsConstructor
public class RatingVO {

	private Integer id;

	private int rating;

    private EventVO event;

    private UserVO user;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatingVO ratingVO = (RatingVO) o;
        return rating == ratingVO.rating && Objects.equals(id, ratingVO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rating);
    }
}
