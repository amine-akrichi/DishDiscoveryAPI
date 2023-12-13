package com.example.dishdiscoveryapi.controller;

import com.example.dishdiscoveryapi.model.Cuisine;
import com.example.dishdiscoveryapi.service.CuisineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/country")
public class CuisineController {

    private final CuisineService cuisineService;

    @Autowired
    public CuisineController(CuisineService cuisineService) {
        this.cuisineService = cuisineService;
    }

    @GetMapping
    public List<Cuisine> getCountries(){
       return cuisineService.getCountries();
    }

    @PostMapping
    public void addNewCountry(@RequestBody Cuisine cuisine){
        cuisineService.addNewCountry(cuisine);
    }

    @DeleteMapping(path = "{countryId}")
    public void deleteCountry(@PathVariable("countryId") Long id){
        cuisineService.deleteCountry(id);
    }

    @PutMapping(path ="{countryId}")
    public void updateCountry(@PathVariable Long countryId,@RequestBody Cuisine cuisine){
        cuisineService.updateCountry(countryId, cuisine);
    }
}
