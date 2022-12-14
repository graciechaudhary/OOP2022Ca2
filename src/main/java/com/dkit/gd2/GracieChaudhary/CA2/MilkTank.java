package com.dkit.gd2.GracieChaudhary.CA2;

public class MilkTank {

    private static int tankId =0;
    private int id;
    private String animalType;
    private double tankCapacity;
    private double currentHolding;

    public MilkTank(String animalType) {
        id = ++tankId;
        this.animalType = animalType;
        tankCapacity = 2000;
        this.currentHolding = 0;
    }

    public MilkTank(String animalType, double customCapacity) {
        id = ++tankId;
        this.animalType = animalType;
        this.tankCapacity = customCapacity;
        this.currentHolding = 0;
    }

    public int getId() {
        return id;
    }

    public void setTankCapacity(double tankCapacity) {
       if(tankCapacity>1000) this.tankCapacity = tankCapacity;
       else System.out.println("Tank capacity not adequate");
    }

    public double getCurrentHolding() {
        return currentHolding;
    }

    public void setCurrentHolding(double currentHolding) {
        if(currentHolding>=0 && currentHolding<tankCapacity) this.currentHolding = currentHolding;
        else System.out.println("Tank capacity not adequate");
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public double getCapacity() {
        return tankCapacity;
    }

    public  double freeSpace(){
        double freeSpaceLeft = tankCapacity-currentHolding;
        return freeSpaceLeft;
    }

    public void addToTank(double amount){
        if(freeSpace()>0){
            currentHolding = tankCapacity;
            System.out.println(freeSpace()+" litres added to tank. "+ (amount-freeSpace()) + " litres not added to tank as tank is full.");
        }
    }

    public double getFromTank(double amount){
        if(amount<=currentHolding){
            if(amount==currentHolding){
                currentHolding=0;
                System.out.println("Milk has been collected. Tank is empty.");
            }

            else{
                currentHolding -= amount;
                System.out.println("Milk has been collected. Tank has "+currentHolding+" litres of milk left.");
            }
        }

        else{
            System.out.println("Tank holds less milk than amount required. Collection unavailable.");
        }
        return currentHolding;
    }

    @Override
    public String toString() {
        return "MilkTank{" +
                "Tank is for: " + animalType +
                ", Tank Capacity: " + tankCapacity +
                ", Current Holding: " + currentHolding +
                '}';
    }
}
