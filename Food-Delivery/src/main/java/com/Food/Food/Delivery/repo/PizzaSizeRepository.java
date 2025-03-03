package com.Food.Food.Delivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Food.Food.Delivery.Model.PizzaSize;
import java.util.List;

@Repository
public interface PizzaSizeRepository extends JpaRepository<PizzaSize, Integer> {

    // Find all sizes and prices for a given pizza ID
    List<PizzaSize> findByPizzaPizzaId(int pizzaId);

    // Find a specific pizza size price
    PizzaSize findByPizzaPizzaIdAndSize(int pizzaId, PizzaSize.Size size);
}
