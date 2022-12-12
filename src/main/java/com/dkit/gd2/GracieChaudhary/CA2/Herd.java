package com.dkit.gd2.GracieChaudhary.CA2;

import java.util.ArrayList;

public class Herd {

    private String animalType;
    private ArrayList<Animal> listOfAnimals;

    public Herd(String animalType, ArrayList<Animal> listOfAnimals) {
        this.animalType = animalType;
        this.listOfAnimals = listOfAnimals;
    }

    public String getAnimalType() {
        return animalType;
    }

    public ArrayList<Animal> getListOfAnimals() {
        return listOfAnimals;
    }

    @Override
    public String toString() {
        return "Herd{" +
                "List of " + getAnimalType() + " :\n" + listOfAnimals +
                '}';
    }


}
