package com.pluralsight.model;

import java.util.ArrayList;

public class Order {

    private String customerName;
    private double totalPrice;

    private ArrayList<Pizza> orderItems;

    public Order(String customerName, double totalPrice) {
        this.customerName = customerName;
        this.totalPrice = totalPrice;
        this.orderItems = new ArrayList<>();

    }
    public void addOrderItems() {

    }

}
