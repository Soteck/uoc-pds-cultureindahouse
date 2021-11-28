package org.uoc.pds.alpha.cultureindahouse.ejb.repository;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.uoc.pds.alpha.cultureindahouse.ejb.entity.OrderHistory;

@Stateless
@TransactionManagement
public class OrderHistoryRepository implements OrderHistoryRepositoryInterface {

	@PersistenceContext(unitName = "GAO-PU")
	private EntityManager em;

	@Override
	public OrderHistory add(OrderHistory data) {
		em.persist(data);
		em.flush();
		return data;
	}

	@Override
	public void delete(Serializable id) {
		OrderHistory data = this.get(id);
		em.remove(data);
	}

	@Override
	public OrderHistory update(Serializable id, OrderHistory data) {
		OrderHistory bddData = this.get(id);

		bddData.setDate(data.getDate());
		bddData.setReservationId(data.getReservationId());
		bddData.setOrderId(data.getOrderId());
		bddData.setEvent(data.getEvent());
		bddData.setUser(data.getUser());

		em.flush();
		return bddData;
	}

	@Override
	public OrderHistory get(Serializable id) {
		return em.find(OrderHistory.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<OrderHistory> list() {
		Query query = em.createQuery("select c from OrderHistory c");
		return query.getResultList();
	}
}
