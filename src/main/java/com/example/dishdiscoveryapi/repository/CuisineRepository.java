package com.example.dishdiscoveryapi.repository;

import com.example.dishdiscoveryapi.model.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuisineRepository extends JpaRepository<Cuisine, Long>{

}
