package com.pluralsight.ui;

import com.pluralsight.model.Order;
import com.pluralsight.model.Pizza;
import com.pluralsight.model.Topping;
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
                ========= Main Menu ======
                (1) New Order
                (0) Exit Menu""");

    }

    public void runOrderMenu() {
        boolean running = true;

        while (running) {
            displayItemMenu();
            System.out.println("Choose Order Items: ");
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
                ========= Order Menu ======
                (1) Add Pizza
                (2) Add Drink
                (3) Add Garlic Knots
                (4) Checkout
                (X) Cancel Order""");
    }


    public void runPizzaMenu() {
        displayCrustMenu();
        System.out.print("Choose your crust: ");
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
        System.out.println("You selected: " + crust + " crust"); // blank line for spacing
        runPizzaSize(crust);
    }

    private void displayCrustMenu() {
        System.out.println("""
                ========= Crust Types ======
                (1) Thin
                (2) Regular
                (3) Thick
                (4) Cauliflower""");
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
                ========= Pizza Sizes ======
                (S) 8 inch
                (M) 12 inch
                (L) 16 inch""");
    }

    public void runToppingsMenu(Pizza pizza) {
        boolean running = true;

        while (running) {
            displayToppingsMenu();
            System.out.print("Choose your topping(s): ");
            String choice = scanner.nextLine().trim().toUpperCase(); // normalize input

            switch (choice) {
                case "1":
                    selectFromToppingList(pizza, loadRegularToppings(), "Regular Toppings");
                    break;
                case "2":
                    selectFromToppingList(pizza, loadMeatToppings(), "Meat Toppings");
                    break;
                case "3":
                    selectFromToppingList(pizza, loadCheeseToppings(), "Cheese Toppings");
                    break;
                case "4":
                    selectFromToppingList(pizza, loadSauceToppings(), "Sauce Toppings");
                    break;
                case "5":
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
                ========= Toppings ======
                (R) Regular Toppings
                (M) Meats
                (C) Cheeses
                (S) Sauces
                (E) Extras""");
    }

    private void selectFromToppingList(Pizza pizza, List<Topping> toppings, String catergory) {
        System.out.println("=========== " + catergory + " ===========");

        int index = 1;
        for (Topping topping : toppings) {
            System.out.println(index + topping.getToppingName() + " - $" + topping.getBasePrice());
            index++;
        }
        System.out.println("Choose a topping or 0 to go back: ");

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
                System.out.println(selectedTopping.getToppingName() + " added!");
            } else {
                System.out.println("Invalid choice.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }

        private void displayDrinkMenu () {
            System.out.println("""
                    ========= Drink Menu (NOW ONLY SERVING DR. KELP!) =========
                    (S) Small 16oz Diet Dr. Kelp
                    (M) Medium 22oz Diet Dr. Kelp
                    (L) Large 30oz Diet Dr. Kelp
                    (X) Back to Order Menu""");
        }

        public void runDrinkMenu () {

            public void displayDrinkMenu();
            System.out.println("Choose Order Items: ");
            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "S", "M", "L":
                    break;
                case "X":
                    System.out.println("Returning to Order Menu....");
                    runOrderMenu();
                    break;
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
    }
}