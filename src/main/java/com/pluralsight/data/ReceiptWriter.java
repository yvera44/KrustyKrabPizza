package com.pluralsight.data;

import com.pluralsight.model.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReceiptWriter {

    private Order order;
    private String fileName;

    public static void saveReceipt(Order order) {
        String fileName = generateTimestamp() + ".txt";
        String filePath = "receipts/" + fileName;

        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("╔═══════════════════════════════════════════════╗\n");
            bufferedWriter.write("║                                               ║\n");
            bufferedWriter.write("║         THE KRUSTY KRAB PIZZA PARLOR          ║\n");
            bufferedWriter.write("║          \"The Pizza for You and Me\"         ║\n");
            bufferedWriter.write("║                                               ║\n");
            bufferedWriter.write("╚═══════════════════════════════════════════════╝\n\n");

            bufferedWriter.write("Date: " + generateTimestamp() + "\n");
            bufferedWriter.write("Order #: " + generateTimestamp() + "\n\n");

            bufferedWriter.write("═══════════════════════════════════════════════\n");
            bufferedWriter.write("                  ORDER ITEMS                  \n");
            bufferedWriter.write("═══════════════════════════════════════════════\n\n");

            bufferedWriter.write(order.getOrderSummary());


            bufferedWriter.write("══════════════\n");
            bufferedWriter.write(String.format("%15s\n", String.format("TOTAL: $%.2f", order.calculateTotal())));
            //bufferedWriter.write("═══════════════════════════════════════════════\n\n");


            bufferedWriter.write("        Thank You for Your Order!\n");
            bufferedWriter.write("      We Hope to See You Again Soon!\n\n");
            bufferedWriter.write("═══════════════════════════════════════════════\n");

            bufferedWriter.close();
            System.out.println("Receipt saved to: " + fileName);

            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("ERROR: An unexpected error occurred");
            e.getStackTrace();
        }
    }

    private static String generateTimestamp() {
        // Create timestamp string using a formatter
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

        LocalDateTime now = LocalDateTime.now();
        return now.format(formatter1);
        // return that string
    }
    private String createFileName() {
        List<MenuItem> items = order.getTotalItems();
        String itemList = "";

        for (MenuItem menuItem : items ){

            itemList += menuItem.getDescription();
            itemList += String.format("Price: $ %.2f\n\n", menuItem.getPrice());

        }
        return String.format("""
                Krusty Krab Pizza
                %s Customer Name
                %s Order Time
                %s
                %.2f Total Price
               
                """, order.getCustomerName(), order.getOrderTime(), itemList, order.getTotalPrice());
    }

}
