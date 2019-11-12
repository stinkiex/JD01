package com.company;


/*
    Тест показывает что если неиспользовать синхронизацию
    каждый раз мы будем получать непредсказуемый результат в переменной a
 */
public class Test1 {

    private static Integer a = 0;

    public static void main(String[] args) {

        Thread t1 = new Thread(() ->{
            for (int i = 0; i < 10000; i++) {
                a += 1;
            }
        });

        Thread t2 = new Thread(() ->{
            for (int i = 0; i < 10000; i++) {
                a -= 1;
            }
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a);
    }
}
