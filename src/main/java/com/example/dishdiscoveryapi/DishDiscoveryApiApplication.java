package com.example.dishdiscoveryapi;

import com.example.dishdiscoveryapi.model.Recipe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class DishDiscoveryApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(DishDiscoveryApiApplication.class, args);
    }
}
