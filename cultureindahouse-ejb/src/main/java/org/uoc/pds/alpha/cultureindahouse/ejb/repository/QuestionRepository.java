package org.uoc.pds.alpha.cultureindahouse.ejb.repository;

import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Question;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Stateless
@TransactionManagement
public class QuestionRepository implements QuestionRepositoryInterface {

    @PersistenceContext(unitName = "GAO-PU")
    private EntityManager em;

    @Override
    public Question add(Question data) {
        em.persist(data);
        em.flush();
        return data;
    }

    @Override
    public void delete(Serializable id) {
        Question data = this.get(id);
        em.remove(data);
    }

    @Override
    public Question update(Serializable id, Question data) {
        Question bddData = this.get(id);

        bddData.setTitle(bddData.getTitle());
        bddData.setMessage(bddData.getMessage());
        bddData.setEvent(bddData.getEvent());
        bddData.setResponse(bddData.getResponse());


        em.flush();
        return bddData;
    }

    @Override
    public Question get(Serializable id) {
        return em.find(Question.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Question> list() {
        Query query = em.createQuery("select c from Question c");
        return query.getResultList();
    }
}
