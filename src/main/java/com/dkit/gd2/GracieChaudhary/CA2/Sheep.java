package com.dkit.gd2.GracieChaudhary.CA2;

import com.dkit.gd2.GracieChaudhary.CA2.Animal;

public class Sheep extends Animal {

    private String pedigree;
    private double weight;
    private int age;


    public Sheep(String name, String pedigree, double weight, int age) {
        super(name);
        this.pedigree = pedigree;
        if(weight<40 || weight>=55){
            this.weight = 44;
        }
        else{
            this.weight = weight;
        }
        if(age<1 || age>=6){
            this.age = 3;
        }
        else{
            this.age = age;
        }
        canBeMilked = false;
    }

    public Sheep(String pedigree, double weight, int age) {
        this.pedigree = pedigree;
        if(weight<44 || weight>=55){
            this.weight = 44;
        }
        else{
            this.weight = weight;
        }
        if(age<1 || age>=6){
            this.age = 3;
        }
        else{
            this.age = age;
        }
        canBeMilked = false;
    }


}
