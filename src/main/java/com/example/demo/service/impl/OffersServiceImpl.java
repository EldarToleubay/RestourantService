package com.example.demo.service.impl;

import com.example.demo.dto.OrderDto;
import com.example.demo.model.Menu;
import com.example.demo.model.Offers;
import com.example.demo.model.common.Status;
import com.example.demo.repository.MenuRepository;
import com.example.demo.repository.OffersRepository;
import com.example.demo.service.OffersService;
import lombok.Data;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class OffersServiceImpl implements OffersService {

    private final MenuRepository menuRepository;


    private final OffersRepository repository;

    @Override
    public List<Offers> offers() {
        return repository.findAll();
    }

    @Override
    public List<Offers> createOffers(List<OrderDto> orderDtoList) {
        List<Offers> newOffers = new ArrayList<>();
        for (OrderDto orderDto : orderDtoList) {
            Optional<Menu> menu = menuRepository.findById(orderDto.getMenuId());
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
