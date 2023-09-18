package com.boot.kiendemo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.kiendemo.object.Product;
public interface ProductRepository extends JpaRepository<Product,Long> {
    
}
