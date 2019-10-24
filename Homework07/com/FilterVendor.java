package com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FilterVendor<T extends Collection<Phones>> implements IFilter {
    T collection;
    String vendor;

    public FilterVendor(String vendor) {
        this.vendor = vendor;
    }

    public List<Phones> filter(Collection<Phones> collection) {
        List list = new ArrayList();
        for (Phones s : collection) {
            if (s.getVendor().equals(this.vendor)) {
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

