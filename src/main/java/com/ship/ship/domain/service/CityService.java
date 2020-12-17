package com.ship.ship.domain.service;

import com.ship.ship.persistence.dao.CityDAO;
import com.ship.ship.persistence.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CityService {

    @Autowired
    private CityDAO cityDAO;

    public List<City> getCity(){
        return cityDAO.getCity();
    }

    public City getCityById(Integer id){
        return cityDAO.getCityById(id);
    }

    public City saveCity(City city){
        return cityDAO.saveCity(city);
    }

    public City updateCity(City city){
        return cityDAO.updateCity(city);
    }

    public void deleteCity(City city){
        cityDAO.deleteCity(city);
    }
}
