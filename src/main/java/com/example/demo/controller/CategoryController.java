package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.FoodRepository;
import com.example.demo.service.CategoryService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@Slf4j
@Data
public class CategoryController {


    private final FoodRepository foodRepository;
    private final CategoryRepository repository;
    private final CategoryService categoryService;


    @GetMapping
    public List<Category> categories(){
        return categoryService.categories();
    }

    @PostMapping
    public Category createCategories(@RequestBody Category category){
        return categoryService.createCategories(category);
    }


}
