package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/*
    Синхранизация через синхронный метод. Равносилен HostingAccount2
 */
public class HostingAccountUnSafe extends HostingAccount {

    private Random rnd = new Random();

    public HostingAccountUnSafe() {
    }

    public HostingAccountUnSafe(double balance) {
        super(balance);
    }

    public void use(String name){
        double cost = calcCost(this.apps.get(name).plannedUsage());

        if(balance > cost){
            try {
                TimeUnit.MILLISECONDS.sleep(rnd.nextInt(1));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            balance -= cost;
        } else {
            if(balance <= 0 ){
                throw new IllegalStateException("Деньги кончились");
            }
            throw new IllegalStateException("Денег не хватает");
        }
    }
}
