package com.example.demo.controller;

import com.example.demo.Dto.OrderDto;
import com.example.demo.model.Menu;
import com.example.demo.model.Offers;
import com.example.demo.model.common.Status;
import com.example.demo.repository.MenuRepository;
import com.example.demo.repository.OffersRepository;
import jakarta.persistence.criteria.Order;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/offers")
@Slf4j
@Data
public class OffersController {
    private final MenuRepository menuRepository;


    private final OffersRepository repository;

    @GetMapping
    public List<Offers> offers() {
        return repository.findAll();
    }

    @PostMapping
    public List<Offers> offers(@RequestBody List<OrderDto> orderDtoList) {
        List<Offers> newOffers = new ArrayList<>();
        for (OrderDto orderDto : orderDtoList) {
            Optional<Menu> menu = menuRepository.findById(orderDto.getMenuId());
            log.info(String.valueOf(orderDto.getMenuId()));
            Offers offers = new Offers();
            if (menu.isPresent()) {
                offers.setName(menu.get().getFoodName());
                offers.setMenu(menu.get());
                offers.setStatus(Status.WAITING);
                offers.setOrderNumber(orderDto.getOrderNumber());
            }
            offers.setAmount(orderDto.getAmount());
            newOffers.add(offers);
        }
        return repository.saveAll(newOffers);
    }
}
