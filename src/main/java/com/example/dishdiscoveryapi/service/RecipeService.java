package com.example.dishdiscoveryapi.service;

import com.example.dishdiscoveryapi.model.Recipe;
import com.example.dishdiscoveryapi.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getRecipes() {
        return recipeRepository.findAll();
    }

    public void addNewRecipe(Recipe recipe){
        if (! recipeRepository.existsById(recipe.getId())){
            recipeRepository.save(recipe);
        }
        else {
            throw new IllegalStateException("Recipe Already Exists");
        }

    }
}
