package com.boot.kiendemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.boot.kiendemo.object.User;
import com.boot.kiendemo.repository.UserRepository;

@Component
public class DatabaseLoader implements CommandLineRunner{
    private UserRepository userRepository;
    @Autowired
    public DatabaseLoader(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public void run(String... strings) throws Exception {
        this.userRepository.save(new User((long) 118234, "kien", "kien@gmail.com"));
    }

}