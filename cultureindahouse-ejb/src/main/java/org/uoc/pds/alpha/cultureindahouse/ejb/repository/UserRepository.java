package org.uoc.pds.alpha.cultureindahouse.ejb.repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.uoc.pds.alpha.cultureindahouse.ejb.entity.*;

@Stateless
@TransactionManagement

public class UserRepository implements UserRepositoryInterface {

    @PersistenceContext(unitName = "GAO-PU")
    private EntityManager em;

    @Override
    public User add(User data) {
        em.persist(data);
        em.flush();
        return data;
    }

    @Override
    public void delete(Serializable id) {
        User data = this.get(id);
        em.remove(data);
    }

    @Override
    public User update(Serializable id, User data) {
        User bddData = this.get(id);
        bddData.setEmail(data.getEmail());
        bddData.setPassword(data.getPassword());
        bddData.setName(data.getName());
        bddData.setSurname(data.getSurname());
        bddData.setNif(data.getNif());
        bddData.setPreferedLanguage(data.getPreferedLanguage());
        bddData.setAddress(data.getAddress());
        bddData.setAdministrator(data.isAdministrator());
        bddData.setEventOrganizers(data.getEventOrganizers());
        bddData.setOrderHistory(data.getOrderHistory());
        bddData.setFavorites(data.getFavorites());
        bddData.setRatings(data.getRatings());
        bddData.setComments(data.getComments());
        em.flush();
        return bddData;
    }

    @Override
    public User get(Serializable id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> list() {
        Query query = em.createQuery("select c from User c");
        return query.getResultList();
    }

    @Override
    public User getUserByEmail(String email) {
        Query query = em.createQuery("select u from User u where u.email = :email").setParameter("email", email);

        return ((User) query.getSingleResult());
    }

}
