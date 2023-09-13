package com.boot.kiendemo.User;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import org.springframework.data.annotation.Id;


import jakarta.persistence.Entity;

@Entity
public class User {
   @Id // this is the primary key
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private String email;
   public Long getId(){
    return id;
   }
   public String getName() {
    return name;
   }
   public String getEmail() {
    return email;
   }
   public void setId(Long id){
    this.id = id;
   }
   public void setName(String name){
    this.name = name;
   }
   public void setEmail(String email){
    this.email =email;
   }
   public User(Long id,String name,String email){
    setId(id);
    setEmail(email);
    setName(name);
   }
}
