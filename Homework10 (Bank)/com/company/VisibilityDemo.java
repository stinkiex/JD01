package com.company;

import java.util.concurrent.TimeUnit;

public class VisibilityDemo {
    public static void main(String[] args) {
        Worker worker = new Worker();
        Thread workerThread = new Thread(worker);
        workerThread.start();


        Thread stopperThread = new Thread(new Stopper(worker));
        stopperThread.start();

        try {
            workerThread.join();
            stopperThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }

    private static class Worker implements Runnable{

        public boolean shouldStop = false;

        @Override
        public void run() {
            while (!shouldStop){
                try{
                    TimeUnit.MILLISECONDS.sleep(10);
                    System.out.println("NotStop");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Stopper implements Runnable{
        private Worker worker;

        public Stopper(Worker worker) {
            this.worker = worker;
        }

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            worker.shouldStop = true;
        }
    }
}
