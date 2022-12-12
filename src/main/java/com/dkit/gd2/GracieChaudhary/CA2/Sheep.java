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

    public String getPedigree() {
        return pedigree;
    }

    public void setPedigree(String pedigree) {
        this.pedigree = pedigree;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if(weight>=40 && weight<=55)this.weight = weight;
        else System.out.println("Weight not within adequate range.");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>=1 && age<=6) this.age = age;
        else System.out.println("Age not within adequate range.");
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "id: "+ getId()+
                ", name: "+ getName()+
                ", pedigree='" + pedigree + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                '}';
    }
}
