/*
// package org.nimblelabs;

import org.nimblelabs.Model.*;
import org.nimblelabs.Service.TravelPackageService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MAIN_BKP {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        int id=1;
        Activity activity1 = new Activity("activity1", "desc_1", 10, 300.0, null);
        Activity activity2 = new Activity("activity2", "desc_2", 15, 250.0, null);
        Activity activity3 = new Activity("activity3", "desc_3", 20, 200.0, null);
        Activity activity4 = new Activity("activity4", "desc_4", 25, 150.0, null);
        Activity activity5 = new Activity("activity5", "desc_5", 30, 100.0, null);

        // Create 5 destinations and add activities to them

        Destination destination1 = new Destination("dest_1", new ArrayList<>(Arrays.asList(activity1, activity2)));
        Destination destination2 = new Destination("dest_2", new ArrayList<>(Arrays.asList(activity3, activity4)));
        Destination destination3 = new Destination("dest_3", new ArrayList<>(Arrays.asList(activity5, activity1)));
        Destination destination4 = new Destination("dest_4", new ArrayList<>(Arrays.asList(activity2, activity3)));
        Destination destination5 = new Destination("dest_5", new ArrayList<>(Arrays.asList(activity4, activity5)));

        TravelAgency travelAgency = new TravelAgency("TestAgency", new ArrayList<>());

        // Print welcome message
        System.out.println("Welcome! Please find the list of destinations and available activities at each destination:");

        // Print destinations and activities
        for (Destination destination : Arrays.asList(destination1, destination2, destination3, destination4, destination5)) {
            System.out.println("Destination: " + destination.getName());
            for (Activity activity : destination.getActivityList()) {
                System.out.println("Activity: " + activity.getName() + "and the cost is " + activity.getCost());

            }
        }

        Scanner scanner = new Scanner(System.in);
        String response = "";

        do {
            try {
                System.out.println("Are you interested in any of these destinations (yes/no/quit)?");
                response = scanner.nextLine();

                if (response.equalsIgnoreCase("yes")) {
                    System.out.println("Great! Let's get you signed up. Please enter your details:");
                    String name = "";
                    do {
                        try {
                            System.out.println("Please enter your name:");
                            name = scanner.nextLine();
                            if (name.isEmpty()) {
                                throw new IllegalArgumentException("Name cannot be empty. Please enter a valid name.");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } while (name.isEmpty());

                    String type = "";
                    do {
                        try {
                            System.out.println("Please enter your passenger type (GOLD, PREMIUM, STANDARD):");
                            type = scanner.nextLine();
                            if (!type.equals("GOLD") && !type.equals("PREMIUM") && !type.equals("STANDARD")) {
                                throw new IllegalArgumentException("Invalid passenger type. Please enter 'GOLD', 'PREMIUM', or 'STANDARD'.");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } while (!type.equals("GOLD") && !type.equals("PREMIUM") && !type.equals("STANDARD"));
                    double balance = 0.0;
                    do {
                        try {
                            System.out.println("Please enter your balance:");
                            balance = scanner.nextDouble();
                            if (balance < 0) {
                                throw new IllegalArgumentException("Balance cannot be negative. Please enter a valid balance.");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } while (balance < 0);

                    scanner.nextLine(); // Consume newline left-over
                    String destinationName = "";
                    Destination chosenDestination = null;
                    do {
                        try {
                            System.out.println("Please enter the destination you would like to visit:");
                            destinationName = scanner.nextLine();
                            for (Destination destination : Arrays.asList(destination1, destination2, destination3, destination4, destination5)) {
                                if (destination.getName().equalsIgnoreCase(destinationName)) {
                                    chosenDestination = destination;
                                    break;
                                }
                            }
                            if (chosenDestination == null) {
                                throw new IllegalArgumentException("Invalid destination. Please enter a valid destination.");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } while (chosenDestination == null);

                    // Create a passenger with the details entered
                    Passenger passenger = new Passenger(name, PassengerType.valueOf(type), id, balance, new ArrayList<>());
                    id++;
                    // Ask for signup functionalities
                    String activityName = "";
                    Activity chosenActivity = null;
                    do {
                        try {
                            System.out.println("Please enter the name of the activity you would like to sign up for:");
                            System.out.println("Available activities at the selected destination are below: ");
                            for (Activity activity : chosenDestination.getActivityList()) {
                                System.out.println("Activity: " + activity.getName() + " and the cost is " + activity.getCost());
                            }
                            activityName = scanner.nextLine();
                            for (Activity activity : chosenDestination.getActivityList()) {
                                if (activity.getName().equalsIgnoreCase(activityName)) {
                                    chosenActivity = activity;
                                    break;
                                }
                            }
                            if (chosenActivity == null) {
                                throw new IllegalArgumentException("Invalid activity. Please enter a valid activity at that destination.");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } while (chosenActivity == null);

                    // Sign up the passenger for the chosen activity
                    boolean isSignUpSuccessful= passenger.signUpForActivity(chosenActivity);
                    if(isSignUpSuccessful){
                        System.out.println("You have successfully signed up for " + chosenActivity.getName());
                    }else{
                        System.out.println("Sorry, the activity is full. Please choose another activity.");
                    }
                    passenger.printPassengerDetails();
                    TravelPackage travelPackage=new TravelPackage("package1", 100,
                            new ArrayList<>(Arrays.asList(passenger)),
                            new ArrayList<>(Arrays.asList(chosenDestination)));

                    travelAgency.getTravelPackageList().add(travelPackage);
                    TravelPackageService travelPackageService = new TravelPackageService(travelPackage);
                } else if (response.equalsIgnoreCase("no")) {
                    System.out.println("Thank you for your time. Have a great day!");
                    break;
                } else if (!response.equalsIgnoreCase("quit")) {
                    throw new IllegalArgumentException("Invalid response. Please enter 'yes', 'no', or 'quit'.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!response.equalsIgnoreCase("quit"));

        scanner.close();


       // travelAgency.printTravelAgencyDetails();
        //yes System.out.println("Would you like to sign up for any other activities at the same destination? (yes/no)");




        /**
        // Ask if interested
        System.out.println("Are you interested in any of these destinations (yes/no)");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("yes")) {
            // Ask for passenger details
            System.out.println("Great! Let's get you signed up. Please enter your details:");

            System.out.println("Please enter your name:");
            String name = scanner.nextLine();
            System.out.println("Please enter your passenger type (GOLD, SILVER, BRONZE):");
            String type = scanner.nextLine();
            System.out.println("Please enter your balance:");
            double balance = scanner.nextDouble();
            System.out.println("Please enter the destination you would like to visit:");
            String destination = scanner.nextLine();
            //Check if the user entered the correct destination
            if (destination.equalsIgnoreCase("dest_1")) {
                System.out.println("You have selected " + destination1.getName());

            } else if (destination.equalsIgnoreCase("dest_2")) {
                System.out.println("You have selected " + destination2.getName());
            } else if (destination.equalsIgnoreCase("dest_3")) {
                System.out.println("You have selected " + destination3.getName());
            } else if (destination.equalsIgnoreCase("dest_4")) {
                System.out.println("You have selected " + destination4.getName());
            } else if (destination.equalsIgnoreCase("dest_5")) {
                System.out.println("You have selected " + destination5.getName());
            } else {
                System.out.println("Invalid destination. Please try again.");
            }


            System.out.println("Please enter the activity you would like to sign up for:");
            System.out.println("Available activities at the selected destination are below: ");

            if (destination.equalsIgnoreCase("dest_1")) {
                for (Activity activity : destination1.getActivityList()) {
                    System.out.println("Activity: " + activity.getName());
                }
            } else if (destination.equalsIgnoreCase("dest_2")) {
                for (Activity activity : destination2.getActivityList()) {
                    System.out.println("Activity: " + activity.getName());
                }
            } else if (destination.equalsIgnoreCase("dest_3")) {
                for (Activity activity : destination3.getActivityList()) {
                    System.out.println("Activity: " + activity.getName());
                }
            } else if (destination.equalsIgnoreCase("dest_4")) {
                for (Activity activity : destination4.getActivityList()) {
                    System.out.println("Activity: " + activity.getName());
                }
            } else if (destination.equalsIgnoreCase("dest_5")) {
                for (Activity activity : destination5.getActivityList()) {
                    System.out.println("Activity: " + activity.getName());
                }
            }

            System.out.println("Kindly enter the correct activity name: ");
            String activityName = scanner.nextLine();
            System.out.println("You have successfully signed up for " + activityName);
            System.out.println("Would you like to sign up for any other activities at the same destination? (yes/no)");
            response = scanner.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                System.out.println("Please enter the name of the activity you would like to sign up for:");
                String activityName2 = scanner.nextLine();
                System.out.println("You have successfully signed up for " + activityName2);
            }
            //create a passenger with the details entered and sign them up for the activity
            Passenger passenger = new Passenger(name, PassengerType.valueOf(type), id, balance, new ArrayList<>());
            id++;

            for (Destination dest : Arrays.asList(destination1, destination2, destination3, destination4, destination5)) {
                for (Activity activity : dest.getActivityList()) {
                    if (activity.getName().equalsIgnoreCase(activityName)) {
                        passenger.signUpForActivity(activity);
                        System.out.println("You have successfully signed up for " + activityName);
                        break;
                    }
                }
            }

        }else{
            System.out.println("Thank you for your time. Have a great day!");
        }**/

/**    }
}**/
        /**   Passenger passenger1 = new Passenger("passenger1", PassengerType.GOLD, 1, 2000.0,Arrays.asList(activity1,activity2));
           Passenger passenger2 = new Passenger("passenger2", PassengerType.STANDARD, 2, 1500.0, new ArrayList<>());
           Passenger passenger3 = new Passenger("passenger3", PassengerType.PREMIUM, 3, 1000.0, new ArrayList<>());
           Passenger passenger4 = new Passenger("passenger4", PassengerType.GOLD, 4, 2500.0, new ArrayList<>());
           //Create a travel package and add destinations and passengers to it
           TravelPackage travelPackage = new TravelPackage("package1", 100,
                   new ArrayList<>(Arrays.asList(passenger1, passenger2, passenger3, passenger4)),
                   new ArrayList<>(Arrays.asList(destination1, destination2, destination3, destination4, destination5)));

           TravelAgency travelAgency = new TravelAgency("agency1", new ArrayList<>(Arrays.asList(travelPackage)));
           TravelPackageService travelPackageService = new TravelPackageService(travelPackage);

           travelPackageService.printItinerary();
           travelPackageService.printPassengerList();
           travelPackageService.printAvailableActivities();**/