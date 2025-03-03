package com.Food.Food.Delivery.controller;

import com.Food.Food.Delivery.dto.PizzaDTO;
import com.Food.Food.Delivery.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping
    public List<PizzaDTO> getAllPizzas() {
        return pizzaService.getAllPizzas();
    }
}
