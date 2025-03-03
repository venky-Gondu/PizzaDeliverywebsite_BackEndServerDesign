package com.Food.Food.Delivery.repo;

import com.Food.Food.Delivery.Model.Cheese;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheeseRepository extends JpaRepository<Cheese, Integer> {
}
