package com.dkit.gd2.GracieChaudhary.CA2;

import java.util.ArrayList;
import java.util.Random;

public class Animal {

    private static int animalID = 0;
    private int id;
    private String name;
    public boolean canBeMilked;

    private ArrayList<String> names = new ArrayList<>();

    private String[] namesList = {"Daniel", "Isha", "Sunflower", "Henry", "Tom", "Mugsy", "Precious", "Snuffles", "Teddy", "Justice", "Sophie", "Cody",
                    "Mollie", "Buddy", "Carbon", "Sky","Jerry", "Peanut", "Loki","Motu","Helipcopter", "Max", "Oreo", "Luna", "Pooh", "Milo", "Spike",
                    "Dobie", "Sassie", "Banjo"};
    private Random nameSelector;

    public Animal(String name) {
        this.id = ++animalID;
        this.name = name;
    }

    public Animal() {
        this.id = ++animalID;
        this.name = randomNameSelector();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCanBeMilked() {
        return canBeMilked;
    }

    public void setCanBeMilked(boolean canBeMilked) {
        this.canBeMilked = canBeMilked;
    }

    public void setRandomNameList(){
        for(int i=0; i<namesList.length;i++){
            names.add(namesList[i]);
        }
    }

    public String randomNameSelector(){
        nameSelector = new Random();
        setRandomNameList();
        int randomInteger = nameSelector.nextInt(names.size());
        String randomName = names.get(randomInteger);
        names.remove(randomInteger);
        return randomName;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", canBeMilked=" + canBeMilked +
                '}';
    }

}
