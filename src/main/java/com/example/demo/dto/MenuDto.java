package com.example.demo.dto;

import lombok.Data;

@Data
public class MenuDto {
    private String description;
    private String foodName;
    private String categoryName;
    private Long price;
    private Long categoryId;
}
