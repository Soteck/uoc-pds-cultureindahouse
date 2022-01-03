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

    private boolean isSuperAdministrator;

    private Collection<EventOrganizerVO> eventOrganizers;

    private Collection<OrderHistoryVO> orderHistory;

    private Collection<EventVO> favorites;

    private Collection<RatingVO> ratings;

    private Collection<CommentVO> comments;

    public UserVO(String email, String password, String name, String surname) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }


    public UserVO(String email, String password, String name, String surname, String nif, String preferedLanguage, String address) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.nif = nif;
        this.preferedLanguage = preferedLanguage;
        this.address = address;
    }

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
