package com.dkit.gd2.GracieChaudhary.CA2;

import com.dkit.gd2.GracieChaudhary.CA2.Animal;

import java.util.Random;

public class DairyCow extends Animal {

    private final int udders = 4;
    private double udderCapacity;
    private int numTimesMilked;
    private double milkLeft;
    private Random udderCapacityRandom;

    public DairyCow(String name, double udderCapacity) {
        super(name);
        this.udderCapacity = udderCapacityRandom.nextInt(21)+20;
        this.numTimesMilked = 0;
        this.milkLeft = udderCapacity;
        canBeMilked = true;
    }

    public DairyCow(boolean canBeMilked, double udderCapacity) {
        super();
        this.udderCapacity = udderCapacityRandom.nextInt(21)+20;
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
