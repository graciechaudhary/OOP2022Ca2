package com.dkit.gd2.GracieChaudhary.CA2;

import java.util.ArrayList;

public class Herd {

    private String animalType;
    private ArrayList<Animal> listofAnimals;

    public Herd(String animalType, ArrayList<Animal> listofAnimals) {
        this.animalType = animalType;
        this.listofAnimals = listofAnimals;
    }

    public ArrayList<Animal> getListofAnimals() {
        return listofAnimals;
    }

    @Override
    public String toString() {
        return "Herd{" +
                "animalType='" + animalType + '\'' +
                ", listofAnimals=" + listofAnimals +
                '}';
    }
}
