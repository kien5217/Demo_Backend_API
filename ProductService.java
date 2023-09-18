package com.boot.kiendemo.UserService;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.boot.kiendemo.ProductRepository;
import com.boot.kiendemo.object.Product;
public class ProductService {
    private ProductRepository productRepository ;
    public ProductService (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    // Get all
    public List<Product> findAllProduct(){
        return productRepository.findAll();
    }
    List<Product> all = findAllProduct();
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
        if(id == null){
            System.out.println("Id cannot be null");
        }
        Product existingProduct ;
        for(Product pr : all){
            Long it = pr.getId();
            if(it == id ) {
                pr.setName(updatedProduct.getName());
                pr.setCost(updatedProduct.getCost());
                existingProduct = pr;
            }
        }
        existingProduct = updatedProduct;
        Product savedEntity
        = productRepository.save(existingProduct);
        return ResponseEntity.ok(savedEntity);
    }
    // delete product
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
