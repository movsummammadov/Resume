package com.mycompany.dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.mycompany.dao.inter.AbstractDao;
import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Movsum Mammadov
 *
 *
 *
 */
public class UserDaoImpl extends AbstractDao implements UserDaoInter {

    @Override
    public List<User> getAllUser() {
        EntityManager em = em();
        Query q = em.createQuery("select u from User u");
        List<User> list=q.getResultList();
        em.close();
        return list;
    }

    @Override
    public List<User> getAllUser(String name, String surname, Integer nationalityId) {
        EntityManager em = em();
        String jpql = "select u from User u where 1=1";
        if (name != null && !name.trim().isEmpty()) {
            jpql += " and u.name=:name ";
        }
        if (surname != null && !surname.trim().isEmpty()) {
            jpql += " and u.surname=:surname ";
        }
        if (nationalityId != null) {
            jpql += " and u.nationality.id=: nid";
        }

        Query q = em.createQuery(jpql, User.class);
        if (name != null && !name.trim().isEmpty()) {
            q.setParameter("name", name);
        }
        if (surname != null && !surname.trim().isEmpty()) {
            q.setParameter("surname", surname);
        }
        if (nationalityId != null) {
            q.setParameter("nid", nationalityId);
        }
        List<User> list=q.getResultList();
        em.close();
        return list;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        EntityManager em = em();
        Query q = em.createQuery("select u from User u where u.email= :e and u.password= :p", User.class);
        q.setParameter("e", email);
        q.setParameter("p", password);
        List<User> list = q.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }
        em.close();
        return null;
    }
    
//    CriteriaBuilder
//     @Override
//    public User findByEmailAndPassword(String email, String password) {
//        EntityManager em = em();
//        CriteriaBuilder cb= em.getCriteriaBuilder();
//        CriteriaQuery<User> q1=cb.createQuery(User.class);
//        Root<User> root=q1.from(User.class);
//        CriteriaQuery<User> q2=q1.where(cb.equal(root.get("email"),email),cb.equal(root.get("password"), password));
//        Query q=em.createQuery(q2);
//        List<User> list = q.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        em.close();
//        return null;
//    }


    @Override
    public User findByEmail(String email) {
        EntityManager em = em();
        Query q = em.createQuery("select u from User u where u.email=:e", User.class);
        q.setParameter("e", email);
        List<User> list = q.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }
        em.close();
        return null;
    }
    
//   Native Sql query
//     @Override
//    public User findByEmail(String email) {
//        EntityManager em = em();
//        Query q = em.createNativeQuery("select * from User u where u.email=?", User.class);
//        q.setParameter(1, email);
//        List<User> list = q.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        em.close();
//        return null;
//    }
    
//    NamedQuery
//       @Override
//    public User findByEmail(String email) {
//        EntityManager em = em();
//        Query q = em.createNamedQuery("User.findByEmail", User.class);
//        q.setParameter("email", email);
//        List<User> list = q.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        em.close();
//        return null;
//    }
    
//    CriteriaBuilder
//    @Override
//    public User findByEmail(String email) {
//        EntityManager em = em();
//        CriteriaBuilder cb=em.getCriteriaBuilder();
//        CriteriaQuery<User> q1=cb.createQuery(User.class);
//        Root<User> postRoot=q1.from(User.class);
//        CriteriaQuery<User> q2=q1.where(cb.equal(postRoot.get("email"), email));
//        Query q = em.createQuery(q2);
//        List<User> list = q.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        em.close();
//        return null;
//    }
    
    @Override
    public User getById(int userId) {
        EntityManager em = em();
        User user = em.find(User.class, userId);
        em.close();
        return user;
    }

    @Override
    public boolean removeUser(int userId) {
        EntityManager em = em();
        User user = em.find(User.class, userId);
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    private BCrypt.Hasher crypt = BCrypt.withDefaults();

    @Override
    public boolean updateUser(User u) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean addUser(User u) {
        u.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));
        EntityManager em = em();
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        em.close();
        return true;
    }

}
