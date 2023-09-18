package com.boot.kiendemo.UserController;
import com.boot.kiendemo.UserService.ProductService;
import com.boot.kiendemo.object.Product;

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
@RequestMapping("/api/k2")
public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/products")
    public List<Product> findAllProducts (){
        return productService.findAllProduct();
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductByIdController (Long id){
        return productService.getProductById(id);
    }
    @PostMapping(value = "/product")
    public ResponseEntity<Product> saveProductController(@RequestBody Product product){
        return productService.saveProduct(product);
    }
    @PutMapping(path = "/products{productId}")
    public ResponseEntity<Product> updateProductController(@PathVariable(value = "productId") Long id, @RequestBody Product product){
        return productService.updateProduct(id,product);
    }
    @DeleteMapping(value = "/products/{productId}")
    public void deleteProductController(@PathVariable Long id){
        productService.deleteProduct(id);
    }

}
