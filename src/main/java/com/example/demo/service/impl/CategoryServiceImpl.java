package com.example.demo.service.impl;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public List<Category> categories() {
        System.out.println(categoryRepository.findAll());
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategories(Category category) {
        category = categoryRepository.save(category);
        return category;
    }
}
