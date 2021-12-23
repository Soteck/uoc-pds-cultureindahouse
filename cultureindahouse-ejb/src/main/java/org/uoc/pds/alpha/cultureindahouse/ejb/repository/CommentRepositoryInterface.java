package org.uoc.pds.alpha.cultureindahouse.ejb.repository;

import org.uoc.pds.alpha.cultureindahouse.ejb.base.BaseRepository;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Category;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Comment;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CommentRepositoryInterface extends BaseRepository<Comment> {

}
