package com.example.webshop.service;

import com.example.webshop.entity.Category;
import com.example.webshop.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    // Create operation
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Read operations
    public Category fetchCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No category with id " + id));
    }

    public List<Category> fetchCategoryList() {
        return (List<Category>) categoryRepository.findAll();
    }

    // Update operation
    public Category updateCategory(Category category, Long id) {
        Category c = categoryRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No category with id " + id));
        c.setName(category.getName());

        return categoryRepository.save(c);
    }

    // Delete operation
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
}
