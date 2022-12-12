package com.dkit.gd2.GracieChaudhary.CA2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Loading {

    public static void main(String[] args)
    {

        Farm newFarm;
        File inputFile = new File("FarmRatnagirii.txt");


        try (Scanner in = new Scanner(inputFile))
        {

            while (in.hasNextLine())
            {
                String line = in.nextLine();
                String [] data = line.split(" ");
                String name = data[0];
                String surname = data[1];
                String fname = in.nextLine();

                String line1 = in.nextLine();
                String[] d1 = line1.split(",");
                int dairyshedId = Integer.parseInt(d1[0]);
                boolean milkMachineCow = Boolean.parseBoolean(d1[1]);
                String milkTank = d1[2];
                String dairyCow = d1[3];
                int cowtankcapacity = Integer.parseInt(d1[4]);
                int cowtankcurrent = Integer.parseInt(d1[5]);

                String line2 = in.nextLine();
                String[] d2 = line1.split(",");
                int goatshedId = Integer.parseInt(d2[0]);
                boolean milkMachinegoat = Boolean.parseBoolean(d2[1]);
                String gmilkTank = d2[2];
                String goat = d2[3];
                int gtankcapacity = Integer.parseInt(d2[4]);
                int gtankcurrent = Integer.parseInt(d2[5]);

                //newFarm= new Farm(name+" "+surname,fname,);


            }

        } catch (FileNotFoundException exception)
        {
            System.out.println("FileNotFoundException caught." + exception);
        } catch (InputMismatchException exception)
        {
            System.out.println("InputMismatchexception caught." + exception);
        }


    }
}
