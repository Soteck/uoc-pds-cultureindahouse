package org.uoc.pds.alpha.cultureindahouse.ejb.entity;

import java.util.Collection;
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

    @Column(name = "is_super_administrator")
    private boolean isSuperAdministrator;

    @OneToMany(mappedBy = "administrator", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Collection<EventOrganizer> eventOrganizers;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Collection<OrderHistory> orderHistory;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "favorites",
            schema = "pra2",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    @ToString.Exclude
    private Collection<Event> favorites;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Collection<Rating> ratings;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Collection<Comment> comments;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isAdministrator == user.isAdministrator && isSuperAdministrator == user.isSuperAdministrator && Objects.equals(id, user.id) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(nif, user.nif) && Objects.equals(preferedLanguage, user.preferedLanguage) && Objects.equals(address, user.address) && Objects.equals(eventOrganizers, user.eventOrganizers) && Objects.equals(orderHistory, user.orderHistory) && Objects.equals(favorites, user.favorites) && Objects.equals(ratings, user.ratings) && Objects.equals(comments, user.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, name, surname, nif, preferedLanguage, address, isAdministrator, isSuperAdministrator, eventOrganizers, orderHistory, favorites, ratings, comments);
    }
}
