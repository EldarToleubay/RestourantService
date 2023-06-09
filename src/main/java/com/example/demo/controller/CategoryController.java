package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Foods;
import com.example.demo.model.Offers;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.FoodRepository;
import com.example.demo.repository.OffersRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@Slf4j
@Data
public class CategoryController {


    private final FoodRepository foodRepository;
    private final CategoryRepository repository;


    @GetMapping
    public List<Category> categories(){
        System.out.println(repository.findAll());
        return repository.findAll();
    }

    @PostMapping
    public Category createCategories(@RequestBody Category category){
        category = repository.save(category);
        return category;
    }


}
