package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

public class TestStampedLock {
    public static void main(String[] args) {

    ExecutorService executor = Executors.newFixedThreadPool(2);
    StampedLock lock = new StampedLock();
    final long count=0L;

    executor.submit(()->{
        long stamp = lock.readLock();
       try{
           if (count == 0){
               stamp = lock.tryConvertToWriteLock(stamp);
               if (stamp == 0L){
                   System.out.println("Could not convert to write lock");
                   stamp = lock.writeLock();
               }
              // count = 23;
           }
           System.out.println(count);
       } finally {
           lock.unlock(stamp);
       }
    });

    executor.shutdownNow();
    }
}
