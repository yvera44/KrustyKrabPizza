package com.pluralsight.model;

public class GarlicKnots extends MenuItem {

    private int quantity;

    public GarlicKnots(double price, int quantity, String description) {
        super(price, quantity, description);
        this.quantity = quantity;

    }

    public double getKnotCountMultiplier (int quantity){

        switch (quantity) {
            case 3:
                return 4.00;
            case 5:
                return 5.50;
            case 8:
                return 7.00;
            default:
                return 0.00;
        }
    }
    public double calculateFinalKnotPrice (){
        return getKnotCountMultiplier(this.quantity);
    }

    @Override
    public double getPrice() {
        return calculateFinalKnotPrice();
    }

    @Override
    public String toString() {
        return quantity + "piece " + getDescription() + " - $" + String.format("%.2f", calculateFinalKnotPrice());
    }
}
