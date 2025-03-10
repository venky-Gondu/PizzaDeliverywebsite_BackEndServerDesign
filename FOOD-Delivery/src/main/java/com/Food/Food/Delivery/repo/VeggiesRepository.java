package com.Food.Food.Delivery.repo;

import com.Food.Food.Delivery.Model.Veggies;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VeggiesRepository extends JpaRepository<Veggies, Integer> {
    @Query("SELECT COUNT(v) FROM Pizza p JOIN p.veggies v WHERE p.pizzaId = :pizzaId AND v.count <= 0")
    long countUnavailableVeggies(@Param("pizzaId") int pizzaId);

    @Modifying
    @Transactional
    @Query("UPDATE Veggies v SET v.count = CASE WHEN v.count > 0 THEN v.count - 1 ELSE 0 END WHERE v.id = :veggiesId")
    void changeCount(@Param("veggiesId") int veggiesId);

}
