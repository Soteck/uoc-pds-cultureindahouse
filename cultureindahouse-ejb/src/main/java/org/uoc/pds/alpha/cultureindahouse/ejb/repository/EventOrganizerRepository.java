package org.uoc.pds.alpha.cultureindahouse.ejb.repository;

import org.uoc.pds.alpha.cultureindahouse.ejb.entity.*;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
		bddData.setAdministrator(data.getAdministrator());
		bddData.setEvents(data.getEvents());
		em.flush();
		return bddData;
	}

	@Override
	public EventOrganizer get(Serializable id) {
		return em.find(EventOrganizer.class, id);
	}

	@Override
	public List<EventOrganizer> list() {
		Query query = em.createQuery("select e from EventOrganizer e");
		return query.getResultList();
	}


}
