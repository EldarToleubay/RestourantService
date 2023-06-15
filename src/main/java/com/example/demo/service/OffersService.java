package com.example.demo.service;

import com.example.demo.dto.OrderDto;
import com.example.demo.model.Offers;

import java.util.List;

public interface OffersService {
    List<Offers> offers();
    List<Offers> createOffers(List<OrderDto> orderDtoList);
}
