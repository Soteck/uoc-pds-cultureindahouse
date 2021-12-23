package org.uoc.pds.alpha.cultureindahouse.ejb.repository;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Event;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.User;

@Stateless
@TransactionManagement
public class EventRepository implements EventRepositoryInterface {


	@PersistenceContext(unitName = "GAO-PU")
	private EntityManager em;


	@Override
	public Event add(Event data) {
		em.persist(data);
		em.flush();
		return data;
	}

	@Override
	public void delete(Serializable id) {
		Event data = this.get(id);
		em.remove(data);
	}

	@Override
	public Event update(Serializable id, Event data) {
		Event bddData = this.get(id);
		bddData.setName(data.getName());
		bddData.setImage(data.getImage());
		bddData.setInitDate(data.getInitDate());
		bddData.setEndDate(data.getEndDate());
		em.flush();
		return bddData;
	}

	@Override
	public Event get(Serializable id) {
		return em.find(Event.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Event> list() {
		Query query = em.createQuery("select c from Category c");
		return query.getResultList();
	}

	@Override
	public List<Event> getEventByName(String name) {
		Query query = em.createQuery("select e from Event e where e.name like :name").setParameter("name", "%" + name + "%");
		return query.getResultList();
	}
}
