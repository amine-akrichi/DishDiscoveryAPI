package com.example.dishdiscoveryapi.controller;

import com.example.dishdiscoveryapi.model.User;
import com.example.dishdiscoveryapi.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
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

    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }


    @PutMapping(path = "{userId}")
    public void updateUser(@PathVariable Long userId, @RequestBody User user) {
        userService.updateUser(userId,user);
    }


}
