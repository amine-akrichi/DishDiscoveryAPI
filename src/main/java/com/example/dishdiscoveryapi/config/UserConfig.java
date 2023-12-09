package com.example.dishdiscoveryapi.config;

import com.example.dishdiscoveryapi.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner CommandLineRunner(UserRepository userRepository) {
        return args -> {
//            User amine = new User(1L,"amine.akrichi","amine123","amiene@gmail.com","amine","akrichi","hello im amine akrichi and im a student", Role.USER);
//            userRepository.save(amine);
        };
    }
}
