package com.pluralsight.model;

import java.util.ArrayList;

public class Pizza {

    private String crust;
    private int quantity;
    private int size;
    private double price;
    private ArrayList<Pizza> pizzaArrayList;

    public Pizza(String crust, int quantity, int size, double price, ArrayList<Pizza> pizzaArrayList) {
        this.crust = crust;
        this.quantity = quantity;
        this.size = size;
        this.price = price;
        this.pizzaArrayList = pizzaArrayList;
    }

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<Pizza> getPizzaArrayList() {
        return pizzaArrayList;
    }

    public void setPizzaArrayList(ArrayList<Pizza> pizzaArrayList) {
        this.pizzaArrayList = pizzaArrayList;
    }


}
