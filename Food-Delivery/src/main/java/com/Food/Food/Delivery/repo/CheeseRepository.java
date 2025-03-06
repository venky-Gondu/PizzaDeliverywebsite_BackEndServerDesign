package com.Food.Food.Delivery.repo;

import com.Food.Food.Delivery.Model.Cheese;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CheeseRepository extends JpaRepository<Cheese, Integer> {
    @Query("SELECT COUNT(c) FROM Pizza p JOIN p.cheeses c WHERE p.pizzaId = :pizzaId AND c.count <= 0")
    long countUnavailableCheeses(@Param("pizzaId") int pizzaId);

    @Modifying
    @Transactional
    @Query("UPDATE Cheese c SET c.count = CASE WHEN c.count > 0 THEN c.count - 1 ELSE 0 END WHERE c.id = :cheeseId")
    void changeCount(@Param("cheeseId") int cheeseId);
}
