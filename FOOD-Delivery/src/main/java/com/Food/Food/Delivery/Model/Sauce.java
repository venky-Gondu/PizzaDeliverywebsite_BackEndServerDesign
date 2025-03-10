package com.Food.Food.Delivery.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "SAUCE")
public class Sauce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sauceId;

    private String name;
    private int count;

    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ManyToMany(mappedBy = "sauces")
    private Set<Pizza> pizzas;

    // Getters and Setters
    public int getSauceId() { return sauceId; }
    public void setSauceId(int sauceId) { this.sauceId = sauceId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }
}
