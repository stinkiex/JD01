package com.company;

import java.util.concurrent.CountDownLatch;

public class Test12 {
    static long a = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (long i = 0; i < 100L; i++) {
                a += 1;
                System.err.println("setter a = " + a);
            }
        });
        t1.setDaemon(true);

        Thread t2 = new Thread(() ->{
            Thread currentT = Thread.currentThread();
            while (!currentT.isInterrupted()) {
                System.err.println("monitoring a = " + a);
            }
            while (!currentT.isInterrupted()) {
                System.err.println("monitoring a = " + a);
            }
        });
        t2.setDaemon(true);

        t2.start();
        t1.start();

        System.out.println("Done");
    }
}
