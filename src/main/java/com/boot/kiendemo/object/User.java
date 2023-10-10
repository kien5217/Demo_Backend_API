package com.boot.kiendemo.object;
import java.util.Set;

import org.springframework.data.annotation.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
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
@Table(name = "User")
public class User {
   @Id // this is the primary key
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String name;
   private String email;
   public User(Long id, String name, String email) {
      this.id = id;
      this.name = name;
      this.email = email;
   }
   @OneToMany(mappedBy = "user")
   private Set<Product> products;
   public Set<Product> getProducts () {
      return products ;
    }
}
