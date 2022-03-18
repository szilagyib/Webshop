package com.example.webshop.service;

import com.example.webshop.entity.Product;
import com.example.webshop.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private IProductRepository productRepository;

    // Create operation
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // Read operations
    public Product fetchProduct(Long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No product with id " + id));
    }

    public List<Product> fetchProductList() {
        return (List<Product>) productRepository.findAll();
    }

    // Update operation
    public Product updateProduct(Product product, Long id) {
        Product p = productRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No product with id " + id));
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        p.setCategory(product.getCategory());
        p.setDescription(product.getDescription());

        return productRepository.save(p);
    }

    // Delete operation
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
