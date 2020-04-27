package com.mycompany.service.inter;

import com.mycompany.entity.Country;

import java.util.List;

/**
 *
 * @author Movsum Mammadov
 * 
 **/

public interface CountryServiceInter {
    
    List<Country> getAllCountry();
    
    Country getById(int id);
    
    boolean addCountry(Country c);
    
    boolean removeCountry(int id);
    
    boolean updateCountry(Country c);
    
}
