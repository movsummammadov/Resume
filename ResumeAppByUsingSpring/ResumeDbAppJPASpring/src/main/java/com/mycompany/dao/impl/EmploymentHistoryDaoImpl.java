package com.mycompany.dao.impl;

import com.mycompany.dao.inter.EmploymentHistoryDaoInter;
import com.mycompany.entity.EmploymentHistory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 *
 * @author Movsum Mammadov
 *
 */
@Repository
public class EmploymentHistoryDaoImpl implements EmploymentHistoryDaoInter {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<EmploymentHistory> getAll() {
        Query q=em.createQuery("select eh from EmploymentHistory eh");
        List<EmploymentHistory> list=q.getResultList();
        return list;
    }

    @Override
    public List<EmploymentHistory> getAllImploymentHistoryByUserId(int userId) {
        Query q = em.createQuery("select eh from EmploymentHistory eh where eh.user.id=:usid", EmploymentHistory.class);
        q.setParameter("usid", userId);
        List<EmploymentHistory> list = q.getResultList();
        return list;
    }

    public EmploymentHistory getById(int id) {
        EmploymentHistory employmentHistory=em.find(EmploymentHistory.class,id);
        return employmentHistory;
    }
    @Override
    public boolean updateEmploymentHistory(EmploymentHistory eh) {
        em.merge(eh);
        return true;
    }

    @Override
    public boolean removeEmploymentHistory(int id) {
        EmploymentHistory eh=em.find(EmploymentHistory.class,id);
        em.remove(eh);
        return true;
    }

    @Override
    public boolean addEmploymentHistory(EmploymentHistory eh) {
        em.persist(eh);
        return true;
    }

}
