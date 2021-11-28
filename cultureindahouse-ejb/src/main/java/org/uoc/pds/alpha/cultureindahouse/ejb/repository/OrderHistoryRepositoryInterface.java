package org.uoc.pds.alpha.cultureindahouse.ejb.repository;

import org.uoc.pds.alpha.cultureindahouse.ejb.base.BaseRepository;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Category;

import javax.ejb.Local;

@Local
public interface CategoryRepositoryInterface extends BaseRepository<Category> {
}
