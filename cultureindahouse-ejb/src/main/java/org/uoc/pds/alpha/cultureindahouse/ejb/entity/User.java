package org.uoc.pds.alpha.cultureindahouse.ejb.entity;

import java.util.Collection;

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

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "nif")
    private String nif;

    @Column(name = "preferedLanguage")
    private String preferedLanguage;

    @Column(name = "address")
    private String address;

    @Column(name = "isAdministrator")
    private boolean isAdministrator;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<OrderHistory> orderHistory;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Event> events;


}
