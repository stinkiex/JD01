package com.company;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/*
    Синхранизация через синхронный метод. Равносилен HostingAccountSafe2
 */
public class HostingAccountSafe1 extends HostingAccount {

    private Random rnd = new Random();

    public HostingAccountSafe1() {
    }

    public HostingAccountSafe1(double balance) {
        super(balance);
    }

    /*
            Попытка списать деньги за запланированную нагрузку
         */
    public synchronized void use(String name){
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
