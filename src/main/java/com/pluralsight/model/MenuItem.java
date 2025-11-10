package com.pluralsight.model;

public abstract class MenuItem {

    private String description;
    private double price;
    private int quantity;

    public MenuItem(double price, int quantity, String description) {
        this.price = price;
        this.quantity = quantity;
    }




    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }



}
