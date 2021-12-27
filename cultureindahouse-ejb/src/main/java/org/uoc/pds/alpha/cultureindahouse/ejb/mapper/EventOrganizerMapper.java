package org.uoc.pds.alpha.cultureindahouse.ejb.mapper;

import lombok.var;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.EventOrganizer;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventOrganizerVO;

import java.util.ArrayList;
import java.util.List;

public class EventOrganizerMapper {


    public static EventOrganizer toEntity(EventOrganizerVO eventOrganizerVO, boolean relations) {
        EventOrganizer ret = new EventOrganizer();

        ret.setId(eventOrganizerVO.getId());
        ret.setName(eventOrganizerVO.getName());
        ret.setDescription(eventOrganizerVO.getDescription());

        var user = eventOrganizerVO.getAdministrator();
        if (relations && user != null) {
            ret.setAdministrator(UserMapper.toEntity(user, false));
        }

        var events = eventOrganizerVO.getEvents();

        if (relations && events != null && !events.isEmpty()){
            ret.setEvents(EventMapper.toEntity(events, false));
        }

        return ret;
    }

    public static EventOrganizerVO toVO(EventOrganizer eventOrganizer, boolean relations) {
        EventOrganizerVO ret = new EventOrganizerVO();

        ret.setId(eventOrganizer.getId());
        ret.setName(eventOrganizer.getName());
        ret.setDescription(eventOrganizer.getDescription());

        var user = eventOrganizer.getAdministrator();
        if (relations && user != null) {
            ret.setAdministrator(UserMapper.toVO(user, false));
        }

        var events = eventOrganizer.getEvents();

        if (relations && events != null && !events.isEmpty()){
            ret.setEvents(EventMapper.toVO(events, false));
        }
        return ret;
    }

    public static List<EventOrganizer> toEntity(List<EventOrganizerVO> categories, boolean relations) {
        List<EventOrganizer> ret = new ArrayList<>();
        for (EventOrganizerVO eventOrganizer : categories) {
            ret.add(toEntity(eventOrganizer, relations));
        }
        return ret;
    }

    public static List<EventOrganizerVO> toVO(List<EventOrganizer> categories, boolean relations) {
        List<EventOrganizerVO> ret = new ArrayList<>();
        for (EventOrganizer eventOrganizer : categories) {
            ret.add(toVO(eventOrganizer, relations));
        }
        return ret;
    }


}
