package com.dkit.gd2.GracieChaudhary.CA2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Storage
{

    public static void main(String[] args)
    {
        DairyCow dc1 = new DairyCow("Tina");
        DairyCow dc2 = new DairyCow();
        DairyCow dc3 = new DairyCow("Missy");

        BeefCow bc1 = new BeefCow("Angus",1300,5);
        BeefCow bc2 = new BeefCow("Bee","HereFord", 4500, 4);
        BeefCow bc3 = new BeefCow("Limousin", 300, 9);

        Goat g1 = new Goat();
        Goat g2 = new Goat();
        Goat g3 = new Goat("Mibby");

        Sheep s1 = new Sheep("Oxford", 235, 2);
        Sheep s2 = new Sheep("Mine", "Dorset", 46, 5);
        Sheep s3 = new Sheep("Hampshire", 54, 9);

        ArrayList<Animal> lDiaryCow = new ArrayList<>();
        lDiaryCow.add(dc1);
        lDiaryCow.add(dc2);
        lDiaryCow.add(dc3);

        ArrayList<Animal> lGoat = new ArrayList<>();
        lGoat.add(g1);
        lGoat.add(g2);
        lGoat.add(g3);

        ArrayList<Animal> lBeefCow = new ArrayList<>();
        lBeefCow.add(bc1);
        lBeefCow.add(bc2);
        lBeefCow.add(bc3);

        ArrayList<Animal> lSheep = new ArrayList<>();
        lSheep.add(s1);
        lSheep.add(s2);
        lSheep.add(s3);

        Herd herdofDairyCows = new Herd("Dairy Cow", lDiaryCow);
        Herd herdofBeefCows = new Herd("Beef Cow", lBeefCow);
        Herd herdofGoats = new Herd("Goat", lGoat);
        Herd herdofSheeps = new Herd("Sheep", lSheep);
        ArrayList<Herd> herdsInMyFarm = new ArrayList<>();
        herdsInMyFarm.add(herdofDairyCows);
        herdsInMyFarm.add(herdofBeefCows);
        herdsInMyFarm.add(herdofGoats);
        herdsInMyFarm.add(herdofSheeps);


        MilkTank cow = new MilkTank("Dairy Cow");
        MilkTank goat = new MilkTank("Goat");
        Shed dairyCowShed = new Shed(cow);
        Shed goatShed = new Shed(goat);
        ArrayList<Shed> listOfShed = new ArrayList<>();
        listOfShed.add(dairyCowShed);
        listOfShed.add(goatShed);
        Farm ratnagiri = new Farm("Ratnagiri", "Sonia Chaudhary", herdsInMyFarm,listOfShed);


        storingFarm(ratnagiri);


    }

    public static void storingFarm(Farm ratnagiri){
        try (BufferedWriter farmFile = new BufferedWriter(new FileWriter("StoreFile.txt")))
        {
            farmFile.flush();

            farmFile.write("Farm Id: "+ ratnagiri.getId() +"\nFarm Name: " + ratnagiri.getName() +
                    "\nFarm Owner: "+ ratnagiri.getOwner()+
                    "\n\n\nFarm Shed details: \n\nDairy Cow Shed\n" +
                    ratnagiri.getListOfShed().get(0).toString() +
                    "\n\nGoat Shed: \n"+
                    ratnagiri.getListOfShed().get(1).toString()
            );

            for(Herd herd: ratnagiri.getHerdsInMyFarm()) {
                farmFile.write("\n"+herd.getAnimalType()+" details:\n");
                for(int i=0; i<herd.getListOfAnimals().size();i++){
                    farmFile.write(
                            herd.getListOfAnimals().get(i).toString());
                    farmFile.write("\n");
                }


            }
            System.out.println("Farm data saved");
        } catch (IOException ioe)
        {
            System.out.println("Could not save farm data.");
        }}
}