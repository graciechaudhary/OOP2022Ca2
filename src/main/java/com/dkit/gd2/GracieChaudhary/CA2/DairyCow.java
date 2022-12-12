package com.dkit.gd2.GracieChaudhary.CA2;

import com.dkit.gd2.GracieChaudhary.CA2.Animal;

import java.util.Comparator;
import java.util.Random;

public class DairyCow extends Animal  {

    private final int udders = 4;
    private double udderCapacity;
    private int numTimesMilked;
    private double milkLeft;

    private double milkOutEachTime;
    private Random udderCapacityRandom =  new Random();
    //private String animalType = String.valueOf(TypesOfAnimal.DAIRY_COW);

    public DairyCow(String name) {
        super(name);
        this.udderCapacity = udderCapacityRandom.nextInt(21)+20;
        this.numTimesMilked = 0;
        this.milkLeft = udderCapacity;
        canBeMilked = true;
        milkOutEachTime = (double) udderCapacity/5;
    }

    public DairyCow() {
        super();
        this.udderCapacity = udderCapacityRandom.nextInt(21)+20;
        this.numTimesMilked = 0;
        this.milkLeft = udderCapacity;
        canBeMilked = true;
        milkOutEachTime = (double) udderCapacity/5;
    }

    public void setUdderCapacity(double udderCapacity) {
        if(udderCapacity>=20 && udderCapacity<=40) this.udderCapacity = udderCapacity;
        else System.out.println("Udder capacity not within range, hence not changed.");
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {

        super.setName(name);
    }

    public void setNumTimesMilked(int numTimesMilked) {
        if(numTimesMilked>=0 && numTimesMilked<=5) this.numTimesMilked = numTimesMilked;
    }

    public double getUdderCapacity() {
        return udderCapacity;
    }

    public int getNumTimesMilked() {
        return numTimesMilked;
    }


    public boolean getMilked(){
        if(numTimesMilked<=5){
            numTimesMilked++;
            milkLeft = udderCapacity - numTimesMilked*milkOutEachTime;
            return true;
        }
        else{
            return false;
        }
    }

    public double milk()
    {
        return (double) udderCapacity/5;
    }
    @Override
    public String
    toString() {
        return "DairyCow{" +
                "Dairy Cow Id" + getId() +
                ", Name:" + getName()+
                ", Number of Udders=" + udders +
                ", Udder Capacity=" + udderCapacity +
                ", Number of times milked=" + numTimesMilked +
                ", Milk left=" + milkLeft +
                '}';
    }


}
