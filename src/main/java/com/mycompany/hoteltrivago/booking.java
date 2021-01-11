package com.mycompany.hoteltrivago;
public class booking implements java.io.Serializable {
    private String name;
    private String type;
    private String board;
    private String displayPrice;
    private int bookingNumber;

    public booking(String name, String type, String board, String displayPrice, int bookingNumber) {
        this.name = name;
        this.type = type;
        this.board = board;
        this.displayPrice = displayPrice;
        this.bookingNumber = bookingNumber;
    }
    public String toFile() {
        return name + "," + type + "," + board + "," 
                + displayPrice +"," + bookingNumber;
    }
    @Override
    public String toString() {
        return "name = " + name + ", type = " + type + ", board = " + board + ", price = £" 
                + displayPrice +".00, bookingNumber = " + bookingNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public void setBoard(String board) {
        this.board = board;
    }

    public void setPrice(String displayPrice) {
        this.displayPrice = displayPrice;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
    
    public String getBoard() {
        return board;
    }

    public String getPrice() {
        return displayPrice;
    }

    public int getBookingNumber() {
        return bookingNumber;
    }
    
}
