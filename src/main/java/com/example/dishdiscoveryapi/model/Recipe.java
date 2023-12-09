package com.example.dishdiscoveryapi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Recipe {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long id;
    private LocalDate creationDate;
    private String title;
    private String description;
    private String country;
    private String type;
    //    private List<String> ingredients;
//    private Map<Integer,String> steps;
//    private Map<String,String> nutritionFacts;
    private int totalTime;
    private int servings;

}
