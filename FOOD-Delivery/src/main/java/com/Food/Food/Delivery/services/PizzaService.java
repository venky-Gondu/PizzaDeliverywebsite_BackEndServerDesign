package com.Food.Food.Delivery.services;

import com.Food.Food.Delivery.dto.PizzaDTO;
import com.Food.Food.Delivery.Model.Pizza;
import com.Food.Food.Delivery.dto.PizzaIngredientResponse;
import com.Food.Food.Delivery.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PizzaService {

    @Autowired
    private IngredientService ingredientService;



    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private BaseRepository baseRepository;

    @Autowired
    private CheeseRepository cheeseRepository;

    @Autowired
    private VeggiesRepository veggiesRepository;

    @Autowired
    private SauceRepository sauceRepository;

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

    public boolean isAvailable(int pizzaId) {
        boolean allBasesAvailable = baseRepository.countUnavailableBases(pizzaId) == 0;
        boolean allCheesesAvailable = cheeseRepository.countUnavailableCheeses(pizzaId) == 0;
        boolean allVeggiesAvailable = veggiesRepository.countUnavailableVeggies(pizzaId) == 0;
        boolean allSaucesAvailable = sauceRepository.countUnavailableSauces(pizzaId) == 0;

        return allBasesAvailable && allCheesesAvailable && allVeggiesAvailable && allSaucesAvailable;
    }

    public ResponseEntity<String> order(int id) {
        if(isAvailable(id)){ // helps to check if all the ingredients all available or not
            // retrieve all the bases from the data bases if bases are available
            Set<Integer> bases=ingredientService.getIngredientIdsByPizzaId( id).getBaseIds();
            Set<Integer> cheeses=ingredientService.getIngredientIdsByPizzaId(id).getCheeseIds();
            Set<Integer> veggies=ingredientService.getIngredientIdsByPizzaId(id).getVeggieIds();
            Set<Integer> sauces=ingredientService.getIngredientIdsByPizzaId(id).getSauceIds();

            for(int i:bases){
                baseRepository.changeCount(i); // Decrease the count of bases;
            }
            for(int j:cheeses){
                cheeseRepository.changeCount(j); // Decrease the count of cheeses;
            }
            for(int k:veggies){
                veggiesRepository.changeCount(k); // Decrease the count of veggies;
            }
            for(int l:sauces){
                sauceRepository.changeCount(l); // Descrease the count of sauces;
            }

            // 201 Created - Best practice for resource creation
            return  ResponseEntity.ok("order placed");



        }
        return ResponseEntity.badRequest().body("Ingredients are not Available");
    }
}
