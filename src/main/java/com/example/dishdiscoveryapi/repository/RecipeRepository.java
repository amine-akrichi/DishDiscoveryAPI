package com.example.dishdiscoveryapi.repository;

import com.example.dishdiscoveryapi.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository
        extends JpaRepository<Recipe, Long> {

    List<Recipe> findByUsername(String username);
}
