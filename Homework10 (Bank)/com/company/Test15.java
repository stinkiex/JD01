package com.company;

public class Test15 {
    static long a = 0;
    static final Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (long i = 0; i < 100L; i++) {
                synchronized (lock) {
                    lock.notify();
                    a += 1;
                    System.err.println("setter a = " + a);
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(() ->{
                while (!Thread.currentThread().isInterrupted()) {
                    synchronized (lock) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            //e.printStackTrace();
                            Thread.currentThread().interrupt();
                        }
                        System.err.println("monitoring a = " + a);
                        lock.notify();
                    }
                }
        });

        t2.start();
        t1.start();


        try {
            t1.join();
            t2.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }
}
