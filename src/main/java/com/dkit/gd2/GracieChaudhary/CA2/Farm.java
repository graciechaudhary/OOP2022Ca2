package com.dkit.gd2.GracieChaudhary.CA2;

import java.util.ArrayList;

public class Farm {

    private static int farmID = 2000;
    private int id;
    private String owner;
    private String name;
    private ArrayList<Herd> herdsInMyFarm;
    private Herd herdofDairyCows;
    private Herd herdofBeefCows;
    private Herd herdofGoats;
    private Herd herdofSheeps;
    private ArrayList<Shed> listOfShed;
    private Shed dairyCowShed;
    private Shed goatShed;


    public Farm(){

    }

    public Farm(String owner, String name) {
        this.id = ++farmID;
        this.owner = owner;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUpHerdList(){
        herdsInMyFarm.add(herdofDairyCows);
        herdsInMyFarm.add(herdofBeefCows);
        herdsInMyFarm.add(herdofGoats);
        herdsInMyFarm.add(herdofSheeps);
    }

    private void setUpShedList(){
        listOfShed.add(dairyCowShed);
        listOfShed.add(goatShed);
    }

    public void addAnimal(Animal newAnimal){

    }




}
