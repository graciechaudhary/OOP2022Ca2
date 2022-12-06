package com.dkit.gd2.GracieChaudhary.CA2;

import com.dkit.gd2.GracieChaudhary.CA2.Animal;

public class BeefCow extends Animal {

    private String pedigree;
    private double weight;
    private int age;


    public BeefCow(String name, String pedigree, double weight, int age) {
        super(name);
        this.pedigree = pedigree;
        if(weight<800 || weight>=2000){
            this.weight = 900;
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

    public BeefCow(String pedigree, double weight, int age) {
        this.pedigree = pedigree;
        if(weight<800 || weight>=2000){
            this.weight = 900;
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
