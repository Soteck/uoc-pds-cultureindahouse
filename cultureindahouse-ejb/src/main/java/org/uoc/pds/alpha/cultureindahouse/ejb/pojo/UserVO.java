package org.uoc.pds.alpha.cultureindahouse.ejb.pojo;

import lombok.*;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;


@Data
@NoArgsConstructor
public class UserVO {

    private Integer id;

    private String email;

    private String password;

    private String name;

    private String surname;

    private String nif;

    private String preferedLanguage;

    private String address;

    private boolean isAdministrator;

    private List<EventOrganizerVO> eventOrganizers;

    private List<OrderHistoryVO> orderHistory;

    private List<EventVO> favorites;

    private List<RatingVO> ratings;

    private List<CommentVO> comments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserVO userVO = (UserVO) o;
        return Objects.equals(id, userVO.id) && Objects.equals(email, userVO.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}
