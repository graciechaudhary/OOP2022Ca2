package com.dkit.gd2.GracieChaudhary.CA2;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    private Farm newFarm;
    private Storage store;
    Scanner keyboard = new Scanner(System.in);

    public Menu() {

    }

    public Farm getFarm() {
        return newFarm;
    }

    private void createFarm() {
        System.out.println("\tEnter a name for your farm:");
        String name = keyboard.nextLine();
        System.out.println("\tEnter an owner for your farm");
        String owner = keyboard.nextLine();
        newFarm = new Farm(name, owner);
    }


    public void displayFarm() {
        System.out.println("---------------------------------------------");
        System.out.println("Farm Id: " + newFarm.getId());
        System.out.println("Farm Name: " + newFarm.getName());
        System.out.println("Farm Owner: " + newFarm.getOwner());
        System.out.println("---------------------------------------------");
        System.out.println("Sheds in the farm: ");
        for (int i = 0; i <= newFarm.getListOfShed().size(); i++) {
            newFarm.getListOfShed().get(i).toString();
        }
        System.out.println("---------------------------------------------");

        for (int i = 0; i <= newFarm.getHerdsInMyFarm().size(); i++) {
            System.out.println("Herd of " + newFarm.getHerdsInMyFarm().get(i).getAnimalType());
            newFarm.getHerdsInMyFarm().get(i).toString();
        }

        System.out.println("---------------------------------------------");
    }

    public void callMenu() throws IOException, InterruptedException {

        System.out.println("\nWelcome to Farm Simulator");
        Thread.sleep(500);
        System.out.println("\tCreated by - Gracie Chaudhary");
        Thread.sleep(500);
        System.out.println("\nPress enter to continue");
        System.in.read();

        callBasicMenu();
    }

    private void callBasicMenu() throws InterruptedException {

        BasicMenu selectedBasicOption = BasicMenu.CONTINUE;


        while (selectedBasicOption != BasicMenu.QUIT) {
            try {
                printBasicMenu();
                selectedBasicOption = BasicMenu.values()[Integer.parseInt(keyboard.nextLine().trim())];

                switch (selectedBasicOption) {
                    case START:
                        System.out.println("\nLet's get started with your farm");
                        System.out.println("\nLet's create your farm");
                        Thread.sleep(500);
                        createFarm();
                        Thread.sleep(500);
                        callStartMenu();
                        break;
                    case LOAD:
                        System.out.println("Loading your farm from the file");
                        Thread.sleep(500);
                        callStartMenu();
                        break;
                    case QUIT:
                        System.out.println("Thank you for visiting the Farm Simulator");
                        break;
                    default:
                        System.out.println("Not a valid option. Please try again");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Selection out of range");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Selection out of range");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private void callStartMenu() {
        StartMenu selectedStartOption = StartMenu.CONTINUE;
        while (selectedStartOption != StartMenu.BACK) {
            try {
                printStartMenu();
                selectedStartOption = StartMenu.values()[Integer.parseInt(keyboard.nextLine().trim())];

                switch (selectedStartOption) {
                    case ADD:
                        callCreateMenu();
                        break;
                    case EDIT:
                        callEditMenu();
                        break;
                    case MILK:
                        milkAnimals();
                        break;
                    case COLLECT_MILK:
                        collectMilk();
                        break;
                    case STORE:
                        store.storingFarm(newFarm);
                        break;

                    case DISPLAY:
                        displayFarm();
                        break;
                    case DISPLAY_HERD:
                        System.out.println(6);
                        break;
                    case BACK:
                        System.out.println("\nTaking you back to the main menu, please wait. You will lose all of your progress.\n");
                        Thread.sleep(2000);
                        break;
                    default:
                        System.out.println("Not a valid option. Please try again");
                        break;
                }


            } catch (IllegalArgumentException e) {
                System.out.println("Selection out of range");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Selection out of range");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void callCreateMenu() {
        CreateEditMenu selectedCreateOption = CreateEditMenu.CONTINUE;
        while (selectedCreateOption != CreateEditMenu.BACK) {
            try {
                Thread.sleep(750);
                System.out.println("--------------------------------------");
                System.out.println("              CREATE MENU");
                printCreateEditMenu();
                selectedCreateOption = CreateEditMenu.values()[Integer.parseInt(keyboard.nextLine().trim())];

                switch (selectedCreateOption) {
                    case ANIMAL:
                        newFarm.addAnimal();
                        break;
                    case SHED:
                        newFarm.addShed();
                        break;
                    case BACK:
                        System.out.println("\nTaking you back to the menu, please wait.\n");
                        Thread.sleep(1000);
                        break;
                    default:
                        System.out.println("Not a valid option. Please try again");
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Selection out of range");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Selection out of range");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void callEditMenu() {
        CreateEditMenu selectedCreateOption = CreateEditMenu.CONTINUE;
        while (selectedCreateOption != CreateEditMenu.BACK) {
            try {
                Thread.sleep(750);
                System.out.println("--------------------------------------");
                System.out.println("               EDIT MENU");
                printCreateEditMenu();
                selectedCreateOption = CreateEditMenu.values()[Integer.parseInt(keyboard.nextLine().trim())];

                switch (selectedCreateOption) {
                    case ANIMAL:
                        newFarm.editAnimal();
                        break;
                    case SHED:
                        newFarm.editShed();
                        break;
                    case BACK:
                        System.out.println("\nTaking you back to the menu, please wait.\n");
                        Thread.sleep(1000);
                        break;
                    default:
                        System.out.println("Not a valid option. Please try again");
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Selection out of range");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Selection out of range");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void printBasicMenu() throws InterruptedException {
        Thread.sleep(750);
        System.out.println("--------------------------------------");
        System.out.println("               MAIN MENU");
        System.out.println("--------------------------------------");
        Thread.sleep(500);
        System.out.println("\t 1. Start simulating your farm");
        Thread.sleep(500);
        System.out.println("\t 2. Load pre-existing Farm ");
        Thread.sleep(500);
        System.out.println("\t 3. Exit ");
        System.out.println("--------------------------------------");
        Thread.sleep(500);
        System.out.println("Enter: ");
        System.out.println("--------------------------------------");
    }

    private void printStartMenu() throws InterruptedException {

        Thread.sleep(750);
        System.out.println("--------------------------------------");
        System.out.println("            SIMULATION MENU");
        System.out.println("--------------------------------------");
        Thread.sleep(500);
        System.out.println("\t 1. Create");
        Thread.sleep(500);
        System.out.println("\t 2. Edit");
        Thread.sleep(500);
        System.out.println("\t 3. Milk your Animals");
        Thread.sleep(500);
        System.out.println("\t 4. Collect Milk from your Farm");
        Thread.sleep(500);
        System.out.println("\t 5. Store your Farm");

        Thread.sleep(500);
        System.out.println("\t 6. Display your creations");
        Thread.sleep(500);
        System.out.println("\t 7. Display your different herds");
        Thread.sleep(500);
        System.out.println("\t 8. Back to Menu");
        System.out.println("--------------------------------------");
        //Thread.sleep(500);
        System.out.println("Enter: ");
        System.out.println("--------------------------------------");

    }

    private void printCreateEditMenu() throws InterruptedException {


        System.out.println("--------------------------------------");
        System.out.println("\t 1. Animal");
        Thread.sleep(500);
        System.out.println("\t 2. Shed");
        Thread.sleep(500);
        System.out.println("\t 3. Back");
        System.out.println("--------------------------------------");
        Thread.sleep(500);
        System.out.println("Enter: ");
        System.out.println("--------------------------------------");
    }

    public void milkAnimals() throws InterruptedException {
        printMilkMenu();
        callMilkMenu();
    }

    private void printMilkMenu() throws InterruptedException {
        System.out.println("--------------------------------------");
        System.out.println("\t 1. Cow");
        Thread.sleep(500);
        System.out.println("\t 2. Goat");
        Thread.sleep(500);
        System.out.println("\t 3. Back");
        System.out.println("--------------------------------------");
        Thread.sleep(500);
        System.out.println("Enter: ");
        System.out.println("--------------------------------------");
    }

    private void callMilkMenu(){
        boolean loop =true;

        while(loop ==true){
            int selection = keyboard.nextInt(); keyboard.nextLine();
            switch (selection){
                case 1:
                    System.out.println("Enter name of cow");
                    String name = keyboard.nextLine();
                    int n = newFarm.findDairyCow(name);
                    if(n>=0) newFarm.getDairyCowShed().milkDairyCow((DairyCow) newFarm.getHerdofDairyCows().getListOfAnimals().get(n));
                    else System.out.println("Cow not found");
                    break;
                case 2:
                    System.out.println("Enter name of goat");
                    String nameg = keyboard.nextLine();
                    int ng = newFarm.findGoat(nameg);
                    if(ng>=0) newFarm.getDairyCowShed().milkGoat((Goat) newFarm.getHerdofGoats().getListOfAnimals().get(ng));
                    else System.out.println("Goat not found");
                    break;
                case 3:
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid Input. Enter again.");
                    break;

            }
        }
    }

    private void collectMilk(){
        System.out.println("Dairy Cow milk tank has " + newFarm.getDairyCowShed().getMyMilkTank().getCurrentHolding());
        newFarm.getDairyCowShed().getMyMilkTank().setCurrentHolding(0);
        System.out.println("The tank has been emptied");
        System.out.println("Goat milk tank has " + newFarm.getGoatShed().getMyMilkTank().getCurrentHolding());
        newFarm.getGoatShed().getMyMilkTank().setCurrentHolding(0);
        System.out.println("The tank has been emptied");
    }

}


