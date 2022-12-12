package com.dkit.gd2.GracieChaudhary.CA2;


import java.util.Comparator;
import java.util.Scanner;

public class Shed implements Comparator<Shed> {

    private static int shedId = 0;
    private int id;
    private MilkingMachine myMilkMachine = new MilkingMachine(false);
    private MilkTank myMilkTank;
    private final Scanner keyboard = new Scanner(System.in);

    public Shed(MilkTank newTank){
        id = ++ shedId;
        this.myMilkTank = newTank;
    }

    public MilkTank getMyMilkTank() {
        return myMilkTank;
    }

    public MilkingMachine getMyMilkMachine() {

        return myMilkMachine;
    }

    public boolean installMilkingMachine(MilkingMachine milkingMachine){
        System.out.println("Enter the animal type for which milking machine needs to be set up: ");
        String animalType = keyboard.nextLine();
        myMilkTank.setAnimalType(animalType);
        milkingMachine.setMilkTank(myMilkTank);
        System.out.println("Milking machine has been installed and tank has been set up for "+animalType);
        myMilkMachine = milkingMachine;
        return true;
    } //installs a milking machine and connects it to the shed’s milk tank


    public void milkDairyCow(DairyCow animal) { // milks the animal with the milking machine, the method throws an IllegalStateException if the milking machine is not installed

        if(animal.canBeMilked==true && animal.getMilked()==true){
            if(myMilkMachine!=null){
                    myMilkMachine.milk(animal);
            }
            else{
                throw new IllegalStateException("Milking Machine has not been installed.");
            }
        }

        else{
            System.out.println("This DairyCow cannot be milked.");
        }

    }

    public void milkGoat(Goat animal) { // milks the animal with the milking machine, the method throws an IllegalStateException if the milking machine is not installed

        if(animal.canBeMilked==true && animal.getMilked()==true){
            if(myMilkMachine!=null){
                myMilkMachine.milk(animal);
            }
            else{
                throw new IllegalStateException("Milking Machine has not been installed.");
            }
        }

        else{
            System.out.println("This Goat cannot be milked.");
        }

    }

    public void milkAnimal(Herd myHerd) {
        if(myHerd.getListOfAnimals().get(0).canBeMilked==true){

            try{
                if(installMilkingMachine(myMilkMachine)==true){
                    for(int i=0; i<=myHerd.getListOfAnimals().size();i++){
                        if(myHerd.getListOfAnimals().get(i).canBeMilked){

                        }
                    }
                }
            }

            catch (IllegalStateException e){
                System.out.println("Milking machine has not been installed");
            }
        }

        else{
            System.out.println("This herd cannot be milked.");
        }
    }
    // milks the herd of animals with the milking machine, the method throws an IllegalStateException if the milking machine is not installed


    @Override
    public String toString() {
        return "Shed{" +
                "Shed Id:" + id +
                ",Milking Machine:" + getMyMilkMachine().toString() +
                ", Milk Tank:" +  getMyMilkTank().toString()+
                '}';
    }

    @Override
    public int compare(Shed shed1, Shed shed2) {
        if(shed1.getMyMilkTank().getCurrentHolding()< shed2.getMyMilkTank().getCurrentHolding()){
            return -1;
        }
        else if(shed1.getMyMilkTank().getCurrentHolding()>shed2.getMyMilkTank().getCurrentHolding()){
            return 1;
        }
        else{
            return 0;
        }
    }
}
