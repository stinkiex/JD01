package com.company;

import java.util.concurrent.CountDownLatch;

public class Test8 {
    static long a = 0;

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(1);

        Thread t1 = new Thread(() -> {
            for (long i = 0; i < 100L; i++) {
                a += 1;
                System.err.println("setter a = " + a);
            }
            latch.countDown();
        });

        Thread t2 = new Thread(() ->{
            while (1 == 1) {
                System.err.println("a = " + a);
                System.err.println("monitoring a = " + a);
            }
        });

        t2.start();
        t1.start();

        try {
            latch.await();
            t2.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }
}
