package com.mycompany.dao.impl;

import com.mycompany.dao.inter.CountryDaoInter;
import com.mycompany.entity.Country;
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
public class CountryDaoImpl implements CountryDaoInter {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Country> getAllCountry() {
        Query q=em.createQuery("select c from Country c");
        List<Country> list= q.getResultList();
        return list;
    }

    @Override
    public Country getById(int id) {
        Country country=em.find(Country.class,id);
        return country;
    }

    @Override
    public boolean addCountry(Country c) {
        em.persist(c);
        return true;
    }

    @Override
    public boolean removeCountry(int id) {
        Country country=em.find(Country.class,id);
        em.remove(country);
        return true;
    }

    @Override
    public boolean updateCountry(Country c) {
        em.merge(c);
        return true;
    }

}
