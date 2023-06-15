package com.example.demo.controller;

import com.example.demo.dto.OrderDto;
import com.example.demo.model.Menu;
import com.example.demo.model.Offers;
import com.example.demo.model.common.Status;
import com.example.demo.repository.MenuRepository;
import com.example.demo.repository.OffersRepository;
import com.example.demo.service.OffersService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/offers")
@Slf4j
@Data
public class OffersController {
    private final MenuRepository menuRepository;


    private final OffersRepository repository;
    private final OffersService offersService;

    @GetMapping
    public List<Offers> offers() {
        return offersService.offers();
    }

    @PostMapping
    public List<Offers> offers(@RequestBody List<OrderDto> orderDtoList) {
        return offersService.createOffers(orderDtoList);
    }
}
