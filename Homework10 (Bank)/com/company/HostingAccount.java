package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
    Синхранизация через синхронный метод. Равносилен HostingAccount2
 */
public abstract class HostingAccount {
    protected double balance;
    protected Map<String, AppForHosting> apps = new HashMap<>();

    public HostingAccount() {
        this.balance = 0;
    }

    public HostingAccount(double balance) {
        this.balance = balance;
    }

    /*
        Попытка списать деньги за запланированную нагрузку
     */
    public abstract void use(String name);

    /*
        Расчёт стоимости в зависимости от планируемой нагрузки
     */
    protected final double calcCost(int load){
        if(load > 0){
            if(load < 9){
                return 1;
            } else if (load < 20){
                return 3;
            } else if (load < 100){
                return 7;
            } else {
                return 10;
            }
        }
        return 0;
    }

    public final double getBalance() {
        return balance;
    }

    public final void addApp(String name, AppForHosting app){
        this.apps.put(name, app);
    }

    public final void delApp(String name){
        this.apps.remove(name);
    }
}
