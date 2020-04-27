package com.mycompany.dao.impl;

import com.mycompany.dao.inter.AbstractDao;
import com.mycompany.dao.inter.UserSkillDaoInter;
import com.mycompany.entity.UserSkill;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 *
 * @author Movsum Mammadov
 *
 *
 */
public class UserSkillDaoImpl extends AbstractDao implements UserSkillDaoInter {

    @Override
    public List<UserSkill> getAllUserSkillByUserId(int userId) {
        EntityManager em=em();
        Query q=em.createQuery("select us from UserSkill us where us.user.id=:userId");
        q.setParameter("userId",userId);
        List<UserSkill> list=q.getResultList();
        em.close();
        return list;
    }

    @Override
    public boolean updateUserSkill(UserSkill usk) {
        EntityManager em=em();
        em.getTransaction().begin();
        em.merge(usk);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean removeUserSkill(int id) {
        EntityManager em=em();
        UserSkill usk=em.find(UserSkill.class,id);
        em.getTransaction().begin();
        em.remove(usk);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean addUserSkill(UserSkill usk) {
        EntityManager em=em();
        em.getTransaction().begin();
        em.persist(usk);
        em.getTransaction().commit();
        em.close();
        return true;
    }

}
