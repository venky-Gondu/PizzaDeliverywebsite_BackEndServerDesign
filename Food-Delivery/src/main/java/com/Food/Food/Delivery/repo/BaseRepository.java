package com.Food.Food.Delivery.repo;

import com.Food.Food.Delivery.Model.Base;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository extends JpaRepository<Base, Integer> {


    @Query("SELECT COUNT(b) FROM Pizza p JOIN p.bases b WHERE p.pizzaId = :pizzaId AND b.count <= 0")
    long countUnavailableBases(@Param("pizzaId") int pizzaId);
    @Modifying
    @Transactional
    @Query("UPDATE Base b SET b.count = CASE WHEN b.count > 0 THEN b.count - 1 ELSE 0 END WHERE b.id = :baseId")
    void changeCount(@Param("baseId") int baseId);

}


