package com.company;

import java.util.concurrent.*;

public class Test16 {
    static long a = 0;
    static final Object lock = new Object();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();


        for (int i=0; i<100_000_000; i++) {
            Future<Integer> future = executor.submit(() -> {
                TimeUnit.SECONDS.sleep(5);
                return 1 + 1;
            });

            try {
                Integer integer = future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                System.out.println(e);
            }
        }



        System.out.println("Done");
    }
}
