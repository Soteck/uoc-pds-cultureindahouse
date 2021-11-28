package org.uoc.pds.alpha.cultureindahouse.ejb.mapper;

import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Event;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventVO;

import java.util.ArrayList;
import java.util.List;

public class EventMapper {

    public static EventVO entityToVO(Event category) {
        EventVO ret = new EventVO();
        ret.setName(category.getName());
        ret.setDescription(category.getDescription());
        return ret;
    }

    public static List<EventVO> entityToVO(List<Event> events) {
        List<EventVO> ret = new ArrayList<>();
        for (Event event : events) {
            ret.add(entityToVO(event));
        }
        return ret;
    }
}
