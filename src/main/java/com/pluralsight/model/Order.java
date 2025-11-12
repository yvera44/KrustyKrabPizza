package com.pluralsight.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private String customerName;
    private LocalDateTime orderTime;
    private List<String> pizzas;
    private List<String> drinks;
    private List<String> garlicKnots;
    private double totalPrice;

    public Order() {
        this.customerName = "";
        this.orderTime = LocalDateTime.now();
        this.pizzas = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.garlicKnots = new ArrayList<>();
        this.totalPrice = 0.00;
    }

}
