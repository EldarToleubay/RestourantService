package com.example.demo.dto;

import lombok.Data;

@Data
public class OrderDto {
    private long menuId;
    private long amount;
    private long orderNumber;
}
