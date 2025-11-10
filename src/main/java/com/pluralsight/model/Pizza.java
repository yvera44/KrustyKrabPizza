package com.pluralsight.model;

import java.util.List;

public class Pizza extends MenuItem {

    private String crust;
    private int size;
    private List<Topping> toppings;

    public Pizza(double price, int quantity, String description, String crust, int size, List<Topping> toppings) {
        super(price, quantity, description);
        this.crust = crust;
        this.size = size;
        this.toppings = toppings;

    }

}
