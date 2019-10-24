package com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FilterYear<T extends Collection<Phones>> implements IFilter {
    int year;

    public FilterYear(int year){
        this.year=year;
    }

    public List<Phones> filter(Collection<Phones> collection){
        List list = new ArrayList();
        for (Phones s:collection) {
            if(s.getYear() == this.year){
                list.add(s);
            }
        }
        if (list.isEmpty()){
            list.add("Ничего не найдено");
            return list;
        } else
        return list;
    }
}