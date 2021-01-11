package com.mycompany.hoteltrivago;
import java.io.*;
import java.util.*;
public class FileOfBookings {
    private static String preBookings;
    public static void setUpBooked(){
        preBookings = System.getProperty("user.dir")+"\\bookings.text"; // Intialises file if it doesn't exist
    }
    public static void addToBookingList(){
        String currentLine;
        try {
            BufferedReader read = new BufferedReader(new FileReader(preBookings));
            while ((currentLine = read.readLine()) != null) {
                String[] bookingDetails = currentLine.split(","); //Each feild is split by a comma
                String name = bookingDetails[0];
                String type = bookingDetails[1];
                String board = bookingDetails[2];
                String displayPrice = bookingDetails[3];
                int bookingNumber = Integer.parseInt(bookingDetails[4]);
                booking currentBooking = new booking(name, type, board, displayPrice, bookingNumber);
                main.booked.add(currentBooking);
            }
            read.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    public static void addToBookingFile(){
        try {
            FileWriter writeToFile = new FileWriter(preBookings, false);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            for (int i = 0; i < main.booked.size(); i++) {
                printToFile.println(main.booked.get(i).toFile());
            }
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
