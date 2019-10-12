package com;

public enum Country implements ICountry {
    BELARUS,
    CHINA,
    FRANCE,
    GERMANY,
    ITALY,
    LATVIA,
    MONACO,
    NORWAY,
    POLAND,
    RUSSIA;
    private long km;
    private long human;

    public long getKm() {
        return km;
    }

    public void setKm(long km) {
        this.km = km;
    }

    public long getHuman() {
        return human;
    }

    public void setHuman(long human) {
        this.human = human;
    }

    @Override
    public long getArea() {
        return km;
    }

    @Override
    public long getPeople() {
        return human;
    }

    public void setCountry(long human,long km){
        this.human=human;
        this.km=km;
    }
}
