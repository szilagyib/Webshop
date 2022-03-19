package com.example.webshop.controller;

import com.example.webshop.entity.Category;
import com.example.webshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Create operation
    @PostMapping("/categories")
    public Category createCategory(@Valid @RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    // Read operations
    @GetMapping("/categories/{id}")
    public Category fetchCategory(@PathVariable("id") Long id) {
        return categoryService.fetchCategory(id);
    }

    @GetMapping("/categories")
    public List<Category> fetchCategoryList() {
        return categoryService.fetchCategoryList();
    }

    // Update operation
    @PutMapping("/categories/{id}")
    public Category updateCategory(@RequestBody Category category, @PathVariable("id") Long id) {
        return categoryService.updateCategory(category, id);
    }

    // Delete operation
    @DeleteMapping("/categories/{id}")
    public void deleteCategoryById(@PathVariable("id") Long id) {
        categoryService.deleteCategoryById(id);
    }
}
