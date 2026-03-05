package com.taxi.util;

public class FareCalculator {

    public static int calculateFare(int distance) {

        if (distance <= 5)
            return 100;

        return 100 + (distance - 5) * 10;
    }
}