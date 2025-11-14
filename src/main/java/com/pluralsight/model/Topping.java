package com.pluralsight.model;

public class Topping {

    private String toppingName;
    private String toppingType;
    private boolean isExtra;
    private double basePrice;

    public Topping(String toppingName, String toppingType, boolean isExtra, double basePrice) {
        this.toppingName = toppingName;
        this.toppingType = toppingType;
        this.isExtra = isExtra;
        this.basePrice = basePrice;
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

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getToppingSizeMultiplier (int size) {

        switch (size) {
            case 8:
                return 1.00;
            case 12:
                return 2.00;
            case 16:
                return 3.00;
            default:
                return 0.00;
        }
    }
    public double calculateFinalToppingPrice (int size){
        return basePrice * getToppingSizeMultiplier(size);

    }
}