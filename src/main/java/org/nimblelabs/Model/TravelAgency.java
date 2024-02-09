package org.nimblelabs.Model;

import java.util.List;

public class TravelAgency {
    private String agencyName;
    private List<TravelPackage> travelPackageList;

    public TravelAgency(String agencyName, List<TravelPackage> travelPackageList) {
        this.agencyName = agencyName;
        this.travelPackageList = travelPackageList;
    }

    public  void printTravelAgencyDetails() {
        System.out.println("#######################################################");
        System.out.println("Travel Agency: " + this.getAgencyName());
        System.out.println("#######################################################");
        System.out.println();

        System.out.println("Travel Packages: ");
        for (TravelPackage travelPackage : this.getTravelPackageList()) {
            System.out.println("-------------------------------------------------------");
            travelPackage.printTravelPackage();
            System.out.println("-------------------------------------------------------");
            System.out.println();

            // System.out.println("Destinations in this package: ");
        /*for (Destination destination : travelPackage.getDestinationList()) {
            System.out.println("Destination: " + destination.getName());
            System.out.println("Activities at this destination: ");
            for (Activity activity : destination.getActivityList()) {
                System.out.println("Activity: " + activity.getName() + " and the cost is " + activity.getCost());
            }
        }*/
        }
    }
    public  void printWelcomeMessage(List<Destination> destinations) {
        System.out.println("#######################################################");
        System.out.println("Welcome! Please find the list of destinations and available activities at each destination:");
        System.out.println("#######################################################");
        System.out.println();

        for (Destination destination : destinations) {
            System.out.println("Destination: " + destination.getName());
            for (Activity activity : destination.getActivityList()) {
                System.out.println("Activity: " + activity.getName() + "and the cost is " + activity.getCost());
            }
        }
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public List<TravelPackage> getTravelPackageList() {
        return travelPackageList;
    }

    public void setTravelPackageList(List<TravelPackage> travelPackageList) {
        this.travelPackageList = travelPackageList;
    }
}
