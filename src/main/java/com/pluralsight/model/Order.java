package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String customerName;
    private List<String> sandwiches;
    private List<String> drinks;
    private List<String> chips;
    private double totalPrice;

    public Order(String customerName, List<String> sandwiches, List<String> drinks, List<String> chips, double totalPrice) {
        this.customerName = customerName;
        this.sandwiches = sandwiches;
        this.drinks = drinks;
        this.chips = chips;
        this.totalPrice = 0.0;
    }

}
