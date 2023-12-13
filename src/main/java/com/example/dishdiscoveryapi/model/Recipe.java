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
    @Column(length = 50000)
    private String recipe;
    private String type;
    private String country;
    private int totalTime;
    private int servings;
    @Lob
    @Column(columnDefinition = "MEDIUMTEXT")
    private String image;

}
