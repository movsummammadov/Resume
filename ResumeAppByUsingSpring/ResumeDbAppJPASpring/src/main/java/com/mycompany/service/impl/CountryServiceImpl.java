package com.mycompany.service.impl;

import com.mycompany.dao.inter.CountryDaoInter;
import com.mycompany.entity.Country;
import com.mycompany.service.inter.CountryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author Movsum Mammadov
 *
 *
 */
@Service
@Transactional
public class CountryServiceImpl implements CountryServiceInter {

    @Autowired
    private CountryDaoInter countryDao;

    @Override
    public List<Country> getAllCountry() {
        return countryDao.getAllCountry();
    }

    @Override
    public Country getById(int id) {
        return countryDao.getById(id);
    }

    @Override
    public boolean addCountry(Country c) {
        return countryDao.addCountry(c);
    }

    @Override
    public boolean removeCountry(int id) {
        return countryDao.removeCountry(id);
    }

    @Override
    public boolean updateCountry(Country c) {
        return countryDao.updateCountry(c);
    }

}
