package com.Food.Food.Delivery.repo;

import com.Food.Food.Delivery.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
    @Query(value = "SELECT base_id FROM pizza_bases WHERE pizza_id = :pizzaId", nativeQuery = true)
    Set<Integer> findBaseIdsByPizzaId(@Param("pizzaId") int pizzaId);

    @Query(value = "SELECT cheese_id FROM pizza_cheese WHERE pizza_id = :pizzaId", nativeQuery = true)
    Set<Integer> findCheeseIdsByPizzaId(@Param("pizzaId") int pizzaId);

    @Query(value = "SELECT veggies_id FROM pizza_veggies WHERE pizza_id = :pizzaId", nativeQuery = true)
    Set<Integer> findVeggieIdsByPizzaId(@Param("pizzaId") int pizzaId);

    @Query(value = "SELECT sauce_id FROM pizza_sauces WHERE pizza_id = :pizzaId", nativeQuery = true)
    Set<Integer> findSauceIdsByPizzaId(@Param("pizzaId") int pizzaId);

}
