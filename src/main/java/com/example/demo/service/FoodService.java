package com.example.demo.service;

import com.example.demo.dto.FoodsDto;
import com.example.demo.model.Foods;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface FoodService {
    Foods createFood(@RequestBody FoodsDto foodsDto);

    List<Foods> foods();

}
