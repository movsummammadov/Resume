package com.mycompany.dao.impl;

import com.mycompany.dao.inter.AbstractDao;
import com.mycompany.dao.inter.CountryDaoInter;
import com.mycompany.entity.Country;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 *
 * @author Movsum Mammadov
 *
 *
 */
public class CountryDaoImpl extends AbstractDao implements CountryDaoInter {

    @Override
    public List<Country> getAllCountry() {
        EntityManager em=em();
        Query q=em.createQuery("select c from Country c");
        List<Country> list= q.getResultList();
        em.close();
        return list;
    }

    @Override
    public Country getById(int id) {
        EntityManager em=em();
        Country country=em.find(Country.class,id);
        em.close();
        return country;
    }

    @Override
    public boolean addCountry(Country c) {
        EntityManager em=em();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean removeCountry(int id) {
        EntityManager em=em();
        Country country=em.find(Country.class,id);
        em.getTransaction().begin();
        em.remove(country);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean updateCountry(Country c) {
        EntityManager em=em();
        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();
        em.close();
        return true;
    }

}
