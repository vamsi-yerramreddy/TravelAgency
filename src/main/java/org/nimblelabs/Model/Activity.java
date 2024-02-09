package org.nimblelabs.Model;

public class Activity {
    private String name;
    private String description;
    private int capacity;
    private double cost;
    private Destination destination;

    // Constructor
    public Activity(String name, String description, int capacity, double cost,Destination destination) {
        this.name = name;
        this.description = description;
        this.capacity = capacity;
        this.cost = cost;
        this.destination=destination;
    }

    // Getters and Setters


    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
