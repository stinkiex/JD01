package com.company;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/*
    Синхранизация через синхронайз блок. Равносилен HostingAccountSafe1
 */
public class HostingAccountSafe2 extends HostingAccount{
    private Random rnd = new Random();

    public HostingAccountSafe2() {
    }

    public HostingAccountSafe2(double balance) {
        super(balance);
    }

    public void use(String name){
        double cost = calcCost(this.apps.get(name).plannedUsage());

        synchronized(this){
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
}
