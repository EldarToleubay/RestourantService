package com.example.demo.controller;

import com.example.demo.Dto.FoodsDto;
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
@RequestMapping("/foods")
@Slf4j
@Data
public class FoodController {

    private final FoodRepository repository;
    private final CategoryRepository categoryRepository;


    @GetMapping
    public List<Foods> foods(){
        System.out.println(repository.findAll());
        return repository.findAll();
    }

    @PostMapping
    public Foods createFood(@RequestBody FoodsDto foodsDto){
        Foods foods = new Foods();
        System.out.println(foodsDto);
        foods.setPrice(foodsDto.getPrice());
        foods.setDescription(foodsDto.getDescription());
        foods.setName(foodsDto.getName());
        foods.setCategory(categoryRepository.findById(foodsDto.getCategoryId()).get());
        foods = repository.save(foods);
        return foods;
    }


}
