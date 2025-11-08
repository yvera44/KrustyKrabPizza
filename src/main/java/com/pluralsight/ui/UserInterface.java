package com.pluralsight.ui;

import java.util.Scanner;

public class UserInterface {
    private static Scanner scanner = new Scanner(System.in);

    // Main menu loop
    public static void runMainMenu() {
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

    private static void displayMenu() {
        System.out.println("""
                ========= Main Menu ======
                (1) New Order
                (0) Exit Menu """);

    }

    public static void runOrderMenu() {
        boolean running = true;

        while (running) {
            displayItemMenu();
            System.out.println("Choose Order Items: ");
            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "1":
                    runPizzaBuilder();
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

    private static void displayItemMenu() {
        System.out.println("""
                ========= Order Menu ======
                (1) Add Pizza
                (2) Add Drink
                (3) Add Garlic Knots
                (4) Checkout
                (5) Cancel Order""");

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


        // showOrderMenu:
        //   - print:
        //       1) Add Sandwich
        //       2) Add Drink
        //       3) Add Chips
        //       4) Checkout
        //       0) Cancel Order
        //   - prompt user for choice
        //   - return user input

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
