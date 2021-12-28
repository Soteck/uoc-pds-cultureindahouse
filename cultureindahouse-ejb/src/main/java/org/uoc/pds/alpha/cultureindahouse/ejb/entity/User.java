package org.uoc.pds.alpha.cultureindahouse.ejb.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import lombok.*;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user", schema = "pra2")
public class User {

    @Id
    @Column(name = "id", updatable = false)
    @SequenceGenerator(name = "pra2.user_id_seq", sequenceName = "pra2.user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pra2.user_id_seq")
    private Integer id;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "nif")
    private String nif;

    @Column(name = "prefered_language")
    private String preferedLanguage;

    @Column(name = "address")
    private String address;

    @Column(name = "is_administrator")
    private boolean isAdministrator;

    @OneToMany(mappedBy = "administrator", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<EventOrganizer> eventOrganizers;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<OrderHistory> orderHistory;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Event> favorites;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Rating> ratings;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Comment> comments;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}
