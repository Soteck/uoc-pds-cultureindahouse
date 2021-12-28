package org.uoc.pds.alpha.cultureindahouse.ejb.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
public class EventOrganizerVO {

    private Integer id;

    private String name;

    private String description;

    private UserVO administrator;

    private Collection<EventVO> events;

    public EventOrganizerVO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventOrganizerVO that = (EventOrganizerVO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, administrator);
    }
}
