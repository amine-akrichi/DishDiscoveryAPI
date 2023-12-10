package com.example.dishdiscoveryapi.service;

import com.example.dishdiscoveryapi.model.Country;
import com.example.dishdiscoveryapi.repository.CountryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getCountries() {
        return countryRepository.findAll();
    }
    public void addNewCountry(Country country) {
        if (!countryRepository.existsById(country.getId())) {
            countryRepository.save(country);
        } else {
            throw new IllegalStateException("Country Already Exists");
        }
    }

    public void deleteCountry(Long id) {
        if (countryRepository.existsById(id)) {
            countryRepository.deleteById(id);
        } else {
            throw new IllegalStateException("Country with id: " + id + " does not exits");
        }
    }

    @Transactional
    public void updateCountry(Long id, Country country) {
        Country countryToUpdate = countryRepository.findById(id)
                .orElseThrow(
                        () -> {
                            new IllegalStateException("Country with id: " + id + " does not exits");
                            return null;
                        }
                );
        countryToUpdate.setName(country.getName());
        countryToUpdate.setFlag(country.getFlag());
        countryToUpdate.setDescription(country.getDescription());
    }
}
