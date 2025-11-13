package com.pluralsight.model;

public class Drink extends MenuItem {

    private int size;

    public Drink(String description, int size, double price, int quantity) {
        super(price, quantity, description);
        this.size = size;
    }

    public double getDrinkSizeMultiplier (int size){

            switch (size) {
                case 16:
                    return 2.00;
                case 22:
                    return 2.50;
                case 30:
                    return 3.50;
                default:
                    return 0.00;
            }
        }
        public double calculateFinalDrinkPrice (int size){
            return getDrinkSizeMultiplier(this.size);

        }


    }



