package com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FilterModel<T extends Collection<Phones>> implements IFilter {
    T collection;
    String model;

    public FilterModel(String model) {
        this.model = model;
    }

    public List<Phones> filter(Collection<Phones> collection) {
        List list = new ArrayList();
        for (Phones s : collection) {
            if (s.getModel().equals(this.model)) {
                list.add(s);
            }
        }
        if (list.isEmpty()) {
            list.add("Ничего не найдено");
            return list;
        } else
            return list;
    }
}
