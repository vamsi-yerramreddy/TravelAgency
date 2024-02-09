package org.nimblelabs;

import org.nimblelabs.Model.*;
import org.nimblelabs.Service.TravelPackageService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TravelPackageService travelPackageService = new TravelPackageService();
        List<Destination> destinations = travelPackageService.createDestinations();
        List<TravelPackage> travelPackages = travelPackageService.createTravelPackages(destinations);
        TravelAgency travelAgency = new TravelAgency("Nimble Tours", travelPackages);

        travelAgency.printWelcomeMessage(destinations);

        String response = "";
        Scanner scanner = new Scanner(System.in);
            do {
                System.out.println("Are you interested in any of these destinations (yes/no/quit)?");
                response = scanner.nextLine();

                if (response.equalsIgnoreCase("yes")) {
                    Passenger passenger = travelPackageService.getPassengerDetails();
                    Destination chosenDestination = travelPackageService.getChosenDestination(destinations);
                    Activity chosenActivity = travelPackageService.getChosenActivity(chosenDestination);
                    travelPackageService.processUserInterest(travelAgency, passenger,chosenDestination,chosenActivity);
                } else if (response.equalsIgnoreCase("no")) {
                    System.out.println("Thank you for your time. Have a great day!");
                    break;
                } else if (!response.equalsIgnoreCase("quit")) {
                    System.out.println("Invalid response. Please enter 'yes', 'no', or 'quit'.");
                }
            } while (!response.equalsIgnoreCase("quit"));
            travelAgency.printTravelAgencyDetails();
            scanner.close();
        }
    }
