package com.ship.ship.endpoint.controller;

import com.ship.ship.domain.service.CityService;
import com.ship.ship.persistence.model.City;
import com.ship.ship.utils.Utils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/private/cities")
public class CityController {

  private final CityService cityService;

  public CityController(CityService cityService) {
    this.cityService = cityService;
  }

  @PostMapping(value = "/")
  public City saveCity(@RequestBody City city) {
    return this.cityService.saveCity(city);
  }

  @PostMapping(value = "/mul")
  public List<City> saveCities(@RequestBody List<City> cityes) {
    List<City> finalList = new ArrayList<>();
    cityes.forEach(
        city -> {
          finalList.add(this.cityService.saveCity(city));
        });
    return finalList;
  }

  @PutMapping(value = "/{id}")
  public City updateCity(@PathVariable Integer id, @RequestBody City city) {
    String msg = String.format("The City Id %s is different from the Url Id", city.getId());
    Utils.validateUrlIdEqualsBodyId(id, city.getId(), msg);
    return this.cityService.updateCity(city);
  }

  @PutMapping(value = "/mul")
  public List<City> updateCity(@RequestBody List<City> cityes) {
    List<City> finalList = new ArrayList<>();
    cityes.forEach(
        city -> {
          finalList.add(this.cityService.updateCity(city));
        });
    return finalList;
  }

  @GetMapping(value = "/")
  public List<City> getCity() {
    return this.cityService.getCity();
  }

  @GetMapping(value = "/{id}")
  public City getCityById(@PathVariable Integer id) {
    return this.cityService.getCityById(id);
  }

  @DeleteMapping(value = "/{id}")
  public void deleteCity(@PathVariable Integer id, City city) {
    String msg = String.format("The City Id %s is different from the Url Id", city.getId());
    Utils.validateUrlIdEqualsBodyId(id, city.getId(), msg);
    this.cityService.deleteCity(city);
  }
}
