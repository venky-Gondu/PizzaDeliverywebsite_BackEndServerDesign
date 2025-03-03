package com.Food.Food.Delivery.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "BASE")
public class Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int baseId;

    private String name;
    private int count;

    private BigDecimal price;

    @ManyToMany(mappedBy = "bases")
    private Set<Pizza> pizzas;

    // Getters and Setters
    public int getBaseId() { return baseId; }
    public void setBaseId(int baseId) { this.baseId = baseId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
