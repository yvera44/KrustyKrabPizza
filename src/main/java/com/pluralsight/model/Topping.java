package com.pluralsight.model;

public class Topping {

    private String toppingName;
    private String toppingType;
    private boolean isExtra;
    private double price;


    public Topping(String toppingName, String toppingType, boolean isExtra, double price) {
        this.toppingName = toppingName;
        this.toppingType = toppingType;
        this.isExtra = isExtra;
        this.price = price;
    }

    public String getToppingName() {
        return toppingName;
    }

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }

    public String getToppingType() {
        return toppingType;
    }

    public void setToppingType(String toppingType) {
        this.toppingType = toppingType;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}