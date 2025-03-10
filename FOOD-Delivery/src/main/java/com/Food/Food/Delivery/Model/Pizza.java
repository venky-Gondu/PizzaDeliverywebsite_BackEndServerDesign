package com.Food.Food.Delivery.Model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "PIZZA")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pizzaId;

    private String name;
    private String description;
    private String category;
    //private BigDecimal price;
    @Lob
    @Column(name = "image")
    private byte[] image;

    @ManyToMany
    @JoinTable(
            name = "pizza_cheese",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "cheese_id")
    )
    private Set<Cheese> cheeses;

    @ManyToMany
    @JoinTable(
            name = "pizza_bases",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "base_id")
    )
    private Set<Base> bases;

    @ManyToMany
    @JoinTable(
            name = "pizza_veggies",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "veggies_id")
    )
    private Set<Veggies> veggies;

    @ManyToMany
    @JoinTable(
            name = "pizza_sauces",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "sauce_id")
    )
    private Set<Sauce> sauces;

    @OneToMany(mappedBy = "pizza", cascade = CascadeType.ALL)
    private Set<PizzaSize> sizes;

    public Set<PizzaSize> getSizes() {
        return sizes;
    }

    public void setSizes(Set<PizzaSize> sizes) {
        this.sizes = sizes;
    }

    // Getters and Setters
    public int getPizzaId() { return pizzaId; }
    public void setPizzaId(int pizzaId) { this.pizzaId = pizzaId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

//    public BigDecimal getPrice() { return price; }
//    public void setPrice(BigDecimal price) { this.price = price; }


    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
