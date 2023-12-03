package com.example.dishdiscoveryapi.controller;

import com.example.dishdiscoveryapi.model.Recipe;
import com.example.dishdiscoveryapi.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/recipe")
public class RecipeController {
    private final RecipeService recipeService;


    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<Recipe> getRecipes(){
        return recipeService.getRecipes();
    }

    @PostMapping
    public void addNewRecipe(@RequestBody Recipe recipe){
        recipeService.addNewRecipe(recipe);
    }

    @DeleteMapping(path = "{recipeId}")
    public void deleteRecipe(@PathVariable("recipeId") Long id){
        recipeService.deleteRecipe(id);
    }
}
