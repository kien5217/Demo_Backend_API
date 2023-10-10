package com.boot.kiendemo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.boot.kiendemo.object.User;
import com.boot.kiendemo.repository.UserRepository;
@Service("userService")
public class UserService {
    private UserRepository userRepository ;
    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    // Get all
    public List<User> findAllUser(){
        return userRepository.findAll();
    }
    List<User> all = findAllUser();
    // Get one user based on id
    public ResponseEntity<User> getUserById (Long id) {
        Optional<User> user = userRepository.findById(id);
 
    if(user.isPresent()) {
        return ResponseEntity.ok().body(user.get());
    } else {
        return ResponseEntity.notFound().build();
    }
    
}
    //save user
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User newUser = userRepository.save(user);
        return ResponseEntity.ok(newUser);
    }
    // update new user
    
    public ResponseEntity<User> updateUser(Long id,User updatedUser){
        if(id == null){
            System.out.println("Id cannot be null");
        }
        User existingUser ;
        for(User us : all){
            Long it = us.getId();
            if(it == id ) {
                us.setName(updatedUser.getName());
                us.setEmail(updatedUser.getEmail());
                existingUser = us;
            }
        }
        existingUser = updatedUser;
        User savedEntity
        = userRepository.save(existingUser);
        return ResponseEntity.ok(savedEntity);
    }
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
