package org.nimblelabs.Model;

import java.util.List;

public  class TravelPackage {
    private String name;
    private int capacity;
    private List<Passenger> passengerList;
    private List<Destination> destinationList;

    public void printTravelPackage(){
        System.out.println("Name of the package is " + this.getName());
        System.out.println("Itinerary details of the package are " );
       for(Destination destination :this.getDestinationList()){
           System.out.println("Name of the destination "+ destination.getName());
           System.out.println("details of the activities included in the " + destination.getName() +" are") ;
           for(Activity activity : destination.getActivityList()){
               System.out.println("Activity " + activity.getName());
               System.out.println("cost for the activity  -->" + activity.getCost());
               System.out.println("Desc "+ activity.getDescription());
               System.out.println("Available Capacity for the mentioned activity  "+ activity.getCapacity());
           }
       }
    }

    public TravelPackage(String name, int capacity, List<Passenger> passengerList, List<Destination> destinationList) {
        this.name = name;
        this.capacity = capacity;
        this.passengerList = passengerList;
        this.destinationList = destinationList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public List<Destination> getDestinationList() {
        return destinationList;
    }

    public void setDestinationList(List<Destination> destinationList) {
        this.destinationList = destinationList;
    }
}
