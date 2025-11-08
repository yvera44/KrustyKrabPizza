package com.pluralsight;

import java.util.Scanner;

import static com.pluralsight.ui.UserInterface.runMainMenu;

public class Application {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        runMainMenu();
        scanner.close();

    }
}
