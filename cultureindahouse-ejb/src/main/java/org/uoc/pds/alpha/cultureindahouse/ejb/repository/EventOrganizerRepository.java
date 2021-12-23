package org.uoc.pds.alpha.cultureindahouse.ejb.repository;

import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Category;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Event;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.EventOrganizer;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.User;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Stateless
@TransactionManagement
public class EventOrganizerRepository implements EventOrganizerRepositoryInterface {


	@PersistenceContext(unitName = "GAO-PU")
	private EntityManager em;


	@Override
	public EventOrganizer add(EventOrganizer data) {
		em.persist(data);
		em.flush();
		return data;
	}

	@Override
	public void delete(Serializable id) {
		EventOrganizer data = this.get(id);
		em.remove(data);
	}

	@Override
	public EventOrganizer update(Serializable id, EventOrganizer data) {
		EventOrganizer bddData = this.get(id);
		bddData.setName(data.getName());
		bddData.setDescription(data.getDescription());
		em.flush();
		return bddData;
	}

	@Override
	public EventOrganizer get(Serializable id) {
		return em.find(EventOrganizer.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EventOrganizer> list() {
		Query query = em.createQuery("select e from EventOrganizer e");
		return query.getResultList();
	}


}
