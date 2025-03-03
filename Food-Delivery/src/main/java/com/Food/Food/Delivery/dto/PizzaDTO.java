package com.Food.Food.Delivery.dto;

public class PizzaDTO {

    private int pizzaId;
    private String name;
    private String description;
    private String category;
    private String imageBase64;

    public PizzaDTO() {}

    public PizzaDTO(int pizzaId, String name, String description, String category, String imageBase64) {
        this.pizzaId = pizzaId;
        this.name = name;
        this.description = description;
        this.category = category;
        this.imageBase64 = imageBase64;
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

    public String getImageBase64() { return imageBase64; }
    public void setImageBase64(String imageBase64) { this.imageBase64 = imageBase64; }
}
