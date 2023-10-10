package com.boot.kiendemo.object;


import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Setter
@Getter
@Data

@Entity
@Table(name ="Product")
public class Product {
   @Id // this is the primary key
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String name;
   private double cost;
   public Product(Long id, String name, float cost) {
      this.id = id;
      this.name = name;
      this.cost = cost;
   }
   @ManyToOne
   @JoinColumn(name="userId", nullable=false) 
    private User user;
   
}

