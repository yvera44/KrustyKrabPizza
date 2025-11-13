package com.pluralsight.data;

import com.pluralsight.model.MenuItem;
import com.pluralsight.model.Order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReceiptWriter {

    private Order order;
    private String fileName;

    public void saveReceipt(Order order) {
        // generate filename using current date/time (yyyyMMdd-HHmmss.txt)
        String fileName = generateTimestamp() + ".txt";
        // create a FileWriter and wrap in BufferedWriter (src/main/resources/receipts

        // loop through all order items
        try {
            FileWriter fileWriter = new FileWriter("receipts/", true );
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            // write to the file

            // close the writer
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("ERROR: An unexpected error occurred");
            e.getStackTrace();
        }
        //   - write the items to the to reciept
        //write total cost

        // close BufferedWriter
        // handle IOException with error message
    }

    private String generateTimestamp() {
        // Create timestamp string useing a formatter
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

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
