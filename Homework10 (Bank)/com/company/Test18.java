package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Test18 {
    static long a = 0;
    static final Object lock = new Object();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Future[]arr = new Future[100000];
        List<Future<Integer>> futures = new ArrayList<>();
        long count = 0;

        long startMs = System.currentTimeMillis();


        for (int i = 0; i < 100_000; i++) {
            futures.add(executor.submit(() -> {
                TimeUnit.MILLISECONDS.sleep(1);
                return 1 + 1;
            }));
        }

//        for (int i = 0; i<futures.size();i++) {
//            count = count + 1 + 1;
//        }

        for (Future<Integer> future:futures) {
              try {
                count += future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdownNow();

        long stopMs = System.currentTimeMillis();

        System.out.println("Done " + count);
        System.out.println("Time " + (stopMs - startMs));
    }
}
