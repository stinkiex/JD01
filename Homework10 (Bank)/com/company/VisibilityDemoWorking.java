package com.company;

import java.util.concurrent.TimeUnit;

public class VisibilityDemoWorking {
    private static volatile boolean BOOL = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> { while (BOOL) { } }).start();
        TimeUnit.MILLISECONDS.sleep(500);
        BOOL = false;
    }
}
