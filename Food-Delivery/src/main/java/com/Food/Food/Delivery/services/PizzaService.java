package com.Food.Food.Delivery.services;

import com.Food.Food.Delivery.dto.PizzaDTO;
import com.Food.Food.Delivery.Model.Pizza;
import com.Food.Food.Delivery.repo.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public List<PizzaDTO> getAllPizzas() {
        List<Pizza> pizzas = pizzaRepository.findAll();

        return pizzas.stream()
                .map(pizza -> new PizzaDTO(
                        pizza.getPizzaId(),
                        pizza.getName(),
                        pizza.getDescription(),
                        pizza.getCategory(),
                        pizza.getImage() != null ? Base64.getEncoder().encodeToString(pizza.getImage()) : null
                ))
                .collect(Collectors.toList());
    }
}
