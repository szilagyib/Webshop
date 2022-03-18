package com.example.webshop.controller;

import com.example.webshop.entity.Product;
import com.example.webshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    // Create operation
    @PostMapping("/products")
    public Product createProduct(@Valid @RequestBody Product product) {
        return productService.createProduct(product);
    }

    // Read operations
    @GetMapping("/products/{id}")
    public Product fetchProduct(@PathVariable("id") Long id) {
        return productService.fetchProduct(id);
    }

    @GetMapping("/products")
    public List<Product> fetchProductList() {
        return productService.fetchProductList();
    }

    // Update operation
    @PutMapping("/products/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable("id") Long id) {
        return productService.updateProduct(product, id);
    }

    // Delete operation
    @DeleteMapping("/products/{id}")
    public void deleteProductById(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
    }
}
