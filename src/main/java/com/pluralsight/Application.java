package com.pluralsight;

import com.pluralsight.ui.UserInterface;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            UserInterface userInterface = new UserInterface();
            userInterface.runMainMenu();

            scanner.close();
        }
    }
