package org.uoc.pds.alpha.cultureindahouse.ejb.mapper;

import java.util.ArrayList;
import java.util.List;

import org.uoc.pds.alpha.cultureindahouse.ejb.entity.EventOrganizer;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventOrganizerVO;

import lombok.var;

public class EventOrganizerMapper {


    public static EventOrganizer voToEntity(EventOrganizerVO eventOrganizerVO) {
        EventOrganizer ret = new EventOrganizer();

        var id = eventOrganizerVO.getId();

        if (id != null) {
            ret.setId(id);
        }
        ret.setName(eventOrganizerVO.getName());
        ret.setDescription(eventOrganizerVO.getDescription());
        ret.setAdministrator(UserMapper.voToEntity(eventOrganizerVO.getAdministrator()));
        return ret;
    }

    public static EventOrganizerVO entityToVO(EventOrganizer eventOrganizer) {
        EventOrganizerVO ret = new EventOrganizerVO();
        ret.setId(eventOrganizer.getId());
        ret.setName(eventOrganizer.getName());
        ret.setDescription(eventOrganizer.getDescription());
        ret.setAdministrator(UserMapper.entityToVO(eventOrganizer.getAdministrator()));
        return ret;
    }

    public static List<EventOrganizerVO> entityToVO(List<EventOrganizer> categories) {
        List<EventOrganizerVO> ret = new ArrayList<>();
        for (EventOrganizer eventOrganizer : categories) {
            ret.add(entityToVO(eventOrganizer));
        }
        return ret;
    }


}
