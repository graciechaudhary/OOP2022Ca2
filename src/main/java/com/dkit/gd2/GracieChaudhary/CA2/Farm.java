package com.dkit.gd2.GracieChaudhary.CA2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Farm {

    private static int farmID = 2000;
    private int id;
    private String owner;
    private String name;
    private ArrayList<Herd> herdsInMyFarm;


    private Herd herdofDairyCows = new Herd("Dairy Cow",new ArrayList<Animal>());
    private Herd herdofBeefCows = new Herd("Beef Cow",new ArrayList<Animal>());
    private Herd herdofGoats = new Herd("Goat",new ArrayList<Animal>());
    private Herd herdofSheeps = new Herd("Sheep",new ArrayList<Animal>());
    private ArrayList<Shed> listOfShed;
    private Shed dairyCowShed;
    private Shed goatShed;

    Scanner keyboard = new Scanner(System.in);

    public Farm(){

    }

    public Farm(String owner, String name, ArrayList<Herd> herdsInMyFarm,  ArrayList<Shed> listOfShed) {
        this.owner = owner;
        this.name = name;
        this.herdsInMyFarm = herdsInMyFarm;
        this.listOfShed = listOfShed;
    }

    public Farm(String owner, String name) {
        this.id = ++farmID;
        this.owner = owner;
        this.name = name;
    }



// getters and setters
    public int getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public ArrayList<Herd> getHerdsInMyFarm() {
        return herdsInMyFarm;
    }

    public Herd getHerdofDairyCows() {
        return herdofDairyCows;
    }

    public Herd getHerdofBeefCows() {
        return herdofBeefCows;
    }

    public Herd getHerdofGoats() {
        return herdofGoats;
    }

    public Herd getHerdofSheeps() {
        return herdofSheeps;
    }

    public ArrayList<Shed> getListOfShed() {
        return listOfShed;
    }

    public Shed getDairyCowShed() {
        return dairyCowShed;
    }

    public Shed getGoatShed() {
        return goatShed;
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


// set up
    public void setUpHerdList(){
        herdsInMyFarm= new ArrayList<Herd>();
        herdsInMyFarm.add(herdofDairyCows);
        herdsInMyFarm.add(herdofBeefCows);
        herdsInMyFarm.add(herdofGoats);
        herdsInMyFarm.add(herdofSheeps);
    }

    private void setUpShedList(){
        listOfShed = new ArrayList<Shed>();
        listOfShed.add(dairyCowShed);
        listOfShed.add(goatShed);
    }


// create shed methods
    public void addShed(){
        setUpShedList();
        boolean loop = true;

        while(loop==true){
            System.out.println("Enter type of animal the shed is required for:\n\t1. Dairy Cow\n\t2.Goat");
            int selection = keyboard.nextInt();
            keyboard.nextLine();


            switch (selection) {
                case 1: //dairy tank

                    System.out.println("Enter \n\t1.Custom Capacity for Milk Tank\n\t2.Default Capacity");
                    selection = keyboard.nextInt();
                    keyboard.nextLine();
                    MilkTank newMilkTank = new MilkTank("Dairy Cow");
                    while (loop) { // to customize
                        switch (selection) {
                            case 1:
                                System.out.println("Enter custom capacity.");
                                double customCapacity = keyboard.nextDouble();
                                keyboard.nextLine();
                                newMilkTank.setTankCapacity(customCapacity);
                                loop = false;
                                break;
                            case 2:
                                loop = false;
                                break;
                            default:
                                System.out.println("Wrong input, please enter again");
                                break;
                        }
                    }

                    dairyCowShed = new Shed(newMilkTank);
                    break;
                case 2: //goat tank
                    System.out.println("Enter \n\t1.Custom Capacity for Milk Tank\n\t2.Default Capacity for Milk Tank");
                    selection = keyboard.nextInt();
                    keyboard.nextLine();
                    MilkTank newMilkTankGoat = new MilkTank("Goat");
                    while (loop) {
                        switch (selection) {
                            case 1:
                                System.out.println("Enter custom capacity.");
                                double customCapacity = keyboard.nextDouble();
                                keyboard.nextLine();
                                newMilkTankGoat.setTankCapacity(customCapacity);
                                loop = false;
                                break;
                            case 2:
                                loop = false;
                                break;
                            default:
                                System.out.println("Wrong input, please enter again");
                                break;
                        }
                    }

                    goatShed = new Shed(newMilkTankGoat);
                    break;
                default:
                    System.out.println("Wrong input, please enter again");
                    break;
            }
        }
    }

// create animal methods
    public void addAnimal() throws InterruptedException {
        setUpHerdList();
        System.out.println("Select an animal: ");
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
                        nameACow();
                        break;
                    case BEEF_COW:
                        nameABeefCow();
                        break;
                    case GOAT:
                        nameAGoat();
                        break;
                    case SHEEP:
                        nameASheep();
                        break;
                    case BACK:
                        break;
                    default:
                        System.out.println("Not a valid option. Please try again");
                }
            }
            catch(IllegalArgumentException | ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Selection out of range");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }

    private void printAnimalList() throws InterruptedException {

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
        Thread.sleep(500);
        System.out.println("\t 5. Go Back ");
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

    private void nameACow() throws InterruptedException {
        nameOptionMenu();
        int option = keyboard.nextInt();
        keyboard.nextLine();
        boolean loop = true;//name better
        while(loop){
            switch(option){
                case 1:
                    System.out.println("Enter name: ");
                    String name = keyboard.nextLine();
                    herdofDairyCows.getListOfAnimals().add(new DairyCow(name));
                    loop = false;
                    break;
                case 2:
                    herdofDairyCows.getListOfAnimals().add(new DairyCow());
                    loop = false;
                    break;
                default:
                    System.out.println("Wrong Input. Enter again.\n");
            }
        }
    }

    private void nameABeefCow() throws InterruptedException {
        nameOptionMenu();
        int option = keyboard.nextInt();
        keyboard.nextLine();
        String pedigree;
        int weight,age;
        boolean loop = false;
        while(loop!=true){
            switch(option){
                case 1:
                    System.out.println("Enter name: ");
                    String name = keyboard.nextLine();
                    System.out.println("Enter pedigree: ");
                    pedigree = keyboard.nextLine();
                    System.out.println("Enter weight: ");
                    weight = keyboard.nextInt();
                    keyboard.nextLine();
                    System.out.println("Enter age: ");
                    age = keyboard.nextInt();
                    keyboard.nextLine();

                    herdofBeefCows.getListOfAnimals().add(new BeefCow(name,pedigree,weight,age));
                    loop = true;
                    break;
                case 2:
                    System.out.println("Enter pedigree: ");
                    pedigree = keyboard.nextLine();
                    System.out.println("Enter weight: ");
                    weight = keyboard.nextInt();
                    keyboard.nextLine();
                    System.out.println("Enter age: ");
                    age = keyboard.nextInt();
                    keyboard.nextLine();

                    herdofBeefCows.getListOfAnimals().add(new BeefCow(pedigree,weight,age));
                    loop = true;
                    break;
                default:
                    System.out.println("Wrong Input. Enter again.\n");
            }
        }
    }

    private void nameAGoat() throws InterruptedException {
        nameOptionMenu();
        int option = keyboard.nextInt();
        keyboard.nextLine();
        boolean loop = false;
        while(loop!=true){
            switch(option){
                case 1:
                    System.out.println("Enter name: ");
                    String name = keyboard.nextLine();
                    herdofGoats.getListOfAnimals().add(new Goat(name));
                    loop = true;
                    break;
                case 2:
                    herdofGoats.getListOfAnimals().add(new Goat());
                    loop = true;
                    break;
                default:
                    System.out.println("Wrong Input. Enter again.\n");
            }
        }
    }

    private void nameASheep() throws InterruptedException {
        nameOptionMenu();
        int option = keyboard.nextInt();
        keyboard.nextLine();
        String pedigreeSheep;
        int weightSheep,ageSheep;
        boolean loop = false;
        while(loop!=true){
            switch(option){
                case 1:
                    System.out.println("Enter name: ");
                    String name = keyboard.nextLine();
                    System.out.println("Enter pedigree: ");
                    pedigreeSheep = keyboard.nextLine();
                    System.out.println("Enter weight: ");
                    weightSheep = keyboard.nextInt();
                    keyboard.nextLine();
                    System.out.println("Enter age: ");
                    ageSheep = keyboard.nextInt();
                    keyboard.nextLine();

                    herdofSheeps.getListOfAnimals().add(new Sheep(name,pedigreeSheep,weightSheep,ageSheep));
                    loop = true;
                    break;
                case 2:
                    System.out.println("Enter pedigree: ");
                    pedigreeSheep = keyboard.nextLine();
                    System.out.println("Enter weight: ");
                    weightSheep = keyboard.nextInt();
                    keyboard.nextLine();
                    System.out.println("Enter age: ");
                    ageSheep = keyboard.nextInt();
                    keyboard.nextLine();

                    herdofSheeps.getListOfAnimals().add(new Sheep(pedigreeSheep,weightSheep,ageSheep));
                    loop = true;
                    break;
                default:
                    System.out.println("Wrong Input. Enter again.\n");
            }
        }
    }



// edit amimal methods
    public void editAnimal(){
        System.out.println("Select an animal: ");
        TypesOfAnimal selected = TypesOfAnimal.CONTINUE;

        while(selected != TypesOfAnimal.BACK)
        {
            try
            {
                printAnimalList();

                selected = TypesOfAnimal.values()[Integer.parseInt(keyboard.nextLine().trim())];
                String name = "";
                int find = -1;

                switch(selected)
                {
                    case DAIRY_COW:
                        System.out.println("Enter name of Dairy Cow");
                        name = keyboard.nextLine();
                        find = findDairyCow(name);
                        DairyCow findCow = (DairyCow) herdofDairyCows.getListOfAnimals().get(find);
                        if(find>=0){
                            int selection = printEditMenuDairyCow();
                            callEditMenuDairyCow(selection,findCow,find);
                        }
                        else{
                            System.out.println("This dairy cow wasn't found in the system");
                        }
                        break;
                    case BEEF_COW:
                        System.out.println("Enter name of Beef Cow");
                        name = keyboard.nextLine();
                        find = findBeefCow(name);
                        BeefCow findBeefCow = (BeefCow) herdofBeefCows.getListOfAnimals().get(find);
                        if(find>=0){
                            int selection = printEditMenuBeefCow();
                            callEditMenuBeefCow(selection,findBeefCow,find);
                        }
                        else{
                            System.out.println("This beef cow wasn't found in the system");
                        }

                        break;
                    case GOAT:
                        System.out.println("Enter name of Goat");
                        name = keyboard.nextLine();
                        find = findGoat(name);
                        Goat findGoat = (Goat) herdofGoats.getListOfAnimals().get(find);
                        if(find>=0){
                            int selection = printEditMenuGoat();
                            callEditMenuGoat(selection,findGoat,find);
                        }
                        else{
                            System.out.println("This sheep wasn't found in the system");
                        }
                        break;
                    case SHEEP:
                        System.out.println("Enter name of Sheep");
                        name = keyboard.nextLine();
                        find = findSheep(name);
                        Sheep findSheep = (Sheep) herdofSheeps.getListOfAnimals().get(find);
                        if(find>=0){
                            int selection = printEditMenuSheep();
                            callEditMenuSheep(selection,findSheep,find);
                        }
                        else{
                            System.out.println("This Sheep wasn't found in the system");
                        }
                        break;
                    case BACK:
                        break;
                    default:
                        System.out.println("Not a valid option. Please try again");
                }
            }
            catch(IllegalArgumentException | ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Selection out of range");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
    public int findDairyCow(String name){
        for (int i=0; i<=herdofDairyCows.getListOfAnimals().size();i++){
            if(herdofDairyCows.getListOfAnimals().get(i).getName().equalsIgnoreCase(name)){
                return i;
            }


        }
        return -1;
    }

    public int findBeefCow(String name){
        for (int i=0; i<=herdofBeefCows.getListOfAnimals().size();i++){
            if(herdofBeefCows.getListOfAnimals().get(i).getName().equalsIgnoreCase(name)){
                return i;
            }


        }
        return -1;
    }

    public int findGoat(String name){
        for (int i=0; i<=herdofGoats.getListOfAnimals().size();i++){
            if(herdofGoats.getListOfAnimals().get(i).getName().equalsIgnoreCase(name)){
                return i;
            }


        }
        return -1;
    }

    public int findSheep(String name){
        for (int i=0; i<=herdofSheeps.getListOfAnimals().size();i++){
            if(herdofSheeps.getListOfAnimals().get(i).getName().equalsIgnoreCase(name)){
                return i;
            }


        }
        return -1;
    }

    private int printEditMenuDairyCow(){
        System.out.println("Enter:" +
                "\n\t1. To change name" +
                "\n\t2. To change udder capacity (20-40)" +
                "\n\t3. To change number of times the animal has been milked" +
                "\n\t4. Delete the cow"+
                "\n\t5. Print cow details"+
                "\n\t6.Back");
        int selection = keyboard.nextInt(); keyboard.nextLine();
        return selection;
    }
    private void callEditMenuDairyCow(int selection,  DairyCow cow,int num){
        boolean loop = true;
        while(loop==true){

                switch ((selection)){
                    case 1:
                        System.out.println("Enter new name:");
                        for (int i=0; i<=herdofDairyCows.getListOfAnimals().size();i++){
                            if(herdofDairyCows.getListOfAnimals().get(i).getName().equalsIgnoreCase(keyboard.nextLine())){
                                System.out.println("This name cannot be changed into as it already exists.");
                                break;
                            }
                            else cow.setName(keyboard.nextLine());
                        }
                        cow.setName(keyboard.nextLine());
                        loop = false;
                        break;
                    case 2:
                        System.out.println("Enter new udder capacity:");
                        int newUdderCap = keyboard.nextInt(); keyboard.nextLine();
                        cow.setUdderCapacity(newUdderCap);
                        loop = false;
                        break;
                    case 3:
                        System.out.println("Enter number of times cow has been milked:");
                        int numTimesMilked = keyboard.nextInt(); keyboard.nextLine();
                        cow.setNumTimesMilked(numTimesMilked);
                        loop = false;
                        break;
                    case 4:
                        herdofDairyCows.getListOfAnimals().remove(num);
                        System.out.println("This cow has been killed. This should not have been done :(.");
                        loop = false;
                        break;
                    case 5:
                        System.out.println(cow.toString());
                        break;
                    case 6:
                        loop = false;
                        break;
                    default:
                        System.out.println("Invalid selection, enter again.");
                        break;

                }

        }
    }

    private int printEditMenuGoat(){
        System.out.println("Enter:" +
                "\n\t1. To change name" +
                "\n\t2. Delete the goat"+
                "\n\t3. Print goat details"+
                "\n\t4.Back");
        int selection = keyboard.nextInt(); keyboard.nextLine();
        return selection;
    }

    private void callEditMenuGoat(int selection, Goat goat,int num){
        boolean loop = true;
        while(loop==true){

            switch ((selection)){
                case 1:
                    System.out.println("Enter new name:");
                    for (int i=0; i<=herdofGoats.getListOfAnimals().size();i++){
                        if(herdofGoats.getListOfAnimals().get(i).getName().equalsIgnoreCase(keyboard.nextLine())){
                            System.out.println("This name cannot be changed into as it already exists.");
                            break;
                        }
                        else goat.setName(keyboard.nextLine());
                    }
                    loop = false;
                    break;

                case 4:
                    loop = false;
                    break;
                case 2:
                    herdofGoats.getListOfAnimals().remove(num);
                    System.out.println("This goat has been killed. This should not have been done :(.");
                    loop = false;
                    break;
                case 3:
                    System.out.println(goat.toString());
                    loop = false;
                default:
                    System.out.println("Invalid selection, enter again.");
                    break;

            }

        }
    }

    private int printEditMenuBeefCow(){
        System.out.println("Enter:" +
                "\n\t1. To change name" +
                "\n\t2. To change pedigree" +
                "\n\t3. To change weight" +
                "\n\t4. To change age" +
                "\n\t5. Delete the cow"+
                "\n\t6. Print cow details"+
                "\n\t7.Back");
        int selection = keyboard.nextInt(); keyboard.nextLine();
        return selection;
    }

    private int printEditMenuSheep(){
        System.out.println("Enter:" +
                "\n\t1. To change name" +
                "\n\t2. To change pedigree" +
                "\n\t3. To change weight" +
                "\n\t4. To change age" +
                "\n\t5. Delete the sheep"+
                "\n\t6. Print sheep details"+
                "\n\t7.Back");
        int selection = keyboard.nextInt(); keyboard.nextLine();
        return selection;
    }

    private void callEditMenuBeefCow(int selection, BeefCow cow,int num){
        boolean loop = true;
        while(loop==true){
            switch (selection){
                case 1:
                    System.out.println("Enter new name:");
                    for (int i=0; i<=herdofBeefCows.getListOfAnimals().size();i++){
                        if(herdofBeefCows.getListOfAnimals().get(i).getName().equalsIgnoreCase(keyboard.nextLine())){
                            System.out.println("This name cannot be changed into as it already exists.");
                            break;
                        }
                        else cow.setName(keyboard.nextLine());
                    }
                    loop = false;
                    break;
                case 2:
                    System.out.println("Enter pedigree");
                    cow.setPedigree(keyboard.nextLine());
                    loop = false;
                    break;
                case 4:
                    System.out.println("Enter age");
                    int age = keyboard.nextInt(); keyboard.nextLine();
                    cow.setAge(age);
                    loop = false;
                    break;
                case 3:
                    System.out.println("Enter weight");
                    int weight = keyboard.nextInt(); keyboard.nextLine();
                    cow.setAge(weight);
                    loop = false;
                    break;
                case 5:
                    herdofBeefCows.getListOfAnimals().remove(num);
                    System.out.println("This beef cow has been killed. This should not have been done :(.");
                    loop = false;
                    break;
                case 6:
                    System.out.println(cow.toString());
                    loop = false;
                    break;
                case 7:
                    loop=false;
                    break;
                default:
                    System.out.println("Invalid selection, enter again.");
                    break;
            }
        }
    }

    private void callEditMenuSheep(int selection, Sheep sheep,int num){
        boolean loop = true;
        while(loop==true){
            switch (selection){
                case 1:
                    System.out.println("Enter new name:");
                    for (int i=0; i<=herdofSheeps.getListOfAnimals().size();i++){
                        if(herdofSheeps.getListOfAnimals().get(i).getName().equalsIgnoreCase(keyboard.nextLine())){
                            System.out.println("This name cannot be changed into as it already exists.");
                            break;
                        }
                        else sheep.setName(keyboard.nextLine());
                    }
                    loop = false;
                    break;
                case 2:
                    System.out.println("Enter pedigree");
                    sheep.setPedigree(keyboard.nextLine());
                    loop = false;
                    break;
                case 4:
                    System.out.println("Enter age");
                    int age = keyboard.nextInt(); keyboard.nextLine();
                    sheep.setAge(age);
                    loop = false;
                    break;
                case 3:
                    System.out.println("Enter weight");
                    int weight = keyboard.nextInt(); keyboard.nextLine();
                    sheep.setAge(weight);
                    loop = false;
                    break;
                case 5:
                    herdofBeefCows.getListOfAnimals().remove(num);
                    System.out.println("This sheep has been killed. This should not have been done :(.");
                    loop = false;
                    break;
                case 6:
                    System.out.println(sheep.toString());
                    loop = false;
                    break;
                case 7:
                    loop=false;
                    break;
                default:
                    System.out.println("Invalid selection, enter again.");
                    break;
            }
        }
    }



// edit shed methods
    public void editShed(){
        boolean loop = true;

        while(loop==true){
            System.out.println("Enter type of animal shed to be edited:\n\t1. Dairy Cow\n\t2.Goat");
            int selection = keyboard.nextInt();
            keyboard.nextLine();


            switch (selection) {
                case 1: //dairy cow shed
                     selection = printShedEditMenu();
                     callShedEditMenu(selection,dairyCowShed);
                    break;
                case 2: //goat shed
                    selection = printShedEditMenu();
                    callShedEditMenu(selection,goatShed);
                    break;
                default:
                    System.out.println("Wrong input, please enter again");
                    break;
            }
        }
    }

    private int printShedEditMenu(){
        System.out.println("\nEnter: " +
                "\n\t1. To change Shed's Milk Tank's total capacity" +
                "\n\t2. To change Shed's Milk Tank's current capacity" +
                "\n\t3. To print Shed's details" +
                "\n\t4. Go Back");
        int selection = keyboard.nextInt(); keyboard.nextLine();
        return selection;

    }

    private void callShedEditMenu(int selection,Shed shed){
        boolean loop = true;

        while (loop ==true){
            switch(selection){
                case 1:
                    System.out.println("Enter tank capacity:");
                    double newTankCapacity = keyboard.nextDouble();; keyboard.nextLine();
                    shed.getMyMilkTank().setTankCapacity(newTankCapacity);
                    break;
                case 2:
                    System.out.println("Enter current tank capacity:");
                    double newCurrentTankCapacity = keyboard.nextDouble(); keyboard.nextLine();
                    shed.getMyMilkTank().setCurrentHolding(newCurrentTankCapacity);
                    break;
                case 3:
                    System.out.println(shed.toString());
                    break;
                case 4:
                    loop = false;
                    break;
                default:
                    System.out.println("Wrong input, please enter again");
                    break;
            }
        }
    }

    //compare

    public void compareMenu(){

    }
    private void printcompareMenu(){
        System.out.println("Comapare: " +
                "\n\t1. Milk tanks in Dairy Cow Shed and Cow Shed" +
                "\n\t2. Sort Dairy cow by milk production value" +
                "\n\t3. Sort Goat by milk production value" +
                "\n\t4. Sort Beef Cow by weight" +
                "\n\t5. Sort Beef Cow by age" +
                "\n\t6. Sort Sheep Cow by weight" +
                "\n\t7. Sort Sheep by age" +
                "\n\t8. Back ");


    }

    private void callComapareMenu(){
        boolean loop= true;
        while(loop == true){
            int selection = keyboard.nextInt(); keyboard.nextLine();
            switch(selection){
                case 1:
                    compareShedbyCurrentHolding();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    loop = false;
                    break;
            }
        }
    }
    private void compareShedbyCurrentHolding(){
        int result = dairyCowShed.compare(dairyCowShed,goatShed);
        if(result==-1){
            System.out.println("Milk in goat milk tank is greater than milk in dairy cow milk tank");
        }
        else if(result==1){
            System.out.println("Milk in dairy cow milk tank is greater than milk in goatmilk tank");
        }
        else{
            System.out.println("Milk in both tanks is equal");
        }
    }

    private void sortDairyCows(){

    }

}
