package com.pluralsight.model;

import java.util.ArrayList;
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

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }
}
