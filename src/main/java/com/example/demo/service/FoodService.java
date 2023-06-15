package com.example.demo.service;

import com.example.demo.dto.FoodsDto;
import com.example.demo.model.Foods;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface FoodService {
    Foods createFood(@RequestBody FoodsDto foodsDto);

    List<Foods> foods();

}
