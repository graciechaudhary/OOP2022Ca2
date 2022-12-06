package com.dkit.gd2.GracieChaudhary.CA2;

import com.dkit.gd2.GracieChaudhary.CA2.Animal;

import java.util.Random;

public class Goat extends Animal {

    private final int udders = 4;
    private double udderCapacity;
    private int numTimesMilked;
    private double milkLeft;
    private Random udderCapacityRandom;


    public Goat(String name) {
        super(name);
        this.udderCapacity = udderCapacityRandom.nextInt(2)+2;
        this.numTimesMilked = 0;
        this.milkLeft = udderCapacity;
        canBeMilked = true;
    }

    public Goat() {
        this.udderCapacity = udderCapacityRandom.nextInt(2)+2;
        this.numTimesMilked = 0;
        this.milkLeft = udderCapacity;
        canBeMilked = true;
    }

    public double getUdderCapacity() {
        return udderCapacity;
    }


    @Override
    public String
    toString() {
        return "Goat{" +
                " id" + getId() +
                ", name:" + getName()+
                ", udders=" + udders +
                ", udderCapacity=" + udderCapacity +
                ", numTimesMilked=" + numTimesMilked +
                ", milkLeft=" + milkLeft +
                '}';
    }
}
