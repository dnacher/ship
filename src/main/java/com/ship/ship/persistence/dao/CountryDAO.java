package com.ship.ship.persistence.dao;

import com.ship.ship.exceptions.ShipException;
import com.ship.ship.persistence.model.Country;
import com.ship.ship.persistence.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CountryDAO {

    @Autowired
    private CountryRepository repository;

    public List<Country> getCountry(){
        List<Country> countries = new ArrayList<>();
        this.repository.findAll().forEach(country -> countries.add(country));
        return countries;
    }

    public Country getCountryById(Integer id) throws ShipException {
        return this.repository.findById(id).orElseThrow(() ->
        {
            String msg = String.format("The country id %s does not exist", id.toString());
            return new ShipException(msg);
        });
    }

    public Country saveCountry(Country country) throws ShipException {
        return this.repository.save(country);
    }

    public List<Country> saveCountries(List<Country> countries) throws ShipException {
        List<Country> finalList= new ArrayList<>();
        this.repository.saveAll(countries).forEach(country -> {
            finalList.add(country);
        });
        return finalList;
    }

    public void deleteCountry(Country country){
        this.repository.delete(country);
    }

    public Country updateCountry(Country country) throws ShipException {
        if(country.getId()!=null){
            return this.repository.save(country);
        }else{
            String msg = String.format("Cannot update a country without an Id");
            throw new ShipException(msg);
        }
    }
}
