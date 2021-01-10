package com.mycompany.hoteltrivago;
import java.io.*;
import java.util.*;
public class FileOfBookings {
    private static String preBookings;
    public static void setUpBooked(){
        preBookings = System.getProperty("user.dir")+"\\bookings.text"; // Intialises file
    }
    public static void addToBookingList(){
        try{
            FileInputStream fileIn = new FileInputStream(preBookings);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            booking currentLine = (booking)objectIn.readObject(); // Current record saved as variable currentLine
            while (currentLine != null){
                main.booked.add(currentLine); // currrentLine saved in the booking array 
            }   // NOT WORKING
            System.out.println("All bookings have been loaded from the file");
            objectIn.close();
        }catch(Exception e){
            System.out.println("Error: "+e);
        }
    }
    public static void addToBookingFile(){
        try {
            String newPreBookings;
            newPreBookings = System.getProperty("user.dir")+"\\bookings.text"; // Overwrites file with the update bookings
            FileOutputStream fileOut = new FileOutputStream(newPreBookings);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            for (int i = 0; i < main.booked.size(); i++) { // the booking ArrayList gets saved as a file
                objectOut.writeObject(main.booked.get(i)); 
            }
            objectOut.close();
            System.out.println("The booking was succesfully written to a file");
        } catch (Exception e) {
            System.out.println("Exception Error: "+e);
        }
    }
}
