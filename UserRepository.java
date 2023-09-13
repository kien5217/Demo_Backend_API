package com.boot.kiendemo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.kiendemo.User.User;

public interface UserRepository extends JpaRepository<User,Long> {
    
}
