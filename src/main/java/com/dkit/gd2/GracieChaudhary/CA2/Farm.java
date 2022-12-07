package com.dkit.gd2.GracieChaudhary.CA2;

import java.util.ArrayList;
import java.util.Scanner;

public class Farm {

    private static int farmID = 2000;
    private int id;
    private String owner;
    private String name;
    private ArrayList<Herd> herdsInMyFarm;
    private Herd herdofDairyCows = new Herd("Dairy Cows",  new ArrayList<Animal>());
    private Herd herdofBeefCows = new Herd("Dairy Cows",  new ArrayList<Animal>());
    private Herd herdofGoats = new Herd("Dairy Cows",  new ArrayList<Animal>());
    private Herd herdofSheeps = new Herd("Dairy Cows",  new ArrayList<Animal>());
    private ArrayList<Shed> listOfShed;
    private Shed dairyCowShed;
    private Shed goatShed;

    Scanner keyboard = new Scanner(System.in);

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

    public void addAnimal() throws InterruptedException {

        System.out.println("Select an animal: ");

        Thread.sleep(500);



        TypesOfAnimal selected = TypesOfAnimal.CONTINUE;

        while(selected != TypesOfAnimal.BACK)
        {
            try
            {
                printAnimalList();

                selected = TypesOfAnimal.values()[Integer.parseInt(keyboard.nextLine().trim())];

                switch(selected)
                {
                    case DAIRY_COW:
                          nameOptionMenu();
                          int option = keyboard.nextInt();

                          boolean loop = false;
                          while(loop!=true){
                              switch(option){
                                  case 1:
                                      System.out.println("Enter name: ");
                                      String name = keyboard.nextLine();
                                      herdofDairyCows.getListofAnimals().add(new DairyCow(name));
                                      loop = true;
                                      break;
                                  case 2:
                                      herdofDairyCows.getListofAnimals().add(new DairyCow());
                                      loop = true;
                                      break;
                                  default:
                                      System.out.println("Wrong Input. Enter again.\n");
                              }
                          }
                        break;
                    case BEEF_COW:
                        nameOptionMenu();
                        int option2 = keyboard.nextInt();
                        String pedigree;
                        int weight,age;
                        boolean loop2 = false;
                        while(loop2!=true){
                            switch(option2){
                                case 1:
                                    System.out.println("Enter name: ");
                                    String name = keyboard.nextLine();
                                    System.out.println("Enter pedigree: ");
                                    pedigree = keyboard.nextLine();
                                    System.out.println("Enter weight: ");
                                    weight = keyboard.nextInt();
                                    System.out.println("Enter age: ");
                                    age = keyboard.nextInt();

                                    herdofBeefCows.getListofAnimals().add(new BeefCow(name,pedigree,weight,age));
                                    loop2 = true;
                                    break;
                                case 2:
                                    System.out.println("Enter pedigree: ");
                                    pedigree = keyboard.nextLine();
                                    System.out.println("Enter weight: ");
                                    weight = keyboard.nextInt();
                                    System.out.println("Enter age: ");
                                    age = keyboard.nextInt();

                                    herdofBeefCows.getListofAnimals().add(new BeefCow(pedigree,weight,age));
                                    loop2 = true;
                                    break;
                                default:
                                    System.out.println("Wrong Input. Enter again.\n");
                            }
                        }
                        break;
                    case GOAT:
                        nameOptionMenu();
                        int option3 = keyboard.nextInt();

                        boolean loop3 = false;
                        while(loop3!=true){
                            switch(option3){
                                case 1:
                                    System.out.println("Enter name: ");
                                    String name = keyboard.nextLine();
                                    herdofGoats.getListofAnimals().add(new Goat(name));
                                    loop = true;
                                    break;
                                case 2:
                                    herdofGoats.getListofAnimals().add(new Goat());
                                    loop = true;
                                    break;
                                default:
                                    System.out.println("Wrong Input. Enter again.\n");
                            }
                        }
                        break;
                    case SHEEP:
                        nameOptionMenu();
                        int option4 = keyboard.nextInt();
                        String pedigreeSheep;
                        int weightSheep,ageSheep;
                        boolean loop4 = false;
                        while(loop4!=true){
                            switch(option4){
                                case 1:
                                    System.out.println("Enter name: ");
                                    String name = keyboard.nextLine();
                                    System.out.println("Enter pedigree: ");
                                    pedigreeSheep = keyboard.nextLine();
                                    System.out.println("Enter weight: ");
                                    weightSheep = keyboard.nextInt();
                                    System.out.println("Enter age: ");
                                    ageSheep = keyboard.nextInt();

                                    herdofSheeps.getListofAnimals().add(new BeefCow(name,pedigreeSheep,weightSheep,ageSheep));
                                    loop2 = true;
                                    break;
                                case 2:
                                    System.out.println("Enter pedigree: ");
                                    pedigreeSheep = keyboard.nextLine();
                                    System.out.println("Enter weight: ");
                                    weightSheep = keyboard.nextInt();
                                    System.out.println("Enter age: ");
                                    ageSheep = keyboard.nextInt();

                                    herdofSheeps.getListofAnimals().add(new Sheep(pedigreeSheep,weightSheep,ageSheep));
                                    loop2 = true;
                                    break;
                                default:
                                    System.out.println("Wrong Input. Enter again.\n");
                            }
                        }
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

    private void printAnimalList() throws InterruptedException {
        Thread.sleep(750);
        System.out.println("\n--------------------------------------");
        System.out.println("            TYPES OF ANIMALS");
        System.out.println("--------------------------------------");
        Thread.sleep(500);
        System.out.println("\t 1. Dairy Cow");
        Thread.sleep(500);
        System.out.println("\t 2. Beef Cow ");
        Thread.sleep(500);
        System.out.println("\t 3. Goat");
        Thread.sleep(500);
        System.out.println("\t 4. Sheep ");
        System.out.println("--------------------------------------");
        Thread.sleep(500);
        System.out.println("Enter: ");
        System.out.println("--------------------------------------");
    }

    private void nameOptionMenu() throws InterruptedException {
        Thread.sleep(750);
        System.out.println("--------------------------------------");
        System.out.println("Would you like to");
        System.out.println("--------------------------------------");
        Thread.sleep(500);
        System.out.println("1. Select the name");
        Thread.sleep(500);
        System.out.println("2. Generate a random name");
        Thread.sleep(500);
        System.out.println("Enter: ");
        System.out.println("--------------------------------------");
    }

    private void nameOptionWorking(){

    }




}
