package com.example.dishdiscoveryapi.controller;

import com.example.dishdiscoveryapi.model.UserEntity;
import com.example.dishdiscoveryapi.repository.UserRepository;
import com.example.dishdiscoveryapi.service.UserService;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<UserEntity> getUsers() {
        return userService.getUsers();
    }

//    @PostMapping("/auth/register")
//    public User register(@RequestBody User user){
//        return new User();
//    }
//    @PostMapping("/auth/login")
//    public User login(@RequestBody User user){
//        return new User();
//    }

    @GetMapping(path = "{username}")
    public UserEntity getUser(@PathVariable String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalStateException("User with username: " + username + " does not exist in the database"));
    }
    @PostMapping
    public void addUser(@RequestBody UserEntity user) {
        userService.addUser(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }


    @PutMapping(path = "{userId}")
    public void updateUser(@PathVariable Long userId, @RequestBody UserEntity user) {
        userService.updateUser(userId,user);
    }


}
