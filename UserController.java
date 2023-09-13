package com.boot.kiendemo.UserController;

import com.boot.kiendemo.User.User;
import com.boot.kiendemo.UserService.UserService;

import java.util.List;
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
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/products")
    public List<User> findAllUsers (){
        return userService.findAllUser();
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<User> get_user_by_id (@PathVariable Long id){
        return userService.getUserById(id);
    }
    @PostMapping("/product")
    public ResponseEntity<User> save_user (@RequestBody User user){
        return userService.saveUser(user);
    }
    @PutMapping(path = "products/{userId}")
    public ResponseEntity<User> update_user (@PathVariable(value = "userId") Long id, @RequestBody User user )
    {
        return userService.updateUser(id, user);
    }
    @DeleteMapping(value = "/products/{userId}")
    public void delete_user(@PathVariable Long id){
        userService.deleteUser(id);
    }
}

