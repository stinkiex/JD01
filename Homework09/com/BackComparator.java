package com;

import java.util.Comparator;

public class BackComparator implements Comparator<Person> {


    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getAvgValue() < o2.getAvgValue()) return 1;
        if (o1.getAvgValue() > o2.getAvgValue()) return -1;
        if (o1.getAvgValue()==o2.getAvgValue()) {
            o1.getName().compareTo(o2.getName());
        }
        return 0;
    }
}
