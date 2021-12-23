package org.uoc.pds.alpha.cultureindahouse.ejb.repository;

import javax.ejb.Local;

import org.uoc.pds.alpha.cultureindahouse.ejb.base.BaseRepository;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.User;

@Local
public interface UserRepositoryInterface extends BaseRepository<User> {

    User getUserByEmail(String email);
}
