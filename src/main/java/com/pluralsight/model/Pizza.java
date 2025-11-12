package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends MenuItem {

    private String crust;
    private int size;
    private List<Topping> toppings;

    public Pizza() {
        super(0.0, 0, "Pizza");
        this.crust = "";
        this.size = 0;
        this.toppings = new ArrayList<>();

    }

}
