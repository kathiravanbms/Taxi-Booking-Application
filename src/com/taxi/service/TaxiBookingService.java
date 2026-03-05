package com.taxi.service;

import com.taxi.model.Booking;
import com.taxi.model.Taxi;
import com.taxi.util.FareCalculator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaxiBookingService {

    private List<Taxi> taxis;
    private int bookingCounter;

    public TaxiBookingService(int taxiCount) {

        taxis = new ArrayList<>();
        bookingCounter = 1;

        for (int i = 1; i <= taxiCount; i++) {
            taxis.add(new Taxi(i));
        }
    }

    public void bookTaxi(int customerId, char from, char to, int pickupTime) {

        Taxi allocatedTaxi = findTaxi(from, pickupTime);

        if (allocatedTaxi == null) {
            System.out.println("Booking Rejected. No taxi available.");
            return;
        }

        int distance = Math.abs(to - from) * 15;
        int travelTime = Math.abs(to - from); 

        int amount = FareCalculator.calculateFare(distance);
        int dropTime = pickupTime + travelTime;

        Booking booking = new Booking(
                bookingCounter++,
                customerId,
                from,
                to,
                pickupTime,
                dropTime,
                amount
        );

        allocatedTaxi.addBooking(booking);
        allocatedTaxi.addEarnings(amount);
        allocatedTaxi.setCurrentLocation(to);
        allocatedTaxi.setFreeTime(dropTime);

        System.out.println("Taxi-" + allocatedTaxi.getTaxiId() + " is allotted.");
    }

    private Taxi findTaxi(char pickupPoint, int pickupTime) {

        List<Taxi> freeTaxis = new ArrayList<>();

        for (Taxi taxi : taxis) {
            if (taxi.getFreeTime() <= pickupTime) {
                freeTaxis.add(taxi);
            }
        }

        if (freeTaxis.isEmpty())
            return null;

        return freeTaxis.stream()
                .min(Comparator
                        .comparingInt((Taxi t) -> Math.abs(t.getCurrentLocation() - pickupPoint))
                        .thenComparingInt(Taxi::getTotalEarnings))
                .orElse(null);
    }

    public void displayTaxiDetails() {

        for (Taxi taxi : taxis) {

            if (taxi.getBookings().isEmpty())
                continue;

            System.out.println("\nTaxi-" + taxi.getTaxiId() +
                    " Total Earnings: Rs. " + taxi.getTotalEarnings());

            System.out.println("BookingID CustomerID From To Pickup Drop Amount");

            for (Booking b : taxi.getBookings()) {
                System.out.printf("%-9d %-10d %-4c %-3c %-6d %-4d %-6d\n",
                        b.getBookingId(),
                        b.getCustomerId(),
                        b.getFrom(),
                        b.getTo(),
                        b.getPickupTime(),
                        b.getDropTime(),
                        b.getAmount());
            }
        }
    }
}