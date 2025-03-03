package com.Food.Food.Delivery.repo;

import com.Food.Food.Delivery.Model.Sauce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SauceRepository extends JpaRepository<Sauce, Integer> {

    @Query("SELECT CASE WHEN (s.count > 0) THEN true ELSE false END FROM Sauce s WHERE s.sauceId = :id")
    boolean isSauceAvailable(@Param("id") Integer id);
}
