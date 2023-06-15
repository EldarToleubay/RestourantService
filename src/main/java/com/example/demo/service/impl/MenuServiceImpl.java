package com.example.demo.service.impl;

import com.example.demo.model.Category;
import com.example.demo.model.Foods;
import com.example.demo.model.Menu;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.MenuRepository;
import com.example.demo.service.MenuService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class MenuServiceImpl implements MenuService {
    private final CategoryRepository categoryRepository;
    private final MenuRepository menuRepository;

    @Override
    public List<Menu> getMenu() {
        return menuRepository.findAll();
    }

    @Override
    public List<Menu> refreshMenu() {
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
                menu = menuRepository.save(menu);
                menuItems.add(menu);
            }
        }
        return menuItems;
    }
}
