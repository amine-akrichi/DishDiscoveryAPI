package com.example.dishdiscoveryapi.controller;

import com.example.dishdiscoveryapi.model.Country;
import com.example.dishdiscoveryapi.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/country")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public void getCountries(){
        countryService.getCountries();
    }

    @PostMapping
    public void addNewCountry(@RequestBody Country country){
        countryService.addNewCountry(country);
    }

    @DeleteMapping(path = "{countryId}")
    public void deleteCountry(@PathVariable("countryId") Long id){
        countryService.deleteCountry(id);
    }

    @PutMapping(path ="{countryId}")
    public void updateCountry(@PathVariable Long countryId,@RequestBody Country country){
        countryService.updateCountry(countryId,country);
    }
}
