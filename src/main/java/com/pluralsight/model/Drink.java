package com.pluralsight.model;

public class Drink extends MenuItem {

    private String size;

    public Drink(double price, int quantity, String description, String size) {
        super(price, quantity, description);
        this.size = size;

        if (this.size.equalsIgnoreCase("Small")) {
            price = 2.00;
        }else if (this.size.equalsIgnoreCase("Medium")){
            price = 2.50;
        }else if (this.size.equalsIgnoreCase("Large")){
            price = 3.00;
        }else
            price = 0;

    }
    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "size='" + size + '\'' +
                '}';
    }
}




