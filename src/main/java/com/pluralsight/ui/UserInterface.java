package com.pluralsight.ui;

import com.pluralsight.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);

    // Main menu loop
    public void runMainMenu() {
        boolean running = true;
        System.out.println("WELCOME TO THE KRUSTY KRAB PIZZA PARLOR ");

        while (running) {
            displayMenu();
            Order currentOrder = new Order();
            System.out.print("Choose and option: ");
            String choice = scanner.nextLine().trim().toUpperCase(); // normalize input

            switch (choice) {
                case "1":
                    runOrderMenu();
                    break;
                case "0":
                    System.out.println("Exiting... Uhm maybe order something next time!?");
                    running = false;
                    break;
                default:
                    System.out.println("Wrong! Its either 1 or 0, we literally could not have made this any easier. ");
            }

            System.out.println(); // blank line for spacing

        }
    }

    private void displayMenu() {
        System.out.println("""
                ╔═══════════════════════════════════════════════╗
                ║                                               ║
                ║         THE KRUSTY KRAB PIZZA PARLOR          ║
                ║          "The Pizza for You and Me"           ║
                ║                                               ║
                ╠═══════════════════════════════════════════════╣
                ║                                               ║
                ║        [1] New Order                          ║
                ║        [0] Exit                               ║
                ║                                               ║
                ╚═══════════════════════════════════════════════╝""");

    }

    public void runOrderMenu() {
        boolean running = true;

        while (running) {
            displayItemMenu();
            System.out.print("Choose Order Items: ");
            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "1":
                    runPizzaMenu();
                    break;
                case "2":
                    runDrinkMenu();
                    break;
                case "3":
                    System.out.print("How many garlic knots would you like? ");
                    break;
                case "4":
                    //runCheckoutMenu();
                    break;
                case "X":
                    System.out.println("Canceling order...");
                    running = false;
                    break;
            }
        }
    }

    private void displayItemMenu() {
        System.out.println("""
                ╔═══════════════════════════════════════════════╗
                ║                                               ║
                ║                   ITEM MENU                   ║
                ║                                               ║
                ╠═══════════════════════════════════════════════╣
                ║                                               ║
                ║             [1] Add Pizza                     ║
                ║             [2] Add Drink                     ║
                ║             [3] Add Garlic Knots              ║
                ║             [4] Checkout                      ║
                ║             [X] Cancel Order                  ║
                ║                                               ║
                ╚═══════════════════════════════════════════════╝""");
    }

    public void runPizzaMenu() {
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
        }
        System.out.println("You selected: " + crust + " krust"); // blank line for spacing
        runPizzaSize(crust);
    }

    private void displayCrustMenu() {
        System.out.println("""
                ╔═══════════════════════════════════════════════╗
                ║                                               ║
                ║                  KRUST TYPES                  ║
                ║                                               ║
                ╠═══════════════════════════════════════════════╣
                ║                                               ║
                ║              [1] Thin                         ║
                ║              [2] Regular                      ║
                ║              [3] Thick                        ║
                ║              [4] Cauliflower                  ║
                ║              [X] Cancel Order                 ║
                ║                                               ║
                ╚═══════════════════════════════════════════════╝""");
    }

    public void runPizzaSize(String crust) {

        displayPizzaSizes();
        System.out.print("Choose your pizza size: ");
        String choice = scanner.nextLine().trim().toUpperCase();

        int size = 0;// normalize input
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
    }

    private void displayPizzaSizes() {
        System.out.println("""
                ╔═══════════════════════════════════════════════╗
                ║                                               ║
                ║                  PIZZA SIZES                  ║
                ║                                               ║
                ╠═══════════════════════════════════════════════╣
                ║                                               ║
                ║               [S] Small 8"                    ║
                ║               [M] Medium 12"                  ║
                ║               [L] Large 16"                   ║
                ║                                               ║
                ╚═══════════════════════════════════════════════╝""");
    }

    public void runToppingsMenu(Pizza pizza) {
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
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println(); // blank line for spacing
        }
    }

    private void displayToppingsMenu() {
        System.out.println("""
                
                ╔═══════════════════════════════════════════════╗
                ║                                               ║
                ║                    TOPPINGS                   ║
                ║                                               ║
                ╠═══════════════════════════════════════════════╣
                ║                                               ║
                ║             [R] Regular Toppings              ║
                ║             [M] Meats                         ║
                ║             [C] Cheeses                       ║
                ║             [S] Sauces                        ║
                ║             [E] Extras                        ║
                ║                                               ║
                ╚═══════════════════════════════════════════════╝""");
    }

    private void selectFromToppingList(Pizza pizza, List<Topping> toppings, String catergory) {
        System.out.println("════════════ " + catergory + " ════════════");
//create own method:
        int index = 1;
        for (Topping topping : toppings) {
            System.out.println(index + " " + topping.getToppingName() + " - $" + topping.calculateFinalToppingPrice(pizza.getSize()));
            index++;
        }
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
                System.out.println("╔════════════════════════════════════╗");
                System.out.println("║          ✓ TOPPING ADDED!           ");
                System.out.println("║             " + selectedTopping.getToppingName());
                System.out.println("╚════════════════════════════════════╝");
                selectedTopping.calculateFinalToppingPrice(pizza.getSize());

                System.out.println(selectedTopping.calculateFinalToppingPrice(pizza.getSize()));
            } else {
                System.out.println("Invalid choice.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    public void runDrinkMenu() {

        displayDrinkMenu();
        System.out.print("Choose your drink size: ");
        String choice = scanner.nextLine().trim().toUpperCase();

        int size = 0;// normalize input
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
        }
        System.out.println();
        selectFromDrinkList(size);
    }

    private void displayDrinkMenu() {
        System.out.println("""
                ╔═══════════════════════════════════════════════╗
                ║                                               ║
                ║                    DRINKS                     ║
                ║                                               ║
                ╠═══════════════════════════════════════════════╣
                ║                                               ║
                ║             [S] Small 16 oz                   ║
                ║             [M] Medium 22 oz                  ║
                ║             [L] Large 30 oz                   ║
                ║             [X] Back to Order Menu            ║
                ║                                               ║
                ╚═══════════════════════════════════════════════╝""");
    }

    private void selectFromDrinkList(int size) {
        List<String> drinkNames = loadDrinks();

        System.out.println("════════════ Available Drinks ════════════");
        int index = 1;
        for (String drinkName : drinkNames) {
            System.out.println(index + " " + drinkName);
            index++;
        }
        System.out.print("Choose a Drink: ");

        try {
            int choice = Integer.parseInt(scanner.nextLine().trim());
            if (choice == 0) {
                return;
            }

            if (choice > 0 && choice <= drinkNames.size()) {
                String selectedDrink = drinkNames.get(choice - 1);
                Drink drink = new Drink(selectedDrink, size, 0, 1);
                System.out.println("╔══════════════════════════════════════════════════════╗");
                System.out.println("║     ✓ DRINK ADDED!" + drink);
                System.out.println("╚══════════════════════════════════════════════════════╝");
            } else {
                System.out.println("Invalid Choice.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
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