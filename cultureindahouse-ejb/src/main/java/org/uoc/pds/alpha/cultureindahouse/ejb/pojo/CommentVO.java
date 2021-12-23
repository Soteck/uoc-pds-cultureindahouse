package org.uoc.pds.alpha.cultureindahouse.ejb.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class CommentVO {

    private Integer id;

    private String text;

    private EventVO event;

    private UserVO user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentVO comment = (CommentVO) o;
        return Objects.equals(id, comment.id) && Objects.equals(text, comment.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text);
    }
}
