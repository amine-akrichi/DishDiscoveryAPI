package com.example.dishdiscoveryapi.controller;

import com.example.dishdiscoveryapi.model.ImageModel;
import com.example.dishdiscoveryapi.model.Recipe;
import com.example.dishdiscoveryapi.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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

    @GetMapping(path = "{recipeId}")
    public Optional<Recipe> getRecipe(@PathVariable Long recipeId){
        return recipeService.getRecipe(recipeId);
    }
    @PostMapping()
    public void addNewRecipe(@RequestBody Recipe recipe
                            /* @RequestParam("imageFile") MultipartFile file*/){
//        try {
//            recipe.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        recipeService.addNewRecipe(recipe);
    }

    public ImageModel uploadImage(MultipartFile file) throws IOException {
        return new ImageModel(file.getOriginalFilename(),file.getContentType(),file.getBytes());
    }

    @DeleteMapping(path = "{recipeId}")
    public void deleteRecipe(@PathVariable("recipeId") Long id){
        recipeService.deleteRecipe(id);
    }



    @PutMapping(path ="{recipeId}")
    public void updateRecipe(@PathVariable Long recipeId,@RequestBody Recipe recipe){
        recipeService.updateRecipe(recipeId,recipe);
    }
}
