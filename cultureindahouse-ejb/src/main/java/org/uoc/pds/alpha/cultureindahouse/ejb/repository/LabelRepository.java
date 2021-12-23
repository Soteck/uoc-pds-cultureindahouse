package org.uoc.pds.alpha.cultureindahouse.ejb.repository;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Label;

@Stateless
@TransactionManagement
public class LabelRepository implements LabelRepositoryInterface {


	@PersistenceContext(unitName = "GAO-PU")
	private EntityManager em;


	@Override
	public Label add(Label data) {
		em.persist(data);
		em.flush();
		return data;
	}

	@Override
	public void delete(Serializable id) {
		Label data = this.get(id);
		em.remove(data);
	}

	@Override
	public Label update(Serializable id, Label data) {
		Label bddData = this.get(id);
		bddData.setName(data.getName());
		bddData.setDescription(data.getDescription());
		bddData.setEvents(data.getEvents());
		em.flush();
		return bddData;
	}

	@Override
	public Label get(Serializable id) {
		return em.find(Label.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Label> list() {
		Query query = em.createQuery("select c from Label c");
		return query.getResultList();
	}
}
