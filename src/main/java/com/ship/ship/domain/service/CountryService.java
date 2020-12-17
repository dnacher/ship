package com.ship.ship.domain.service;

import com.ship.ship.persistence.dao.CountryDAO;
import com.ship.ship.persistence.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CountryService {

    @Autowired
    private CountryDAO countryDAO;

    public List<Country> getCountry(){
        return countryDAO.getCountry();
    }

    public Country getCountryById(Integer id){
        return countryDAO.getCountryById(id);
    }

    public Country saveCountry(Country country){
        return countryDAO.saveCountry(country);
    }

    public Country updateCountry(Country country){
        return countryDAO.updateCountry(country);
    }

    public void deleteCountry(Country country){
        countryDAO.deleteCountry(country);
    }
}
