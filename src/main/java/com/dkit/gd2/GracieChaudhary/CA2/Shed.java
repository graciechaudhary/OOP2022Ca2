package com.dkit.gd2.GracieChaudhary.CA2;


import java.util.Scanner;

public class Shed {

    private static int shedId = 0;
    private int id;
    private MilkingMachine myMilkMachine;
    private MilkTank myMilkTank;
    private final Scanner keyboard = new Scanner(System.in);

    public Shed(MilkTank newTank){
        id = ++ shedId;
        this.myMilkTank = newTank;
    }

    public MilkTank getMyMilkTank() {
        return myMilkTank;
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


    public void milkAnimal(DairyCow animal) { // milks the animal with the milking machine, the method throws an IllegalStateException if the milking machine is not installed

        if(animal.canBeMilked==true && animal.getMilked()==true){
            if(myMilkMachine!=null){
                    myMilkMachine.milk();
            }
            else{
                throw new IllegalStateException("Milking Machine has not been installed.");
            }
        }

        else{
            System.out.println("This animal cannot be milked.");
        }

    }

    public void milkAnimal(Herd myHerd) {
        if(myHerd.getListofAnimals().get(0).canBeMilked==true){

            try{
//                if(installMilkingMachine()==true){
//
//                }
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
}
