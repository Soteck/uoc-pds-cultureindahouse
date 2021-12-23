package org.uoc.pds.alpha.cultureindahouse.ejb.repository;

import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Category;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Comment;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Stateless
@TransactionManagement
public class CommentRepository implements CommentRepositoryInterface {


	@PersistenceContext(unitName = "GAO-PU")
	private EntityManager em;


	@Override
	public Comment add(Comment data) {
		em.persist(data);
		em.flush();
		return data;
	}

	@Override
	public void delete(Serializable id) {
		Comment data = this.get(id);
		em.remove(data);
	}

	@Override
	public Comment update(Serializable id, Comment data) {
		Comment bddData = this.get(id);
		bddData.setText(data.getText());
		bddData.setUser(data.getUser());
		bddData.setEvent(data.getEvent());
		em.flush();
		return bddData;
	}

	@Override
	public Comment get(Serializable id) {
		return em.find(Comment.class, id);
	}

	@Override
	public List<Comment> list() {
		Query query = em.createQuery("select c from Comment c");
		return query.getResultList();
	}
}
