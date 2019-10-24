package com;


import java.util.Collection;
import java.util.List;

public interface IFilter {
    List<Phones> filter(Collection<Phones> list);
}
