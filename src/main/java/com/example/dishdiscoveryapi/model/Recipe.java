package com.example.dishdiscoveryapi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private LocalDate creationDate;
    private String title;
    private String description;
    private String type;
    //    private List<String> ingredients;
//    private Map<Integer,String> steps;
//    private Map<String,String> nutritionFacts;
    private int totalTime;
    private int servings;
    @ManyToOne
    private Country country;
    @ManyToOne
    private UserEntity user;

    @OneToMany(mappedBy = "recipe")
    private List<Review> reviews;

}
