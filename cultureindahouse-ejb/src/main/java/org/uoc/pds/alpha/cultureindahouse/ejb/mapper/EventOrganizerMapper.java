package org.uoc.pds.alpha.cultureindahouse.ejb.mapper;

import lombok.var;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.EventOrganizer;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventOrganizerVO;

import java.util.ArrayList;
import java.util.List;

public class EventOrganizerMapper {


    public static EventOrganizer toEntity(EventOrganizerVO eventOrganizerVO) {
        EventOrganizer ret = new EventOrganizer();

        ret.setId(eventOrganizerVO.getId());
        ret.setName(eventOrganizerVO.getName());
        ret.setDescription(eventOrganizerVO.getDescription());

        var user = eventOrganizerVO.getAdministrator();
        if (user != null) {
            ret.setAdministrator(UserMapper.toEntity(user));
        }

        var events = eventOrganizerVO.getEvents();

        if (events != null && !events.isEmpty()){
            ret.setEvents(EventMapper.toEntity(events));
        }

        return ret;
    }

    public static EventOrganizerVO toVO(EventOrganizer eventOrganizer) {
        EventOrganizerVO ret = new EventOrganizerVO();

        ret.setId(eventOrganizer.getId());
        ret.setName(eventOrganizer.getName());
        ret.setDescription(eventOrganizer.getDescription());

        var user = eventOrganizer.getAdministrator();
        if (user != null) {
            ret.setAdministrator(UserMapper.toVO(user));
        }

        var events = eventOrganizer.getEvents();

        if (events != null && !events.isEmpty()){
            ret.setEvents(EventMapper.toVO(new ArrayList<>(events)));
        }
        return ret;
    }

    public static List<EventOrganizer> toEntity(List<EventOrganizerVO> categories) {
        List<EventOrganizer> ret = new ArrayList<>();
        for (EventOrganizerVO eventOrganizer : categories) {
            ret.add(toEntity(eventOrganizer));
        }
        return ret;
    }

    public static List<EventOrganizerVO> toVO(List<EventOrganizer> categories) {
        List<EventOrganizerVO> ret = new ArrayList<>();
        for (EventOrganizer eventOrganizer : categories) {
            ret.add(toVO(eventOrganizer));
        }
        return ret;
    }


}
