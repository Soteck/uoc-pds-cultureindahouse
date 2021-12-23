package org.uoc.pds.alpha.cultureindahouse.ejb.repository;

import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Rating;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Stateless
@TransactionManagement
public class RatingRepository implements RatingRepositoryInterface {

    @PersistenceContext(unitName = "GAO-PU")
    private EntityManager em;

    @Override
    public Rating add(Rating data) {
        em.persist(data);
        em.flush();
        return data;
    }

    @Override
    public void delete(Serializable id) {
        Rating data = this.get(id);
        em.remove(data);
    }

    @Override
    public Rating update(Serializable id, Rating data) {
        Rating bddData = this.get(id);

        bddData.setRating(data.getRating());
        bddData.setEvent(data.getEvent());
        bddData.setUser(data.getUser());


        em.flush();
        return bddData;
    }

    @Override
    public Rating get(Serializable id) {
        return em.find(Rating.class, id);
    }

    @Override
    public List<Rating> list() {
        Query query = em.createQuery("select c from Rating c");
        return query.getResultList();
    }
}
