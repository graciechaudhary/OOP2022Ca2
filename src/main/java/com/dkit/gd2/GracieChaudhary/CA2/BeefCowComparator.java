package com.dkit.gd2.GracieChaudhary.CA2;

import java.util.Comparator;

public class BeefCowComparator implements Comparator<BeefCow> {
    private ProcessBuilder ComparisonChain;

    @Override
    public int compare(BeefCow cow1, BeefCow cow2) {
        if (cow1.getAge() < cow2.getAge()) {
            return -1;
        } else if (cow1.getAge() > cow2.getAge()) {
            return 1;
        } else {
            return 0;
        }
//        return cow1.getWeight().compare(cow2.getWeight());

//        return ComparisonChain.start().compare(cow1.getAge(), cow1.getAge()).compare(cow1.getWeight(),cow2.getWeight()).result();
    }

}
