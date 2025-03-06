package com.Food.Food.Delivery.repo;

import com.Food.Food.Delivery.Model.Sauce;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SauceRepository extends JpaRepository<Sauce, Integer> {

    @Query("SELECT COUNT(s) FROM Pizza p JOIN p.sauces s WHERE p.pizzaId = :pizzaId AND s.count <= 0")
    long countUnavailableSauces(@Param("pizzaId") int pizzaId);


    @Modifying
    @Transactional
    @Query("UPDATE Sauce s SET s.count = CASE WHEN s.count > 0 THEN s.count - 1 ELSE 0 END WHERE s.id = :sauceId")
    void changeCount(@Param("sauceId") int sauceId);
}
