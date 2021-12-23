package org.uoc.pds.alpha.cultureindahouse.ejb.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor

@Table(name = "rating", schema = "pra2")
public class Rating {

    @Id
    @Column(name = "id", updatable = false)
    @SequenceGenerator(name = "pra2.rating_id_seq", sequenceName = "pra2.rating_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pra2.rating_id_seq")
	private Integer id;

	@Column(name = "rating")
	private int rating;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Rating(int rating, Event event, User user) {
        this.rating = rating;
        this.event = event;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating1 = (Rating) o;
        return rating == rating1.rating && Objects.equals(id, rating1.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rating);
    }
}
