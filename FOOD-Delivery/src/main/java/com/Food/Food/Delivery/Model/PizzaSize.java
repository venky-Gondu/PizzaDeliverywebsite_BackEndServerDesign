package com.Food.Food.Delivery.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "PIZZA_SIZE")
public class PizzaSize {

    public enum Size { SMALL, MEDIUM, LARGE }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pizzaSizeId;

    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;

    @Enumerated(EnumType.STRING)
    private Size size;

    private BigDecimal price;

    // Getters and Setters

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public int getPizzaSizeId() {
        return pizzaSizeId;
    }

    public void setPizzaSizeId(int pizzaSizeId) {
        this.pizzaSizeId = pizzaSizeId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}

