package com.example.dishdiscoveryapi.service;

import com.example.dishdiscoveryapi.model.UserEntity;
import com.example.dishdiscoveryapi.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

        if(user.getEmail() !=null){
            userToUpdate.setEmail(user.getEmail());
        }
        if(user.getFirstname() !=null){
            userToUpdate.setFirstname(user.getFirstname());
        }
        if(user.getLastname() !=null){
            userToUpdate.setLastname(user.getLastname());
        }
        if(user.getDescription() !=null){
            userToUpdate.setDescription(user.getDescription());
        }
        if(user.getPassword() !=null){
            userToUpdate.setPassword(user.getPassword());
        }
        if(user.getProfilePicture() !=null){
            userToUpdate.setProfilePicture(user.getProfilePicture());
        }
        if(user.getUsername() !=null){
            if (userRepository.findByUsername(user.getUsername()).isPresent() && !userToUpdate.getUsername().equals(user.getUsername())){
                throw new IllegalStateException("User with username: "+user.getUsername()+" already exists in the database");
            }else {
                userToUpdate.setUsername(user.getUsername());
            }
        }

//        userToUpdate.setEmail(user.getEmail());
//        userToUpdate.setFirstname(user.getFirstname());
//        userToUpdate.setLastname(user.getLastname());
//        userToUpdate.setDescription(user.getDescription());
//        userToUpdate.setPassword(user.getPassword());
//        userToUpdate.setProfilePicture(user.getProfilePicture());
//        if (userRepository.findByUsername(user.getUsername()).isPresent() && !userToUpdate.getUsername().equals(user.getUsername())){
//            throw new IllegalStateException("User with username: "+user.getUsername()+" already exists in the database");
//        }else {
//            userToUpdate.setUsername(user.getUsername());
//        }

    }

}
