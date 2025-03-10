package com.Food.Food.Delivery.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "CHEESE")
public class Cheese {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cheeseId;

    private String name;
    private int count;// Assuming quantity is stored

    private BigDecimal price;



    @ManyToMany(mappedBy = "cheeses")
    private Set<Pizza> pizzas;

    // Getters and Setters
    public int getCheeseId() { return cheeseId; }
    public void setCheeseId(int cheeseId) { this.cheeseId = cheeseId; }

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
