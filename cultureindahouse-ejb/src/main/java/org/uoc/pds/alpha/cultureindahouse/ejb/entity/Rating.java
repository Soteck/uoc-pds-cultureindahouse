package org.uoc.pds.alpha.cultureindahouse.ejb.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
}
