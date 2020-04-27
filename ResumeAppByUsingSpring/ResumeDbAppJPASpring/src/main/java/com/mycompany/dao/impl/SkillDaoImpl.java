package com.mycompany.dao.impl;

import com.mycompany.dao.inter.SkillDaoInter;
import com.mycompany.entity.Skill;
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
public class SkillDaoImpl implements SkillDaoInter {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Skill> getAllSkill() {
        Query q=em.createQuery("select sk from Skill sk");
        List<Skill> list=q.getResultList();
        return list;
    }

    @Override
    public List<Skill> getByName(String name) {
        Query q=em.createQuery("select sk from Skill sk where sk.name=:name");
        q.setParameter("name",name);
        List<Skill> list =q.getResultList();
        return list;
    }

//    @Override
//    public List<Skill> getByName(String name) {
//        CriteriaBuilder cb=em.getCriteriaBuilder();
//        CriteriaQuery<Skill> q=cb.createQuery(Skill.class);
//        Root<Skill> root=q.from(Skill.class);
//        CriteriaQuery<Skill> q2=q.where(cb.equal(root.get("name"),name));
//        Query query=em.createQuery(q2);
//        List<Skill> list =query.getResultList();
//        return list;
//    }

    @Override
    public Skill getById(int id) {
        Skill skill=em.find(Skill.class,id);
        return skill;
    }

    @Override
    public boolean addSkill(Skill s) {
        em.persist(s);
//        int id=s.getId();
        return true;
    }

    @Override
    public boolean removeSkill(int id) {
        Skill skill=em.find(Skill.class,id);
        em.remove(skill);
        return true;
    }

    @Override
    public boolean updateSkill(Skill s) {
        em.merge(s);
        return true;
    }

}
