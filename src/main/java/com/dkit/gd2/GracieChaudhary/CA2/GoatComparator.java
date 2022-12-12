package com.dkit.gd2.GracieChaudhary.CA2;

import java.util.Comparator;

public class GoatComparator implements Comparator<Goat> {
    @Override
    public int compare(Goat goat1,Goat goat2) {
        if(goat1.getUdderCapacity()<goat2.getUdderCapacity() ){
            return -1;
        }
        else if(goat1.getUdderCapacity()>goat2.getUdderCapacity()){
            return 1;
        }
        else{
            return 0;
        }
    }
}
