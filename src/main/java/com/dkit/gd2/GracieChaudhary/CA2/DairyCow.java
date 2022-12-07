package com.dkit.gd2.GracieChaudhary.CA2;

import com.dkit.gd2.GracieChaudhary.CA2.Animal;

import java.util.Random;

public class DairyCow extends Animal {

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

    @Override
    public String
    toString() {
        return "DairyCow{" +
                " id" + getId() +
                ", name:" + getName()+
                ", udders=" + udders +
                ", udderCapacity=" + udderCapacity +
                ", numTimesMilked=" + numTimesMilked +
                ", milkLeft=" + milkLeft +
                '}';
    }
}
