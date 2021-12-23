package org.uoc.pds.alpha.cultureindahouse.ejb.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor

@Table(name = "question", schema = "pra2")
public class Question {

    @Id
    @Column(name = "id", updatable = false)
    @SequenceGenerator(name = "pra2.question_id_seq", sequenceName = "pra2.question_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pra2.question_id_seq")
	private Integer id;

	@Column(name = "title")
	private String title;

    @Column(name = "message")
    private String message;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @OneToOne(mappedBy = "question")
    private Response response;

}
