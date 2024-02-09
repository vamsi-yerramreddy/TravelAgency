package org.nimblelabs.Model;

import java.util.List;

public class Passenger {
    private String name;
    private PassengerType type;
    private int number;
    private double balance;
    private List<Activity> activities;

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public boolean signUpForActivity(Activity activity){

        if(activity.getCapacity()>0) {
            double cost = activity.getCost();
            if (type.equals(PassengerType.PREMIUM)) {
                this.activities.add(activity);
                return true;
            } else if (type.equals(PassengerType.GOLD)) {
                if (balance >= (0.9)*cost) {
                    balance -= cost;
                    activity.setCapacity(activity.getCapacity() - 1);
                    this.activities.add(activity);
                    return true;
                }else{
                    throw new IllegalArgumentException("Insufficient balance");
                }
            }else if(type.equals(PassengerType.STANDARD)){
                if(balance >=cost){
                    balance-=cost;
                    activity.setCapacity(activity.getCapacity()-1);
                    this.activities.add(activity);
                    return true;
                }else{
                    throw new IllegalArgumentException("Insufficient balance");
                }
            }
        }
        return false;


    }

    public void printPassengerDetails(){
        //print the passenger class;
        System.out.println("Passenger Name :" + this.getName() );
        System.out.println("Passenger number : " + this.getNumber());
        System.out.println("Passenger type : " + this.getType());
        System.out.println("Available balance " + this.getBalance());
        System.out.println("Activities signed up for : ");
        for(Activity activity : this.getActivities()){
            System.out.println("Activity name : " + activity.getName());
            System.out.println("Activity cost : " + activity.getCost());
            System.out.println("Activity description : " + activity.getDescription());
            System.out.println("");
        }
    }
    public Passenger(String name, PassengerType type, int number, double balance,List<Activity> activityList) {
        this.name = name;
        this.type = type;
        this.number = number;
        this.balance= balance;
        this.activities=activityList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PassengerType getType() {
        return type;
    }

    public void setType(PassengerType type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public double getBalance(){
        return  balance;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }
}
