package com.pluralsight.model;

public class Drink extends MenuItem {

    private String size;

    public Drink(double price, int quantity, String description, String size) {
        super(price, quantity, description);
        this.size = size;
    }
}




