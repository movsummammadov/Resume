package com.mycompany.dao.impl;

import com.mycompany.dao.inter.UserSkillDaoInter;
import com.mycompany.entity.UserSkill;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 *
 * @author Movsum Mammadov
 *
 *
 */
@Repository
public class UserSkillDaoImpl implements UserSkillDaoInter {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<UserSkill> getAllUserSkillByUserId(int userId) {
        Query q=em.createQuery("select us from UserSkill us where us.user.id=:userId");
        q.setParameter("userId",userId);
        List<UserSkill> list=q.getResultList();
        return list;
    }

    @Override
    public boolean updateUserSkill(UserSkill usk) {
        em.merge(usk);
        return true;
    }

    @Override
    public boolean removeUserSkill(int id) {
        UserSkill usk=em.find(UserSkill.class,id);
        em.remove(usk);
        return true;
    }

    @Override
    public boolean addUserSkill(UserSkill usk) {
        em.persist(usk);
        return true;
    }

}
