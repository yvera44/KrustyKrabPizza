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

    public double calculatePrice(){
        double basePrice = 0.00;

        switch (size) {
            case 8:
                basePrice = 8.50;
                break;
            case 12:
                basePrice = 12.00;
                break;
            case 16:
                basePrice = 16.50;
                break;
        }
        for (Topping topping : toppings) {
            basePrice += topping.calculateFinalToppingPrice(size);
            if (topping.isExtra()) {
                basePrice += topping.calculateFinalToppingPrice(size);
            }
        }

        return basePrice;
    }
    @Override
    public double getPrice(){
        return calculatePrice();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(size).append("\" ").append(crust).append(" crust pizza");

        if (!toppings.isEmpty()) {
            sb.append(" with: ");
            for (int i = 0; i < toppings.size(); i++) {
                sb.append(toppings.get(i).getToppingName());
                if (toppings.get(i).isExtra()) {
                    sb.append(" (extra)");
                }
                if (i < toppings.size() - 1) {
                    sb.append(", ");
                }
            }
        }
        sb.append(" - $").append(String.format("%.2f", calculatePrice()));

        return sb.toString();
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
        this.toppings.add(selectedTopping);

    }
}
