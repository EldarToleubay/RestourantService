package com.example.demo.service;

import com.example.demo.model.Category;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CategoryService {
    List<Category> categories();

    Category createCategories(Category category);
}
