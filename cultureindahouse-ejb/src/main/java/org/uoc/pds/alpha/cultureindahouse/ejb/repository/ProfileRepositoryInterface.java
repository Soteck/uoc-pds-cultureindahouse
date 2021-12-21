package org.uoc.pds.alpha.cultureindahouse.ejb.repository;

import org.uoc.pds.alpha.cultureindahouse.ejb.base.BaseRepository;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Profile;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ProfileRepositoryInterface extends BaseRepository<Profile> {
    @Override
    default List<Profile> list() {
        return null;
    }
}
