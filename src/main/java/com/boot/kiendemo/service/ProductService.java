package com.boot.kiendemo.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.boot.kiendemo.object.Product;
import com.boot.kiendemo.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;
@Service("productService")
public class ProductService {
    private ProductRepository productRepository ;
    public ProductService (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    // Get all
    public List<Product> getAllProducts(Integer offset, Integer limit, String sortBy)
    {
        Pageable paging = PageRequest.of(offset, limit, Sort.by(sortBy));
 
        Page<Product> pagedResult = productRepository.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Product>();
        }
    }
    
    // Get one product based on id
    public ResponseEntity<Product> getProductById (Long id) {
        Optional<Product> product = productRepository.findById(id);
 
    if(product.isPresent()) {
        return ResponseEntity.ok().body(product.get());
    } else {
        return ResponseEntity.notFound().build();
    }
    
}
    //save product
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product newProduct = productRepository.save(product);
        return ResponseEntity.ok(newProduct);
    }
    // update new product
    
    public ResponseEntity<Product> updateProduct(Long id,Product updatedProduct){
        if (id == null) {
        throw new IllegalArgumentException(
            "ID cannot be null");
    }
    Product Existingproduct
        = productRepository.findById(id).orElseThrow(
            ()
                -> new EntityNotFoundException(
                    String.valueOf(id)));
    Existingproduct.setName(updatedProduct.getName());
    Existingproduct.setCost(updatedProduct.getCost());
    Product savedEntity
        = productRepository.save(Existingproduct);
    return ResponseEntity.ok(savedEntity);
    }
    // delete product
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
