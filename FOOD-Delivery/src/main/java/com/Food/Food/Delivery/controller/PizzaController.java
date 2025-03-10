package com.Food.Food.Delivery.controller;

import com.Food.Food.Delivery.dto.PizzaDTO;
import com.Food.Food.Delivery.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;


    // Returns list of pizzas in DB;
    @GetMapping("/pizzas")
    public List<PizzaDTO> getAllPizzas() {
        return pizzaService.getAllPizzas();
    }
    // checking Availability of pizza
    @GetMapping("/pizzas/isAvailable/{id}")
    public boolean isAvailable(@PathVariable int id){
        return pizzaService.isAvailable(id);
    }
    // order placing End point
    @GetMapping("/pizza/order/{id}")
    public ResponseEntity<String> order(@PathVariable int id){
            return pizzaService.order(id);
    }
}
