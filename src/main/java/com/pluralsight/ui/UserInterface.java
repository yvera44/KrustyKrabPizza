package com.pluralsight.ui;

import com.pluralsight.model.Topping;

import javax.imageio.stream.ImageOutputStream;
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
            System.out.print("Choose and option: ");
            String choice = scanner.nextLine().trim().toUpperCase(); // normalize input

            switch (choice) {
                case "1":
                    runOrderMenu();
                    break;
                case "0":
                    System.out.println("Exiting.... Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println(); // blank line for spacing

        }
    }

    private void displayMenu() {
        System.out.println("""
                ========= Main Menu ======
                (1) New Order
                (0) Exit Menu """);

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
                    runCheckoutMenu();
                    break;
                case "5":
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
                (5) Cancel Order""");
    }


    public void runPizzaMenu() {
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Choose and option: ");
            String choice = scanner.nextLine().trim().toUpperCase(); // normalize input

            switch (choice) {
                case "Thin", "Regular", "Thick", "Cauliflower":
                    break;
                case "0":
                    System.out.println("Exiting.... Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println(); // blank line for spacing

        }
    }

    public List<Topping> loadRegularToppings(){
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

    public List<Topping> loadMeatToppings(){
        List<Topping> meatToppings = new ArrayList<>();

        Topping pepperoni = new Topping("Pepperoni", "Meat", false, 1.00);
        meatToppings.add(pepperoni);

        Topping sausage = new Topping("Sausage", "Meat", false, 1.00);
        meatToppings.add(pepperoni);

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

    public List<Topping> loadCheeseToppings(){
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

    public List<Topping> loadSauceToppings(){
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

    public List<Topping> loadSidesToppings() {
        List<Topping> sidesToppings = new ArrayList<>();

        Topping redPepper = new Topping("Red Pepper", "Side", false, 0);
        sidesToppings.add(redPepper);

        Topping parmesan = new Topping("Parmesan", "Side", false, 0);
        sidesToppings.add(parmesan);

        return sidesToppings;
    }



    // promptForBreadType:
        //   - print list of bread types
        //   - ask user to type one in (e.g., "white")
        //   - return as user input

        // promptForSize:
        //   - ask user: "What size? (4, 8, or 12 inches)"
        //   - return user input

        // promptForToasted:
        //   - ask: "Would you like it toasted? (yes or no)"
        //   - return user input

        // promptForMeats:
        //   - possible loop (one or multiple meats?):
        //       - ask user to type of meat (or 'done' to finish)
        //       - ask if they want Extra meat? (yes or no)"
        //   - return list of meats and extras

        // and so on and so on........

    }
}
