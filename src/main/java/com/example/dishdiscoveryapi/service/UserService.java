package com.example.dishdiscoveryapi.service;

import com.example.dishdiscoveryapi.model.User;
import com.example.dishdiscoveryapi.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository ;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        if (userRepository.findById(user.getId()).get().getUsername().equals(user.getUsername())){
            throw new IllegalStateException("User with id : "+user.getId()+" already exist in the database");
        }else {
            userRepository.save(user);
        }
    }

    public void deleteUser(Long userId){
        if (userRepository.existsById(userId)){
            userRepository.deleteById(userId);
        }else {
            throw new IllegalStateException("User with id: "+userId+" does not exist in the database");
        }
    }


    @Transactional
    public void updateUser(Long userId, User user){
        User userToUpdate = userRepository.findById(userId)
                .orElseThrow(
                        ()->{
                            new IllegalStateException("User with id: "+userId+" does not exist in the database");
                            return null;
                        }
                );

        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setName(user.getName());
        userToUpdate.setLastname(user.getLastname());
        userToUpdate.setDescription(user.getDescription());
        userToUpdate.setPassword(user.getPassword());
        if (userRepository.getUserByUsername(user.getUsername()).isPresent()){
            throw new IllegalStateException("User with username: "+user.getUsername()+" already exists in the database");
        }else {
            userToUpdate.setUsername(user.getUsername());
        }

    }

}
