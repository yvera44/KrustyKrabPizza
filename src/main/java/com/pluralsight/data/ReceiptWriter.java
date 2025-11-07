package com.pluralsight.data;

import com.pluralsight.model.Order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    public static void saveReceipt(Order order) {
        // generate filename using current date/time (yyyyMMdd-HHmmss.txt)
        String fileName = generateTimestamp() + ".txt";

        // create a FileWriter and wrap in BufferedWriter (src/main/resources/receipts

        // loop through all order items
        try {
            FileWriter fileWriter = new FileWriter("receipt.txt", true );
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            // write to the file
            bufferedWriter.write("line 1 is here \n");
            bufferedWriter.write("line 2 is here \n");
            bufferedWriter.write("line 3 is here \n");

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

    private static String generateTimestamp() {
        // Create timestamp string useing a formatter
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime now = LocalDateTime.now();
        return now.format(formatter1);

        // return that string
    }
}
