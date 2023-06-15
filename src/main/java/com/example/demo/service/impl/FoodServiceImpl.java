package com.example.demo.service.impl;

import com.example.demo.dto.FoodsDto;
import com.example.demo.model.Foods;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.FoodRepository;
import com.example.demo.service.FoodService;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@Data
public class FoodServiceImpl implements FoodService {

    private final FoodRepository repository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<Foods> foods(){
        System.out.println(repository.findAll());
        return repository.findAll();
    }

    @Override
    public Foods createFood(FoodsDto foodsDto){
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
