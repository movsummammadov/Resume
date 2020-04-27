package com.mycompany.dao.impl;

import com.mycompany.dao.inter.AbstractDao;
import com.mycompany.dao.inter.EmploymentHistoryDaoInter;
import com.mycompany.entity.EmploymentHistory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 *
 * @author Movsum Mammadov
 *
 */
public class EmploymentHistoryDaoImpl extends AbstractDao implements EmploymentHistoryDaoInter {

    @Override
    public List<EmploymentHistory> getAll() {
        EntityManager em = em();
        Query q=em.createQuery("select eh from EmploymentHistory eh");
        List<EmploymentHistory> list=q.getResultList();
        em.close();
        return list;
    }

    @Override
    public List<EmploymentHistory> getAllImploymentHistoryByUserId(int userId) {
        EntityManager em = em();
        Query q = em.createQuery("select eh from EmploymentHistory eh where eh.user.id=:usid",EmploymentHistory.class);
        q.setParameter("usid", userId);
        List<EmploymentHistory> list = q.getResultList();
        em.close();
        return list;
    }

    public EmploymentHistory getById(int id) {
        EntityManager em=em();
        EmploymentHistory employmentHistory=em.find(EmploymentHistory.class,id);
        em.close();
        return employmentHistory;
    }
    @Override
    public boolean updateEmploymentHistory(EmploymentHistory eh) {
        EntityManager em=em();
        em.getTransaction().begin();
        em.merge(eh);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean removeEmploymentHistory(int id) {
        EntityManager em=em();
        EmploymentHistory eh=em.find(EmploymentHistory.class,id);
        em.getTransaction().begin();
        em.remove(eh);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean addEmploymentHistory(EmploymentHistory eh) {
        EntityManager em=em();
        em.getTransaction().begin();
        em.persist(eh);
        em.getTransaction().commit();
        em.close();
        return true;
    }

}
