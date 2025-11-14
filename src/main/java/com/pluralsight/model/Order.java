package com.pluralsight.model;

import com.pluralsight.ui.Colors;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private String customerName;
    private LocalDateTime orderTime;
    private List<Pizza> pizzas;
    private List<Drink> drinks;
    private List<GarlicKnots> garlicKnots;
    private List<MenuItem> totalItems;
    private double totalPrice;

    public Order() {
        this.customerName = "";
        this.orderTime = LocalDateTime.now();
        this.pizzas = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.garlicKnots = new ArrayList<>();
        this.totalItems = new ArrayList<>();
        this.totalPrice = 0.00;

    }
    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addGarlicKnots(GarlicKnots knots) {
        garlicKnots.add(knots);
    }
    public void addTotalItems(Pizza pizzas, Drink drinks, GarlicKnots knots) {
        totalItems.add(pizzas);
        totalItems.add(drinks);
        totalItems.add(knots);
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Pizza pizza : pizzas) {
            total += pizza.getPrice();
        }
        for (Drink drink : drinks) {
            total += drink.getPrice();
        }
        for (GarlicKnots knots : garlicKnots) {
            total += knots.getPrice();
        }
        return total;
    }

    public String getOrderSummary() {
        StringBuilder summary = new StringBuilder(Colors.YELLOW + "═══════════ Order Summary ═══════════\n");

        if (!pizzas.isEmpty()) {
            summary.append("\nPizzas:\n");
            pizzas.stream()
                    .forEach(pizza -> summary.append(" - ").append(pizza.toString()).append("\n"));
        }

        if (!drinks.isEmpty()) {
            summary.append("\nDrinks:\n");
            drinks.stream()
                    .forEach(drink -> summary.append(" - ").append(drink).append("\n"));
        }

        if (!garlicKnots.isEmpty()) {
            summary.append("\nGarlic Knots:\n");
            garlicKnots.stream()
                    .forEach(garlicKnots -> summary.append(" - ").append(garlicKnots).append("\n"));
        }

        summary.append("\nTotal: $").append(String.format("%.2f", calculateTotal())).append("\n");
        summary.append(Colors.YELLOW + "═════════════════════════════════");

        return summary.toString();
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<GarlicKnots> getGarlicKnots() {
        return garlicKnots;
    }

    public List<MenuItem> getTotalItems() {
        return totalItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
