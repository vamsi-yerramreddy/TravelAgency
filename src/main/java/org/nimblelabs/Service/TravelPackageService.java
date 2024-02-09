package org.nimblelabs.Service;

import org.nimblelabs.Model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TravelPackageService {
    private static final Scanner scanner = new Scanner(System.in);
    private static int id =1;
    private TravelPackage travelPackage;

    public TravelPackageService(){
    }
    public List<Destination> createDestinations() {
        // Create activities
        Activity activity1 = new Activity("activity1", "desc_1", 10, 300.0, null);
        Activity activity2 = new Activity("activity2", "desc_2", 15, 250.0, null);
        Activity activity3 = new Activity("activity3", "desc_3", 20, 200.0, null);
        Activity activity4 = new Activity("activity4", "desc_4", 25, 150.0, null);
        Activity activity5 = new Activity("activity5", "desc_5", 30, 100.0, null);

        // Create destinations and add activities to them
        Destination destination1 = new Destination("dest_1", new ArrayList<>(Arrays.asList(activity1, activity2)));
        Destination destination2 = new Destination("dest_2", new ArrayList<>(Arrays.asList(activity3, activity4)));
        Destination destination3 = new Destination("dest_3", new ArrayList<>(Arrays.asList(activity5, activity1)));
        Destination destination4 = new Destination("dest_4", new ArrayList<>(Arrays.asList(activity2, activity3)));
        Destination destination5 = new Destination("dest_5", new ArrayList<>(Arrays.asList(activity4, activity5)));

        // Return the list of destinations
        return Arrays.asList(destination1, destination2, destination3, destination4, destination5);
    }
    public List<TravelPackage> createTravelPackages(List<Destination> destinations) {
        List<TravelPackage> travelPackages = new ArrayList<>();

        // Create travel packages and add destinations to them
        for (int i = 0; i < destinations.size(); i++) {
            TravelPackage travelPackage = new TravelPackage("Package" + (i + 1), 100,
                    new ArrayList<>(),
                    new ArrayList<>(Arrays.asList(destinations.get(i))));
            travelPackages.add(travelPackage);
        }

        return travelPackages;
    }
    public Passenger getPassengerDetails() {
        System.out.println("Please enter your name:");
        String name = scanner.nextLine();

        System.out.println("Please enter your passenger type (GOLD, STANDARD, PREMIUM):");
        String type = scanner.nextLine();

        System.out.println("Please enter your balance:");
        double balance = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over

        return new Passenger(name, PassengerType.valueOf(type), id++, balance, new ArrayList<>());
    }

    public Destination getChosenDestination(List<Destination> destinations) {
        Destination chosenDestination = null;
        do {
            System.out.println("Please enter the destination you would like to visit:");
            String destinationName = scanner.nextLine();
            for (Destination destination : destinations) {
                if (destination.getName().equalsIgnoreCase(destinationName)) {
                    chosenDestination = destination;
                    break;
                }
            }
            if (chosenDestination == null) {
                System.out.println("Invalid destination. Please enter a valid destination.");
            }
        } while (chosenDestination == null);
        return chosenDestination;
    }
    public  Activity getChosenActivity(Destination chosenDestination) {
        Activity chosenActivity = null;
        do {
            System.out.println("*******************");
            System.out.println("Available activities, at the selected destination,are with cost : ");
            for (Activity activity : chosenDestination.getActivityList()) {
                System.out.println(activity.getName() + "  : cost is --->> " + activity.getCost());

            }
            System.out.println("*******************");

            System.out.println("Please enter the name of the activity you would like to sign up for:");

            String activityName = scanner.nextLine();
            for (Activity activity : chosenDestination.getActivityList()) {
                if (activity.getName().equalsIgnoreCase(activityName)) {
                    chosenActivity = activity;
                    break;
                }
            }
            if (chosenActivity == null) {
                System.out.println("Invalid activity. Please enter a valid activity.");
            }
        } while (chosenActivity == null);
        return chosenActivity;
    }

    public TravelPackage processUserInterest(TravelAgency travelAgency, Passenger passenger,Destination chosenDestination, Activity chosenActivity) {
        boolean isSignUpSuccessful = passenger.signUpForActivity(chosenActivity);
        if (isSignUpSuccessful) {
            System.out.println("You have successfully signed up for " + chosenActivity.getName());
        } else {
            System.out.println("Sorry, the activity is full. Please choose another activity.");
        }
        TravelPackage travelPackage = new TravelPackage("package1", 100,
                Arrays.asList(passenger),
                Arrays.asList(chosenDestination));
        travelAgency.getTravelPackageList().add(travelPackage);
        return travelPackage;
    }


}