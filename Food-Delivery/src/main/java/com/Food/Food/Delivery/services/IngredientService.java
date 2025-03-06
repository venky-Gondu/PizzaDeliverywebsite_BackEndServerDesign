package com.Food.Food.Delivery.services;

import com.Food.Food.Delivery.dto.PizzaIngredientResponse;
import com.Food.Food.Delivery.repo.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class IngredientService {

    @Autowired
    private BaseRepository baseRepository;

    @Autowired
    private CheeseRepository cheeseRepository;

    @Autowired
    private VeggiesRepository veggiesRepository;

    @Autowired
    private SauceRepository sauceRepository;

    @Transactional
    public void reduceIngredientCount(int baseId, int cheeseId, int veggiesId, int sauceId) {
        // helps to decease the count of Ingredient  with the help of ID;
        baseRepository.changeCount(baseId);
        cheeseRepository.changeCount(cheeseId);
        veggiesRepository.changeCount(veggiesId);
        sauceRepository.changeCount(sauceId);
    }

    @Autowired
    private PizzaRepository pizzaRepository;
    // helps to retrieve the ingredients Id from the join tables;
    public PizzaIngredientResponse getIngredientIdsByPizzaId(int pizzaId) {
        Set<Integer> baseIds = pizzaRepository.findBaseIdsByPizzaId(pizzaId);
        Set<Integer> cheeseIds = pizzaRepository.findCheeseIdsByPizzaId(pizzaId);
        Set<Integer> veggieIds = pizzaRepository.findVeggieIdsByPizzaId(pizzaId);
        Set<Integer> sauceIds = pizzaRepository.findSauceIdsByPizzaId(pizzaId);

        return new PizzaIngredientResponse(baseIds, cheeseIds, veggieIds, sauceIds);
    }

}

