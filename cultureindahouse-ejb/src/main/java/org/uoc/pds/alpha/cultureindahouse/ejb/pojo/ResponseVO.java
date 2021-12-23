package org.uoc.pds.alpha.cultureindahouse.ejb.pojo;

import lombok.*;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Question;

import javax.persistence.*;
import java.util.Objects;

@Data
@NoArgsConstructor
public class ResponseVO {

 	private Integer id;

    private String message;

    private QuestionVO question;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseVO that = (ResponseVO) o;
        return Objects.equals(id, that.id) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message);
    }
}
