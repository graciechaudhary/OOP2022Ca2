package com.dkit.gd2.GracieChaudhary.CA2;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    Scanner keyboard = new Scanner(System.in);
    public Menu(){

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

    private void printBasicMenu() throws InterruptedException {
        Thread.sleep(750);
        System.out.println("--------------------------------------");
        System.out.println("               MAIN MENU");
        System.out.println("--------------------------------------");
        Thread.sleep(500);
        System.out.println("\t 1. Start simulating your farm");
        Thread.sleep(500);
        System.out.println("\t 2. Exit ");
        System.out.println("--------------------------------------");
        Thread.sleep(500);
        System.out.println("Enter: ");
        System.out.println("--------------------------------------");
    }

    private void printStartMenu() throws InterruptedException {
        System.out.println("\nLet's get started with your farm");
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

//    private void printAddMenu() throws InterruptedException {
//        System.out.println("\nEnter: ");
//        Thread.sleep(500);
//        System.out.println("\t 1. Farm");
//        Thread.sleep(500);
//        System.out.println("\t 2. Animal");
//    }

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

    private void callBasicMenu() throws InterruptedException {

        BasicMenu selectedBasicOption = BasicMenu.CONTINUE;

        System.out.println("\nLet's create your farm");
        Thread.sleep(500);
        createFarm();
        Thread.sleep(500);

        while(selectedBasicOption != BasicMenu.QUIT)
        {
            try
            {
                printBasicMenu();
                selectedBasicOption = BasicMenu.values()[Integer.parseInt(keyboard.nextLine().trim())];

                switch(selectedBasicOption)
                {
                    case START:
                        callStartMenu();
                        break;
                    case QUIT:
                        System.out.println("Thank you for visiting the Farm Simulator");
                        break;
                    default:
                        System.out.println("Not a valid option. Please try again");
                }
            }
            catch(IllegalArgumentException e)
            {
                System.out.println("Selection out of range");
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Selection out of range");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private void callStartMenu(){
        StartMenu selectedStartOption = StartMenu.CONTINUE;
        while(selectedStartOption!=StartMenu.BACK){
            try{
                printStartMenu();
                selectedStartOption = StartMenu.values()[Integer.parseInt(keyboard.nextLine().trim())];

                switch(selectedStartOption){
                    case ADD:
                        callCreateMenu();
                        break;
                    case EDIT:
                        callEditMenu();
                        break;
                    case MILK:
                        System.out.println(3);
                        break;
                    case COLLECT_MILK:
                        System.out.println(5);
                        break;
                    case STORE:
                        System.out.println(7);
                        break;
                    case DISPLAY:
                        System.out.println(2);
                        break;
                    case DISPLAY_HERD:
                        System.out.println(6);
                        break;
                    case BACK:
                        System.out.println("\nTaking you back to the main menu, please wait.\n");
                        Thread.sleep(2000);
                        break;
                    default:
                        System.out.println("Not a valid option. Please try again");
                        break;
                }

            }
            catch(IllegalArgumentException e)
            {
                System.out.println("Selection out of range");
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Selection out of range");
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void callCreateMenu(){
        CreateEditMenu selectedCreateOption = CreateEditMenu.CONTINUE;
        while(selectedCreateOption!=CreateEditMenu.BACK){
            try{
                Thread.sleep(750);
                System.out.println("--------------------------------------");
                System.out.println("              CREATE MENU");
                printCreateEditMenu();
                 selectedCreateOption= CreateEditMenu.values()[Integer.parseInt(keyboard.nextLine().trim())];

                 switch (selectedCreateOption){
                     case ANIMAL:
                         break;
                     case SHED:
                         break;
                     case BACK:
                         System.out.println("\nTaking you back to the menu, please wait.\n");
                         Thread.sleep(1000);
                         break;
                     default:
                         System.out.println("Not a valid option. Please try again");
                         break;
                 }
            }
            catch(IllegalArgumentException e)
            {
                System.out.println("Selection out of range");
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Selection out of range");
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    private void callEditMenu(){
        CreateEditMenu selectedCreateOption = CreateEditMenu.CONTINUE;
        while(selectedCreateOption!=CreateEditMenu.BACK){
            try{
                Thread.sleep(750);
                System.out.println("--------------------------------------");
                System.out.println("               EDIT MENU");
                printCreateEditMenu();
                selectedCreateOption= CreateEditMenu.values()[Integer.parseInt(keyboard.nextLine().trim())];

                switch (selectedCreateOption){
                    case ANIMAL:
                        break;
                    case SHED:
                        break;
                    case BACK:
                        System.out.println("\nTaking you back to the menu, please wait.\n");
                        Thread.sleep(1000);
                        break;
                    default:
                        System.out.println("Not a valid option. Please try again");
                        break;
                }
            }
            catch(IllegalArgumentException e)
            {
                System.out.println("Selection out of range");
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Selection out of range");
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }

//    private void callAddMenu(){
//
//    }

    private void createFarm(){
        System.out.println("\tEnter a name for your farm:");
        String name = keyboard.nextLine();
        System.out.println("\tEnter an owner for your farm");
        String owner = keyboard.nextLine();
        Farm myFarm = new Farm(name,owner);
    }
}
