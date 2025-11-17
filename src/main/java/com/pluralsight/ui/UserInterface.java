package com.pluralsight.ui;

import com.pluralsight.data.ReceiptWriter;
import com.pluralsight.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);

    // Main menu loop
    public void runMainMenu() {
        boolean running = true;
        System.out.println("═════════════════════════════════════════════════");
        System.out.println(Colors.BOLD_BRIGHT_YELLOW + "     WELCOME TO THE KRUSTY KRAB PIZZA PARLOR " + Colors.RESET);
        System.out.println("═════════════════════════════════════════════════");

        while (running) {
            displayMenu();
            System.out.print(Colors.GREEN + "Choose and option: ");
            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "1":
                    runOrderMenu();
                    break;
                case "0":
                    System.out.println("Exiting... Thank you!");
                    running = false;
                    break;
                default:
                    System.out.println("Wrong! Its either 1 or 0, we literally could not have made this any easier. ");
            }

            System.out.println();

        }
    }

    private void displayMenu() {
        System.out.println(Colors.YELLOW + """
                ╔═══════════════════════════════════════════════╗
                ║         THE KRUSTY KRAB PIZZA PARLOR          ║
                ║          "The Pizza for You and Me"           ║
                ╠═══════════════════════════════════════════════╣
                ║                [1] New Order                  ║
                ║                [0] Exit                       ║
                ╚═══════════════════════════════════════════════╝""");

    }

    public void runOrderMenu() {
        Order currentOrder = new Order();
        boolean running = true;

        while (running) {
            displayItemMenu();
            System.out.print("Choose Order Items: ");
            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "1":
                    Pizza pizza = runPizzaMenu();
                    if (pizza != null){
                        currentOrder.addPizza(pizza);
                    }
                    break;
                case "2":
                    Drink drink = runDrinkMenu();
                    if (drink != null){
                        currentOrder.addDrink(drink);
                    }
                    break;
                case "3":
                    GarlicKnots garlicKnots = runGarlicKnotsMenu();
                    if (garlicKnots != null){
                        currentOrder.addGarlicKnots(garlicKnots);
                    }
                    break;
                case "4":
                    runCheckOutMenu(currentOrder);
                    running = false;
                    break;
                case "X":
                    System.out.println("Canceling order...");
                    running = false;
                    break;
            }
        }
    }

    private void displayItemMenu() {
        System.out.println(Colors.BLUE + """
                ╔═══════════════════════════════════════════════╗
                ║                   ITEM MENU                   ║
                ╠═══════════════════════════════════════════════╣
                ║             [1] Add Pizza                     ║
                ║             [2] Add Drink                     ║
                ║             [3] Add Garlic Knots              ║
                ║             [4] Checkout                      ║
                ║             [X] Cancel Order                  ║
                ╚═══════════════════════════════════════════════╝""" + Colors.RESET);
    }

    public Pizza runPizzaMenu() {
        displayCrustMenu();
        System.out.print("Choose your krust: ");
        String choice = scanner.nextLine().trim().toUpperCase(); // normalize input

        String crust = "";
        switch (choice) {
            case "1":
                crust = "Regular";
                break;
            case "2":
                crust = "Thin";
                break;
            case "3":
                crust = "Think";
                break;
            case "4":
                crust = "Cauliflower";
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                return null;
        }
        System.out.println("You selected: " + crust + " krust"); // blank line for spacing
        return runPizzaSize(crust);

    }

    private void displayCrustMenu() {
        System.out.println(Colors.YELLOW + """
                ╔═══════════════════════════════════════════════╗
                ║                  KRUST TYPES                  ║
                ╠═══════════════════════════════════════════════╣
                ║              [1] Thin                         ║
                ║              [2] Regular                      ║
                ║              [3] Thick                        ║
                ║              [4] Cauliflower                  ║
                ║                                               ║
                ║              [X] Cancel Order                 ║
                ╚═══════════════════════════════════════════════╝""" + Colors.RESET);
    }

    public Pizza runPizzaSize(String crust) {
        displayPizzaSizes();
        System.out.print("Choose your pizza size: ");
        String choice = scanner.nextLine().trim().toUpperCase();

        int size = 0;
        switch (choice) {
            case "S":
                size = 8;
                System.out.println("8 inch");
                break;
            case "M":
                size = 12;
                System.out.println("12 inch");
                break;
            case "L":
                size = 16;
                System.out.println("16 inch");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        System.out.println();
        Pizza pizza = new Pizza(crust, size);
        runToppingsMenu(pizza);
        return pizza;
    }

    private void displayPizzaSizes() {
        System.out.println(Colors.BLUE + """
                ╔═══════════════════════════════════════════════╗
                ║                  PIZZA SIZES                  ║
                ╠═══════════════════════════════════════════════╣
                ║            [S] Small 8"    ($8.50)            ║
                ║            [M] Medium 12"  ($12.00)           ║
                ║            [L] Large 16"   ($16.50)           ║
                ╚═══════════════════════════════════════════════╝"""+ Colors.RESET);
    }

    public Pizza runToppingsMenu(Pizza pizza) {
        boolean running = true;

        while (running) {
            displayToppingsMenu();
            System.out.print("Choose your topping(s): ");
            String choice = scanner.nextLine().trim().toUpperCase(); // normalize input

            switch (choice) {
                case "R":
                    selectFromToppingList(pizza, loadRegularToppings(), "Regular Toppings");
                    break;
                case "M":
                    selectFromToppingList(pizza, loadMeatToppings(), "Meat Toppings");
                    break;
                case "C":
                    selectFromToppingList(pizza, loadCheeseToppings(), "Cheese Toppings");
                    break;
                case "S":
                    selectFromToppingList(pizza, loadSauceToppings(), "Sauce Toppings");
                    break;
                case "E":
                    selectFromToppingList(pizza, loadSidesToppings(), "Extras");
                    break;
                case "X":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println(); // blank line for spacing
        }
        return pizza;
    }

    private void displayToppingsMenu() {
        System.out.println(Colors.YELLOW + """               
                ╔═══════════════════════════════════════════════╗
                ║                    TOPPINGS                   ║
                ╠═══════════════════════════════════════════════╣
                ║             [R] Regular Toppings              ║
                ║             [M] Meats                         ║
                ║             [C] Cheeses                       ║
                ║             [S] Sauces                        ║
                ║             [E] Extras                        ║
                ║                                               ║
                ║             [X] Save & Exit to Main Menu      ║
                ╚═══════════════════════════════════════════════╝""");}

    private void selectFromToppingList(Pizza pizza, List<Topping> toppings, String catergory) {
        System.out.println(Colors.CYAN + "┌─────────────────────────────────────────┐");
        System.out.println(Colors.CYAN + "│            " + Colors.RESET + catergory );
        System.out.println(Colors.CYAN + "└─────────────────────────────────────────┘");
//create own method:
        int index = 1;
        System.out.println(Colors.MAGENTA + "╔═════════════════════════════════════════╗");
        for (Topping topping : toppings) {

            System.out.println(Colors.RESET + "   ["+ index + "]" + " " + topping.getToppingName() + " - $" + topping.calculateFinalToppingPrice(pizza.getSize()));
            index++;
        }
        System.out.println(Colors.MAGENTA + "╚═════════════════════════════════════════╝"+ Colors.RESET);
        System.out.print("Choose a topping or 0 to go back: ");

        try {
            int choice = Integer.parseInt(scanner.nextLine().trim());

            if (choice == 0) {
                return;
            }
            if (choice > 0 && choice <= toppings.size()) {
                Topping selectedTopping = toppings.get(choice - 1);

                System.out.println("Extra toppings " + selectedTopping.getToppingName() + "? (Yes/No): ");
                String extra = scanner.nextLine().trim().toUpperCase();

                if (extra.equals("YES")) {

                    Topping extraTopping = new Topping(selectedTopping.getToppingName(), selectedTopping.getToppingType(), true, selectedTopping.getBasePrice());
                    pizza.addTopping(extraTopping);
                } else {
                    pizza.addTopping(selectedTopping);
                }
                selectedTopping.calculateFinalToppingPrice(pizza.getSize());
                String selectedToppingPrint = selectedTopping.getToppingName() + " $" + (selectedTopping.calculateFinalToppingPrice(pizza.getSize()));
                System.out.println(Colors.MAGENTA + "╔══════════════════════════════════════════╗");
                System.out.println(Colors.MAGENTA + "║" + Colors.RESET + "    ✓ TOPPING ADDED! " + selectedToppingPrint);
                System.out.println(Colors.MAGENTA + "╚══════════════════════════════════════════╝" + Colors.RESET);

            } else {
                System.out.println("Invalid choice.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    public Drink runDrinkMenu() {

        displayDrinkMenu();
        System.out.print("Choose your drink size: ");
        String choice = scanner.nextLine().trim().toUpperCase();

        int size = 0;
        switch (choice) {
            case "S":
                size = 16;
                System.out.println("16 Oz");
                break;
            case "M":
                size = 22;
                System.out.println("22 Oz");
                break;
            case "L":
                size = 30;
                System.out.println("30 Oz");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                return null;
        }
        System.out.println();
        return selectFromDrinkList(size);

    }

    private void displayDrinkMenu() {
        System.out.println(Colors.YELLOW+ """              
                ╔═══════════════════════════════════════════════╗
                ║                    DRINKS                     ║
                ╠═══════════════════════════════════════════════╣
                ║          [S] Small 16 oz   ($2.00)            ║
                ║          [M] Medium 22 oz  ($2.50)            ║
                ║          [L] Large 30 oz   ($3.00)            ║
                ║                                               ║
                ║          [X] Back to Order Menu               ║
                ╚═══════════════════════════════════════════════╝""" + Colors.RESET);
    }

    private Drink selectFromDrinkList(int size) {
        List<String> drinkNames = loadDrinks();
        System.out.println(Colors.CYAN + "┌─────────────────────────────────────────┐");
        System.out.println(Colors.CYAN + "│" + Colors.RESET + "            Available Drinks");
        System.out.println(Colors.CYAN + "└─────────────────────────────────────────┘");

        int index = 1;
        System.out.println(Colors.MAGENTA + "╔═════════════════════════════════════════╗");
        for (String drinkName : drinkNames) {
            System.out.println(Colors.RESET + "  ["+ index + "]"  + " " + drinkName);
            index++;
        }
        System.out.println(Colors.MAGENTA + "╚═════════════════════════════════════════╝");
        System.out.print("Choose a Drink: ");

        try {
            int choice = Integer.parseInt(scanner.nextLine().trim());
            if (choice == 0) {
                return null;
            }

            if (choice > 0 && choice <= drinkNames.size()) {
                String selectedDrink = drinkNames.get(choice - 1);
                Drink drink = new Drink(selectedDrink, size, 0, 1);
                System.out.println(Colors.MAGENTA + "╔══════════════════════════════════════════════════════╗");
                System.out.println(Colors.MAGENTA + "║" + Colors.RESET + "     ✓ DRINK ADDED! " + drink);
                System.out.println(Colors.MAGENTA + "╚══════════════════════════════════════════════════════╝" + Colors.RESET);

                return drink;
            } else {
                System.out.println("Invalid Choice.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
        return null;
    }

    public GarlicKnots runGarlicKnotsMenu() {

        displayGarlicKnotsMenu();
        System.out.print("Choose your drink size: ");
        String choice = scanner.nextLine().trim().toUpperCase();

        int quantity = 0;
        switch (choice) {
            case "S":
                quantity = 3;
                System.out.println("3 Piece Garlic Knots");
                break;
            case "M":
                quantity = 5;
                System.out.println("5 Piece Garlic Knots");
                break;
            case "L":
                quantity = 8;
                System.out.println("8 Piece Garlic Knots");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                return null;
        }
        System.out.println();

        GarlicKnots garlicKnots = new GarlicKnots(0, quantity, "Garlic Knots");

        System.out.println(Colors.BLUE + "╔══════════════════════════════════════════════════════╗");
        System.out.println(Colors.BLUE + "║" +Colors.RESET + "   GARLIC KNOTS ADDED! " + garlicKnots);
        System.out.println(Colors.BLUE + "╚══════════════════════════════════════════════════════╝" + Colors.RESET);

        return garlicKnots;
    }

    private void displayGarlicKnotsMenu() {
        System.out.println(Colors.YELLOW + """
                ╔═══════════════════════════════════════════════╗
                ║                 GARLIC KNOTS                  ║
                ╠═══════════════════════════════════════════════╣
                ║       [S] 3 Piece Garlic Knots  ($4.00)       ║
                ║       [M] 5 Piece Garlic Knots  ($5.50)       ║
                ║       [L] 8 Piece Garlic Knots  ($7.00)       ║
                ║                                               ║
                ║            [X] Back to Order Menu             ║
                ╚═══════════════════════════════════════════════╝"""+ Colors.RESET);
    }

    public void runCheckOutMenu(Order order) {

        boolean running = true;
        System.out.println(Colors.BOLD + "CHECKING OUT");

        while (running) {
            displayCheckOutMenu(order);
            System.out.print(Colors.BLUE + "PLEASE CONFIRM YOUR ORDER:  ");
            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "Y":
                    completeOrder(order);
                    System.out.println("                 Order confirmed!");
                    System.out.println("Thanks for dining at the Krusty Krab Pizza Parlor!");
                    System.out.println("-----------------------------------------------");
                    running = false;
                    break;
                case "N":
                    System.out.println("\n Ordered cancelled. Returning to Order Menu...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid input... Please try again. ");
            }
            System.out.println();
        }
    }

    private void displayCheckOutMenu(Order order) {
        System.out.println(Colors.YELLOW + """
                ╔═══════════════════════════════════════════════╗
                ║                   CHECKOUT                    ║
                ║           Please confirm your order:          ║
                ╚═══════════════════════════════════════════════╝""" + Colors.RESET);

        // Display Pizzas
        if (!order.getPizzas().isEmpty()) {
            System.out.println(Colors.BLUE + "PIZZAS:");
            for (Pizza pizza : order.getPizzas()) {
                System.out.println("  - " + pizza.toString());
            }
            System.out.println();
        }

        // Display Drinks
        if (!order.getDrinks().isEmpty()) {
            System.out.println(Colors.BLUE + "DRINKS:");
            for (Drink drink : order.getDrinks()) {
                System.out.println("  - " + drink.toString());
            }
            System.out.println();
        }

        // Display Garlic Knots
        if (!order.getGarlicKnots().isEmpty()) {
            System.out.println(Colors.BLUE + "GARLIC KNOTS:");
            for (GarlicKnots knots : order.getGarlicKnots()) {
                System.out.println("  - " + knots.toString());
            }
            System.out.println();
        }

        // Display Total
        double total = order.calculateTotal();
        System.out.println("═════════════════════════════════════");
        System.out.printf("TOTAL: $%.2f\n", total);
        System.out.println("═════════════════════════════════════");

        System.out.println(Colors.RESET + """           
            ╔═══════════════════════════════════════════════╗
            ║              [Y] Confirm Order                ║
            ║              [N] Cancel Order                 ║
            ╚═══════════════════════════════════════════════╝
            """);
    }

    private void completeOrder(Order order) {
        System.out.println(order.getOrderSummary());
        ReceiptWriter.saveReceipt(order);
        System.out.println("Receipt saved successfully!");
        System.out.println("-----------------------------------------------");
    }

    private void showOrderSummary(Order order, Scanner scanner) {
        System.out.println("\n" + order.getOrderSummary());

        scanner.close();
    }

    public List<Topping> loadRegularToppings () {
            List<Topping> regularToppings = new ArrayList<>();

            Topping onions = new Topping("Onions", "Vegetable", false, 0);
            regularToppings.add(onions);

            Topping mushrooms = new Topping("Mushrooms", "Vegetable", false, 0);
            regularToppings.add(mushrooms);

            Topping bellPeppers = new Topping("Bell Peppers", "Vegetable", false, 0);
            regularToppings.add(bellPeppers);

            Topping olives = new Topping("Olives", "Vegetable", false, 0);
            regularToppings.add(olives);

            Topping tomatoes = new Topping("Tomatoes", "Fruit", false, 0);
            regularToppings.add(tomatoes);

            Topping spinach = new Topping("Spinach", "Vegetable", false, 0);
            regularToppings.add(spinach);

            Topping basil = new Topping("Basil", "Vegetable", false, 0);
            regularToppings.add(basil);

            Topping pineapple = new Topping("Pineapple", "Fruit", false, 0);
            regularToppings.add(pineapple);

            Topping anchovies = new Topping("Anchovies", "Meat", false, 0);
            regularToppings.add(anchovies);

            return regularToppings;
        }

        public List<Topping> loadMeatToppings () {
            List<Topping> meatToppings = new ArrayList<>();

            Topping pepperoni = new Topping("Pepperoni", "Meat", false, 1.00);
            meatToppings.add(pepperoni);

            Topping sausage = new Topping("Sausage", "Meat", false, 1.00);
            meatToppings.add(sausage);

            Topping ham = new Topping("Ham", "Meat", false, 1.00);
            meatToppings.add(ham);

            Topping bacon = new Topping("Bacon", "Meat", false, 1.00);
            meatToppings.add(bacon);

            Topping chicken = new Topping("Chicken", "Meat", false, 1.00);
            meatToppings.add(chicken);

            Topping meatball = new Topping("Meatball", "Meat", false, 1.00);
            meatToppings.add(meatball);

            return meatToppings;
        }

        public List<Topping> loadCheeseToppings () {
            List<Topping> cheeseToppings = new ArrayList<>();

            Topping mozzarella = new Topping("Mozzarella", "Cheese", false, 0.75);
            cheeseToppings.add(mozzarella);

            Topping parmesan = new Topping("Parmesan", "Cheese", false, 0.75);
            cheeseToppings.add(parmesan);

            Topping ricotta = new Topping("Ricotta", "Cheese", false, 0.75);
            cheeseToppings.add(ricotta);

            Topping goatCheese = new Topping("Goat Cheese", "Cheese", false, 0.75);
            cheeseToppings.add(goatCheese);

            Topping buffaloCheese = new Topping("Buffalo Cheese", "Cheese", false, 0.75);
            cheeseToppings.add(buffaloCheese);

            return cheeseToppings;
        }

        public List<Topping> loadSauceToppings () {
            List<Topping> sauceToppings = new ArrayList<>();

            Topping marinara = new Topping("Marinara", "Sauce", false, 0);
            sauceToppings.add(marinara);

            Topping alfredo = new Topping("Alfredo", "Sauce", false, 0);
            sauceToppings.add(alfredo);

            Topping pesto = new Topping("Pesto", "Sauce", false, 0);
            sauceToppings.add(pesto);

            Topping bbq = new Topping("BBQ", "Sauce", false, 0);
            sauceToppings.add(bbq);

            Topping buffalo = new Topping("Buffalo", "Sauce", false, 0);
            sauceToppings.add(buffalo);

            Topping oliveOil = new Topping("Olive Oil", "Sauce", false, 0);
            sauceToppings.add(oliveOil);

            return sauceToppings;
        }

        public List<Topping> loadSidesToppings () {
            List<Topping> sidesToppings = new ArrayList<>();

            Topping redPepper = new Topping("Red Pepper", "Side", false, 0);
            sidesToppings.add(redPepper);

            Topping parmesan = new Topping("Parmesan", "Side", false, 0);
            sidesToppings.add(parmesan);

            return sidesToppings;
        }

        public List<String> loadDrinks () {
            List<String> drinkNames = new ArrayList<>();
            drinkNames.add("Diet Dr. Kelp");
            drinkNames.add("Dr. Kelp");
            drinkNames.add("Kelpsi");
            drinkNames.add("Mountain Climb-Up-And-Fall-Off");
            drinkNames.add("Kelp Shake");
            drinkNames.add("Water");
            return drinkNames;
        }
}