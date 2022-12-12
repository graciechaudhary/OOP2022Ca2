package com.dkit.gd2.GracieChaudhary.CA2;

import java.util.Comparator;

public class DairyCowComparator implements Comparator<DairyCow> {
    @Override
    public int compare(DairyCow cow1, DairyCow cow2) {
        if(cow1.getUdderCapacity()<cow2.getUdderCapacity() ){
            return -1;
        }
        else if(cow1.getUdderCapacity()>cow2.getUdderCapacity()){
            return 1;
        }
        else{
            return 0;
        }
    }
}
