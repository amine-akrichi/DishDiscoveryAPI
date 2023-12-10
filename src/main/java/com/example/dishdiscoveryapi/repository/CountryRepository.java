package com.example.dishdiscoveryapi.repository;

import com.example.dishdiscoveryapi.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{

}
