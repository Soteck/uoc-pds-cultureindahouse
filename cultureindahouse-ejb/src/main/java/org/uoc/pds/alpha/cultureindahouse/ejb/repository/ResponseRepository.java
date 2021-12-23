package org.uoc.pds.alpha.cultureindahouse.ejb.repository;

import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Response;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Stateless
@TransactionManagement
public class ResponseRepository implements ResponseRepositoryInterface {

    @PersistenceContext(unitName = "GAO-PU")
    private EntityManager em;

    @Override
    public Response add(Response data) {
        em.persist(data);
        em.flush();
        return data;
    }

    @Override
    public void delete(Serializable id) {
        Response data = this.get(id);
        em.remove(data);
    }

    @Override
    public Response update(Serializable id, Response data) {
        Response bddData = this.get(id);

        bddData.setMessage(data.getMessage());
        bddData.setQuestion(data.getQuestion());

        em.flush();
        return bddData;
    }

    @Override
    public Response get(Serializable id) {
        return em.find(Response.class, id);
    }

    @Override
    public List<Response> list() {
        Query query = em.createQuery("select c from Response c");
        return query.getResultList();
    }
}
