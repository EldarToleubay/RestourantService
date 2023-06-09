package com.example.demo.controller;

import com.example.demo.Dto.FoodsDto;
import com.example.demo.Dto.MenuDto;
import com.example.demo.model.Category;
import com.example.demo.model.Foods;
import com.example.demo.model.Menu;
import com.example.demo.model.Offers;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.MenuRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/menus")
@Slf4j
@Data
public class MenuController {
    private final MenuRepository repository;
    private final CategoryRepository categoryRepository;

    @GetMapping
    public List<Menu> getFood() {
        return repository.findAll();
    }


    @PostMapping
    public List<Menu> createFood() {
        List<Category> allCategories = categoryRepository.findAll();
        List<Menu> menuItems = new ArrayList<>();
        for (Category category : allCategories) {
            List<Foods> foods = category.getFoods();
            for (Foods food : foods) {
                Menu menu = new Menu();
                menu.setCategoryName(category.getName());
                menu.setFoodName(food.getName());
                menu.setPrice(food.getPrice());
                menu.setDescription(food.getDescription());
                menu.setCategory(category);
                menu = repository.save(menu);
                menuItems.add(menu);
            }
        }
        return menuItems;
    }
}
