package com.example.demo.Dto;

import com.example.demo.model.Menu;
import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    private long menuId;
    private long amount;
    private long orderNumber;
}
