package org.uoc.pds.alpha.cultureindahouse.ejb.repository;

import javax.ejb.Local;

import org.uoc.pds.alpha.cultureindahouse.ejb.base.BaseRepository;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Event;

import java.util.List;

@Local
public interface EventRepositoryInterface extends BaseRepository<Event> {
    Event getEventByName(String name);
    List<Event> getEventsByName(String name);
}
