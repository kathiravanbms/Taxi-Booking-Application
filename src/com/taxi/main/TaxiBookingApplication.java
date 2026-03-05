package com.taxi.main;

import com.taxi.service.TaxiBookingService;

import java.util.Scanner;

public class TaxiBookingApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TaxiBookingService service = new TaxiBookingService(4);

        while (true) {

            System.out.println("\n1. Book Taxi");
            System.out.println("2. Display Taxi Details");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Customer ID: ");
                    int customerId = sc.nextInt();

                    System.out.print("Pickup Point (A-F): ");
                    char from = sc.next().charAt(0);

                    System.out.print("Drop Point (A-F): ");
                    char to = sc.next().charAt(0);

                    System.out.print("Pickup Time: ");
                    int pickupTime = sc.nextInt();

                    service.bookTaxi(customerId, from, to, pickupTime);
                    break;

                case 2:
                    service.displayTaxiDetails();
                    break;

                case 3:
                    System.exit(0);
            }
        }
        
    }
}