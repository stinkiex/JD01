package com.company;

import java.util.Random;

public class AppForHosting {
    private Random rnd;

    public AppForHosting() {
        this.rnd = new Random();
    }

    public int plannedUsage(){
        return rnd.nextInt(25);
    }
}
