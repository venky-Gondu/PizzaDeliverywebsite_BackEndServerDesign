package com.Food.Food.Delivery.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "VEGGIES")
public class Veggies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int veggiesId;

    private String name;
    private int count;

    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ManyToMany(mappedBy = "veggies")
    private Set<Pizza> pizzas;

    // Getters and Setters
    public int getVeggiesId() { return veggiesId; }
    public void setVeggiesId(int veggiesId) { this.veggiesId = veggiesId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }
}
