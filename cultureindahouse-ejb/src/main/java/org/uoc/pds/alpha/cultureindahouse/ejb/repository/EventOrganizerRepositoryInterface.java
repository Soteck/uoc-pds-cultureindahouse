package org.uoc.pds.alpha.cultureindahouse.ejb.repository;

import org.uoc.pds.alpha.cultureindahouse.ejb.base.BaseRepository;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Category;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.EventOrganizer;

import javax.ejb.Local;

@Local
public interface EventOrganizerRepositoryInterface extends BaseRepository<EventOrganizer> {
}
