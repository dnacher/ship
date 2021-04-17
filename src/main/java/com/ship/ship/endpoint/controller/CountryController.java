package com.ship.ship.endpoint.controller;

import com.ship.ship.domain.service.CountryService;
import com.ship.ship.persistence.model.Country;
import com.ship.ship.utils.Utils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/private/countries")
public class CountryController {

  private final CountryService countryService;

  public CountryController(CountryService countryService) {
    this.countryService = countryService;
  }

  @PostMapping(value = "/")
  public Country saveCountry(@RequestBody Country country) {
    return this.countryService.saveCountry(country);
  }

  @PostMapping(value = "/mul")
  public List<Country> saveCountryes(@RequestBody List<Country> countryes) {
    List<Country> finalList = new ArrayList<>();
    countryes.forEach(
        country -> {
          finalList.add(this.countryService.saveCountry(country));
        });
    return finalList;
  }

  @PutMapping(value = "/{id}")
  public Country updateCountry(@PathVariable Integer id, @RequestBody Country country) {
    String msg = String.format("The Country Id %s is different from the Url Id", country.getId());
    Utils.validateUrlIdEqualsBodyId(id, country.getId(), msg);
    return this.countryService.updateCountry(country);
  }

  @PutMapping(value = "/mul")
  public List<Country> updateCountry(@RequestBody List<Country> countryes) {
    List<Country> finalList = new ArrayList<>();
    countryes.forEach(
        country -> {
          finalList.add(this.countryService.updateCountry(country));
        });
    return finalList;
  }

  @GetMapping(value = "/")
  public List<Country> getCountry() {
    return this.countryService.getCountry();
  }

  @GetMapping(value = "/{id}")
  public Country getCountryById(@PathVariable Integer id) {
    return this.countryService.getCountryById(id);
  }

  @DeleteMapping(value = "/{id}")
  public void deleteCountry(@PathVariable Integer id, Country country) {
    String msg = String.format("The Country Id %s is different from the Url Id", country.getId());
    Utils.validateUrlIdEqualsBodyId(id, country.getId(), msg);
    this.countryService.deleteCountry(country);
  }
}
