package org.uoc.pds.alpha.cultureindahouse.ejb.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "response", schema = "pra2")
public class Response {

    @Id
    @Column(name = "id", updatable = false)
    @SequenceGenerator(name = "pra2.response_id_seq", sequenceName = "pra2.response_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pra2.response_id_seq")
	private Integer id;

	@Column(name = "message")
    private String message;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    @ToString.Exclude
    private Question question;


    public Response(String message, Question question) {
        this.message = message;
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return Objects.equals(id, response.id) && Objects.equals(message, response.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message);
    }
}
