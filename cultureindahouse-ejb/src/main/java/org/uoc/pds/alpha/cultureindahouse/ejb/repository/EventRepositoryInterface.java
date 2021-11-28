package org.uoc.pds.alpha.cultureindahouse.ejb.repository;

import javax.ejb.Local;

import org.uoc.pds.alpha.cultureindahouse.ejb.base.BaseRepository;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Event;

@Local
public interface EventRepositoryInterface extends BaseRepository<Event> {
}
