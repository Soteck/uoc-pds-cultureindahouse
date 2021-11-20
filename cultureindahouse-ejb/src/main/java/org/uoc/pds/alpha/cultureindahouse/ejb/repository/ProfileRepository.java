package org.uoc.pds.alpha.cultureindahouse.ejb.repository;

import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Profile;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Stateless
@TransactionManagement
public class ProfileRepository implements ProfileRepositoryInterface {


	@PersistenceContext(unitName = "GAO-PU")
	private EntityManager em;


	@Override
	public Profile add(Profile data) {
		em.persist(data);
		em.flush();
		return data;
	}

	@Override
	public void delete(Serializable id) {
		Profile data = this.get(id);
		em.remove(data);
	}

	@Override
	public Profile update(Serializable id, Profile data) {
		Profile bddData = this.get(id);
		bddData.setName(data.getName());
		bddData.setPassword(data.getPassword());
		bddData.setSurnames(data.getSurnames());
		bddData.setNif(data.getNif());
		bddData.setPreferedLanguage(data.getPreferedLanguage());
		bddData.setAddress(data.getAddress());
		em.flush();
		return bddData;
	}

	@Override
	public Profile get(Serializable id) {
		return em.find(Profile.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Profile> list() {
		Query query = em.createQuery("select p from Profile p");
		return query.getResultList();
	}
}
