package org.uoc.pds.alpha.cultureindahouse.ejb.repository;

import org.uoc.pds.alpha.cultureindahouse.ejb.base.BaseRepository;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Rating;

import javax.ejb.Local;

@Local
public interface RatingRepositoryInterface extends BaseRepository<Rating> {
}
