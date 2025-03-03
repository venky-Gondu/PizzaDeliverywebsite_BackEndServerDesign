package com.Food.Food.Delivery.repo;

import com.Food.Food.Delivery.Model.Veggies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeggiesRepository extends JpaRepository<Veggies, Integer> {
}
