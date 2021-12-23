package org.uoc.pds.alpha.cultureindahouse.ejb.pojo;

import lombok.*;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Event;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Response;

import javax.persistence.*;
import java.util.Objects;

@Data
@NoArgsConstructor
public class QuestionVO {

  	private Integer id;

	private String title;

    private String message;

    private EventVO event;

    private ResponseVO response;

    public QuestionVO(Integer id, String title, String message, EventVO event, ResponseVO response) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.event = event;
        this.response = response;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionVO that = (QuestionVO) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
