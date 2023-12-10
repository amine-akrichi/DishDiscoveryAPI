package com.example.dishdiscoveryapi.config;

import com.example.dishdiscoveryapi.model.Recipe;
import com.example.dishdiscoveryapi.model.UserEntity;
import com.example.dishdiscoveryapi.repository.RecipeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class RecipeConfig {
//    @Bean
//    CommandLineRunner commandLineRunner(RecipeRepository recipeRepository) {
//        return args -> {
//            Recipe lablebi = new Recipe(1L,LocalDate.now(), "Lablebi", "Bread soaked in chickpea soup mixed with Harissa and other condiments", "Tunisia", "vegan", 60, 5,new UserEntity());
//            Recipe hamburger = new Recipe(2L,LocalDate.now(), "Hamburger", "Brioche bun filled with a meat patty, mayo, ketchup, lettuce and tomato ", "USA", "Non-vegan", 20, 2,new UserEntity());
//            recipeRepository.saveAll(
//                    List.of(lablebi,hamburger)
//            );
//        };
//
//    }
}
