package com.mycompany.hoteltrivago;
import java.text.*;
import java.util.*;
public class main {
    private static Scanner input = new Scanner(System.in);
    public static ArrayList<booking> booked = new ArrayList<>(); 
    public static void main(String[] args) {
        FileOfBookings.setUpBooked();
        FileOfBookings.addToBookingList(); // when program starts the file with all the bookings should
                                           // get turned into an ArrayList to be used by the program
        mainMenu();
    }
    public static void mainMenu(){
        while (true){
            System.out.println("What would you like to do:");
            System.out.println("Make a booking     - 1");
            System.out.println("Check on a booking - 2");
            System.out.println("Delete a booking   - 3");
            System.out.println("Exit program       - 0");
            byte userChoice = input.nextByte();
            input.nextLine();
            switch (userChoice){
                case 1:
                    makeBooking();
                    break;
                case 2:
                    int index = checkOnBooking();
                    if (index == -1){
                    System.out.println("No booking with that name and/or booking no.");
                    }else{
                        System.out.println("Your booking: " + (booked.get(index)).toString());
                    }
                    break;
                case 3:
                    deleteBooking();
                    break;
                default:
                    FileOfBookings.addToBookingFile();
                    System.exit(0);
            }
        }
    }
    public static void makeBooking(){
        DecimalFormat df = new DecimalFormat("###.##");
        String board;
        double dayPrice = 0.00000;
        double price = 0.0000;
        String type = "";
        System.out.println("Enter your full name");
        String name = input.nextLine();
        System.out.println("Enter the type of room you want?");
        System.out.println("Single (£50.00)  - 1");
        System.out.println("Double (£75.00)  - 2");
        System.out.println("Family (£105.00) - 3");
        byte userChoice = input.nextByte();
        input.nextLine();
        switch (userChoice){
            case 1:
                type = "Single";
                break;
            case 2:
                type = "Double";
                break;
            case 3:
                type = "Famiy";
                break;
        }
        System.out.println("What board would you like?");
        System.out.println("Self-Catering (£0.00) - 1");
        System.out.println("Half-Board (£10.00)   - 2");
        System.out.println("Full-Board (£20.00)   - 3");
        userChoice = input.nextByte();
        input.nextLine();
        if (type.equals("Single")) {
            dayPrice += 50.00;
        }else if (type.equals("Double")){
            dayPrice += 75.00;
        }else dayPrice +=105.00;
        if (userChoice == 2) {
            board = "Half-Board";
            dayPrice += 10.00;
        }else if (userChoice == 3){
            board = "Full-Board";
            dayPrice += 20.00;
        }else board = "Self-Catering";
        System.out.println("The current price for a day is: £" +dayPrice);
        System.out.println("After the 7th day the price is: £" +(dayPrice*0.8));
        System.out.println("How many days are you planning on staying for?");
        System.out.println("Each day you stay for over 7 days is 20% off!");
        int days = input.nextInt();
        input.nextLine();
        if (days > 7){
            price += dayPrice * 7;
            price += (dayPrice*0.8)*(days-7);
        }else price += dayPrice * days;
        String displayPrice = df.format(price);
        Random randInt = new Random();
        int bookingNumber = randInt.nextInt(99999-10000)+10000;
        System.out.println("Your booking no. is " +bookingNumber);
        booking newBooking = new booking(name, type, board, displayPrice, bookingNumber);
        booked.add(newBooking);
    }
    public static int checkOnBooking(){
        int index = -1;
        System.out.println("Enter the name of the person the booking is in");
        String name = input.nextLine();
        System.out.println("Enter the booking number");
        int bookingNumber = input.nextInt();
        input.nextLine();
        for (int i = 0; i < booked.size(); i++) {
            if ((booked.get(i).getName().equalsIgnoreCase(name))&&(booked.get(i).getBookingNumber()==bookingNumber)) {
                index = i;
                break;
            }
        }return index;
    }
    public static void deleteBooking(){
        int index = checkOnBooking();
        if (index == -1) {
            System.out.println("No booking found in that name and/or with that booking number");
        }else{
            booked.remove(index);
            System.out.println("Booking Succesfully deleted");
        }
    }
}
