package com.mycompany.dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.mycompany.entity.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
@Repository("userDao1")
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    EntityManager em;

//    @Cacheable(value = "users")
    @Override
    public List<User> getAllUser() {
        Query q = em.createQuery("select u from User u");
        return q.getResultList();

    }

    @Override
//    @Cacheable(value = "users")
    public List<User> getAllUser(String name, String surname, Integer nationalityId) {
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
        return q.getResultList();
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        Query q = em.createQuery("select u from User u where u.email= :e and u.password= :p", User.class);
        q.setParameter("e", email);
        q.setParameter("p", password);
        List<User> list = q.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }
    
//    CriteriaBuilder
//     @Override
//    public User findByEmailAndPassword(String email, String password) {
//        CriteriaBuilder cb= em.getCriteriaBuilder();
//        CriteriaQuery<User> q1=cb.createQuery(User.class);
//        Root<User> root=q1.from(User.class);
//        CriteriaQuery<User> q2=q1.where(cb.equal(root.get("email"),email),cb.equal(root.get("password"), password));
//        Query q=em.createQuery(q2);
//        List<User> list = q.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        return null;
//    }


    @Override
    public User findByEmail(String email) {
        Query q = em.createQuery("select u from User u where u.email=:e", User.class);
        q.setParameter("e", email);
        List<User> list = q.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }
    
//   Native Sql query
//     @Override
//    public User findByEmail(String email) {
//        Query q = em.createNativeQuery("select * from User u where u.email=?", User.class);
//        q.setParameter(1, email);
//        List<User> list = q.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        return null;
//    }
    
//    NamedQuery
//       @Override
//    public User findByEmail(String email) {
//        Query q = em.createNamedQuery("User.findByEmail", User.class);
//        q.setParameter("email", email);
//        List<User> list = q.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        return null;
//    }
    
//    CriteriaBuilder
//    @Override
//    public User findByEmail(String email) {
//        CriteriaBuilder cb=em.getCriteriaBuilder();
//        CriteriaQuery<User> q1=cb.createQuery(User.class);
//        Root<User> postRoot=q1.from(User.class);
//        CriteriaQuery<User> q2=q1.where(cb.equal(postRoot.get("email"), email));
//        Query q = em.createQuery(q2);
//        List<User> list = q.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        return null;
//    }
    
    @Override
    public User getById(int userId) {
        User user = em.find(User.class, userId);
        return user;
    }

    @Override
    @CacheEvict(value = "users", allEntries=true)
    public boolean removeUser(int userId) {
        User user = em.find(User.class, userId);
        em.remove(user);
        return true;
    }

//    private BCrypt.Hasher crypt = BCrypt.withDefaults();

    private static BCryptPasswordEncoder crypt=new BCryptPasswordEncoder();

    @Override
    public boolean updateUser(User u) {
        em.merge(u);
        return true;
    }

    @Override
    public boolean addUser(User u) {
        u.setPassword(crypt.encode(u.getPassword()));
        em.persist(u);
        return true;
    }

}
