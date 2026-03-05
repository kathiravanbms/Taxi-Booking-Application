package com.taxi.model;

public class Booking {

    private int bookingId;
    private int customerId;
    private char from;
    private char to;
    private int pickupTime;
    private int dropTime;
    private int amount;

    public Booking(int bookingId, int customerId, char from, char to,
                   int pickupTime, int dropTime, int amount) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.from = from;
        this.to = to;
        this.pickupTime = pickupTime;
        this.dropTime = dropTime;
        this.amount = amount;
    }

    public int getBookingId() { return bookingId; }
    public int getCustomerId() { return customerId; }
    public char getFrom() { return from; }
    public char getTo() { return to; }
    public int getPickupTime() { return pickupTime; }
    public int getDropTime() { return dropTime; }
    public int getAmount() { return amount; }
}