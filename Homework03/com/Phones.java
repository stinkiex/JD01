package com;

public class Phones {
    private String vendor;
    private String model;
    private int year;

    public Phones(String vendor, String model, int year){
        this.vendor=vendor;
        this.model=model;
        this.year=year;
    }

    @Override
    public String toString() {
        return "Phones{" +
                "vendor: '" + vendor + '\'' +
                ", model: '" + model + '\'' +
                ", year: " + year +
                '}';
    }
}
