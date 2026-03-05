package com.taxi.model;

import java.util.ArrayList;
import java.util.List;

public class Taxi {

    private int taxiId;
    private char currentLocation;
    private int freeTime;
    private int totalEarnings;
    private List<Booking> bookings;

    public Taxi(int taxiId) {
        this.taxiId = taxiId;
        this.currentLocation = 'A';
        this.freeTime = 0;
        this.totalEarnings = 0;
        this.bookings = new ArrayList<>();
    }

    public int getTaxiId() { return taxiId; }
    public char getCurrentLocation() { return currentLocation; }
    public int getFreeTime() { return freeTime; }
    public int getTotalEarnings() { return totalEarnings; }
    public List<Booking> getBookings() { return bookings; }

    public void setCurrentLocation(char location) {
        this.currentLocation = location;
    }

    public void setFreeTime(int time) {
        this.freeTime = time;
    }

    public void addEarnings(int amount) {
        this.totalEarnings += amount;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }
}