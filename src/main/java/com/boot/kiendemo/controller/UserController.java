package com.boot.kiendemo.controller;

import com.boot.kiendemo.object.User;
import com.boot.kiendemo.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/k1")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping(value = "/users")
    public List<User> findAllUsers (){
        return userService.findAllUser();
    }
    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> getUserByIdController (@PathVariable Long id){
        return userService.getUserById(id);
    }
    @PostMapping(value = "/user")
    public ResponseEntity<User> saveUserController (@RequestBody User user){
        return userService.saveUser(user);
    }
    @PutMapping(path = "users/{userId}")
    public ResponseEntity<User> updateUserController (@PathVariable(value = "userId") Long id, @RequestBody User user )
    {
        return userService.updateUser(id, user);
    }
    @DeleteMapping(value = "/users/{userId}")
    public void deleteUserController(@PathVariable Long id){
        userService.deleteUser(id);
    }
}

