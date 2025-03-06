package com.Food.Food.Delivery.dto;

import java.util.Set;

public class PizzaIngredientResponse {
    private final Set<Integer> baseIds;
    private final Set<Integer> cheeseIds;
    private final Set<Integer> veggieIds;
    private final Set<Integer> sauceIds;

    public PizzaIngredientResponse(Set<Integer> baseIds, Set<Integer> cheeseIds, Set<Integer> sauceIds, Set<Integer> veggieIds) {
        this.baseIds = baseIds;
        this.cheeseIds = cheeseIds;
        this.sauceIds = sauceIds;
        this.veggieIds = veggieIds;
    }
    public Set<Integer> getBaseIds() { return baseIds; }
    public Set<Integer> getCheeseIds() { return cheeseIds; }
    public Set<Integer> getVeggieIds() { return veggieIds; }
    public Set<Integer> getSauceIds() { return sauceIds; }


}
