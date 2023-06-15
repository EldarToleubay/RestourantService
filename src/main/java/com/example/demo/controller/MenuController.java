package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Foods;
import com.example.demo.model.Menu;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.MenuRepository;
import com.example.demo.service.MenuService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/menus")
@Slf4j
@Data
public class MenuController {
    private final MenuRepository repository;
    private final CategoryRepository categoryRepository;
    private final MenuService menuService;

    @GetMapping
    public List<Menu> getMenu() {
        return menuService.getMenu();
    }


    @PostMapping
    public List<Menu> refreshMenu() {
        return menuService.refreshMenu();
    }
}
