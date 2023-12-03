package com.example.dishdiscoveryapi.model;


import jakarta.persistence.*;

import java.time.LocalDate;


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

    public Recipe() {
    }

    public Recipe(LocalDate creationDate, String title, String description, String country, String type, int totalTime, int servings) {
        this.creationDate = creationDate;
        this.title = title;
        this.description = description;
        this.country = country;
        this.type = type;
        this.totalTime = totalTime;
        this.servings = servings;
    }

    public Recipe(Long id, LocalDate creationDate, String title, String description, String country, String type, int totalTime, int servings) {
        this.id = id;
        this.creationDate = creationDate;
        this.title = title;
        this.description = description;
        this.country = country;
        this.type = type;
        this.totalTime = totalTime;
        this.servings = servings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", country='" + country + '\'' +
                ", type='" + type + '\'' +
                ", totalTime=" + totalTime +
                ", servings=" + servings +
                '}';
    }
}
