package com.example.demo.controller;

import com.example.demo.dto.FoodsDto;
import com.example.demo.model.Foods;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.FoodRepository;
import com.example.demo.service.FoodService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
@Slf4j
@Data
public class FoodController {

    private final FoodRepository repository;
    private final CategoryRepository categoryRepository;
    private final FoodService foodService;

    @GetMapping
    public List<Foods> foods(){
        return foodService.foods();
    }

    @PostMapping
    public Foods createFood(@RequestBody FoodsDto foodsDto){
        return foodService.createFood(foodsDto);
    }


}
