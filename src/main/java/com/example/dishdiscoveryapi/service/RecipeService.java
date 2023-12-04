package com.example.dishdiscoveryapi.service;

import com.example.dishdiscoveryapi.model.Recipe;
import com.example.dishdiscoveryapi.repository.RecipeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    public void addNewRecipe(Recipe recipe) {
        if (!recipeRepository.existsById(recipe.getId())) {
            recipeRepository.save(recipe);
        } else {
            throw new IllegalStateException("Recipe Already Exists");
        }
    }

    public void deleteRecipe(Long id) {
        if (recipeRepository.existsById(id)) {
            recipeRepository.deleteById(id);
        } else {
            throw new IllegalStateException("Recipe with id: " + id + " does not exits");
        }
    }

    @Transactional
    public void updateRecipe(Long id, Recipe recipe) {
        Recipe recipeToUpdate = recipeRepository.findById(id)
                .orElseThrow(
                        () -> {
                            new IllegalStateException("Recipe with id: " + id + " does not exits");
                            return null;
                        }
                );
        recipeToUpdate.setTitle(recipe.getTitle());
        recipeToUpdate.setDescription(recipe.getDescription());
        recipeToUpdate.setCountry(recipe.getCountry());
        recipeToUpdate.setType(recipe.getType());
        recipeToUpdate.setTotalTime(recipe.getTotalTime());
        recipeToUpdate.setServings(recipe.getServings());

    }
}
