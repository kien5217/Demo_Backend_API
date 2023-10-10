package com.boot.kiendemo.controller;
import com.boot.kiendemo.service.ProductService;
import com.boot.kiendemo.object.Product;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/k2")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProductsController(
                      @RequestParam(defaultValue = "0") Integer offset, 
                      @RequestParam(defaultValue = "20") Integer limit,
                      @RequestParam(defaultValue = "id") String sortBy) 
  {
      List<Product> list = productService.getAllProducts(offset, limit, sortBy);

      return new ResponseEntity<List<Product>>(list, new HttpHeaders(), HttpStatus.OK); 
  }
    
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductByIdController (Long id){
        return productService.getProductById(id);
    }
    @PostMapping(value = "/product")
    public ResponseEntity<Product> saveProductController(@RequestBody Product product){
        return productService.saveProduct(product);
    }
    @PutMapping(path = "/products/{productId}")
    public ResponseEntity<Product> updateProductController(@PathVariable(value = "productId") Long id, @RequestBody Product product){
        return productService.updateProduct(id,product);
    }
    @DeleteMapping(value = "/products/{productId}")
    public void deleteProductController(@PathVariable Long id){
        productService.deleteProduct(id);
    }

}
