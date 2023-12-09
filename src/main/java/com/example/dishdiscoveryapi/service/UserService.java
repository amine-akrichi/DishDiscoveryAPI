package com.example.dishdiscoveryapi.service;

import com.example.dishdiscoveryapi.model.UserEntity;
import com.example.dishdiscoveryapi.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public final UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.findByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User with username: " + username + " not found")
                        );
            }
        };
    }



    public List<UserEntity> getUsers(){
        return userRepository.findAll();
    }

    public void addUser(UserEntity user){
        if (userRepository.findByUsername(user.getUsername()).isPresent()){
            throw new IllegalStateException("User with username : "+user.getUsername()+" already exist in the database");
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
    public void updateUser(Long userId, UserEntity user){
        UserEntity userToUpdate = userRepository.findById(userId)
                .orElseThrow(
                        ()->{
                            new IllegalStateException("User with id: "+userId+" does not exist in the database");
                            return null;
                        }
                );

        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setFirstname(user.getFirstname());
        userToUpdate.setLastname(user.getLastname());
        userToUpdate.setDescription(user.getDescription());
        userToUpdate.setPassword(user.getPassword());
        if (userRepository.findByUsername(user.getUsername()).isPresent()){
            throw new IllegalStateException("User with username: "+user.getUsername()+" already exists in the database");
        }else {
            userToUpdate.setUsername(user.getUsername());
        }

    }

}
