package com.Food.Food.Delivery.repo;

import com.Food.Food.Delivery.Model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
}
