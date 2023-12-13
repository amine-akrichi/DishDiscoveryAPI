package com.example.dishdiscoveryapi.service;

import com.example.dishdiscoveryapi.model.Cuisine;
import com.example.dishdiscoveryapi.repository.CuisineRepository;
import jakarta.transaction.Transactional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Slf4j
public class CuisineService {

    private final CuisineRepository cuisineRepository;

    @Autowired
    public CuisineService(CuisineRepository cuisineRepository) {
        this.cuisineRepository = cuisineRepository;
    }

    public List<Cuisine> getCountries() {
        return cuisineRepository.findAll();
    }
    public void addNewCountry(Cuisine cuisine) {
        if (!cuisineRepository.existsById(cuisine.getId())) {
            cuisineRepository.save(cuisine);
        } else {
            throw new IllegalStateException("Country Already Exists");
        }
    }

    public void deleteCountry(Long id) {
        if (cuisineRepository.existsById(id)) {
            cuisineRepository.deleteById(id);
        } else {
            throw new IllegalStateException("Country with id: " + id + " does not exits");
        }
    }

    @Transactional
    public void updateCountry(Long id, Cuisine cuisine) {
        Cuisine cuisineToUpdate = cuisineRepository.findById(id)
                .orElseThrow(
                        () -> {
                            new IllegalStateException("Country with id: " + id + " does not exits");
                            return null;
                        }
                );
        cuisineToUpdate.setName(cuisine.getName());
        cuisineToUpdate.setImage(cuisine.getImage());
        cuisineToUpdate.setDescription(cuisine.getDescription());
        cuisineToUpdate.setDescription(cuisine.getDescription());
    }
}
