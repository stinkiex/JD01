package com.company;

import java.util.concurrent.*;

public class Test17 {
    static long a = 0;
    static final Object lock = new Object();

    public static void main(String[] args) {
        long count = 0;

        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            count = count + 1 + 1;
        }
        long stopMs = System.currentTimeMillis();

        System.out.println("Done " + count);
        System.out.println("Time " + (stopMs - startMs));
    }
}
