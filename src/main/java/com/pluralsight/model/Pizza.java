package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends MenuItem {

    private String crust;
    private int size;
    private List<Topping> toppings;

    public Pizza(String crust,int size) {
        super(0.0, 0, "Pizza");
        this.crust = crust;
        this.size = size;
        this.toppings = new ArrayList<>();

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

    public void addTopping(Topping selectedTopping) {

    }
}
