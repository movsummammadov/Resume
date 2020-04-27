package com.mycompany.dao.impl;

import com.mycompany.dao.inter.AbstractDao;
import com.mycompany.dao.inter.SkillDaoInter;
import com.mycompany.entity.Skill;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Movsum Mammadov
 *
 *
 */
public class SkillDaoImpl extends AbstractDao implements SkillDaoInter {

    @Override
    public List<Skill> getAllSkill() {
        EntityManager em=em();
        Query q=em.createQuery("select sk from Skill sk");
        List<Skill> list=q.getResultList();
        em.close();
        return list;
    }

    @Override
    public List<Skill> getByName(String name) {
        EntityManager em=em();
        Query q=em.createQuery("select sk from Skill sk where sk.name=:name");
        q.setParameter("name",name);
        List<Skill> list =q.getResultList();
        em.close();
        return list;
    }

//    @Override
//    public List<Skill> getByName(String name) {
//        EntityManager em=em();
//        CriteriaBuilder cb=em.getCriteriaBuilder();
//        CriteriaQuery<Skill> q=cb.createQuery(Skill.class);
//        Root<Skill> root=q.from(Skill.class);
//        CriteriaQuery<Skill> q2=q.where(cb.equal(root.get("name"),name));
//        Query query=em.createQuery(q2);
//        List<Skill> list =query.getResultList();
//        em.close();
//        return list;
//    }

    @Override
    public Skill getById(int id) {
        EntityManager em=em();
        Skill skill=em.find(Skill.class,id);
        em.close();
        return skill;
    }

    @Override
    public boolean addSkill(Skill s) {
        EntityManager em=em();
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
//        int id=s.getId();
        em.close();
        return true;
    }

    @Override
    public boolean removeSkill(int id) {
        EntityManager em=em();
        Skill skill=em.find(Skill.class,id);
        em.getTransaction().begin();
        em.remove(skill);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean updateSkill(Skill s) {
        EntityManager em=em();
        em.getTransaction().begin();
        em.merge(s);
        em.getTransaction().commit();
        em.close();
        return true;
    }

}
