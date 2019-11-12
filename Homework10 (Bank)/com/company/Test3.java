package com.company;

/*
    Вот правильный пример.
    Так как мы синхранизируемся в СТАТИЧЕСКОМ методе то мы МОЖЕМ синхранизировать по классу в котором находится этот
    статический метод. Другой вариант в Test4
 */
public class Test3 {
    private static Integer a = 0;

    public static void main(String[] args) {

        Thread t1 = new Thread(() ->{
            for (int i = 0; i < 10000; i++) {
                synchronized (Test3.class){ //Синхранизация по классу
                    a += 1;
                }
            }
        });

        Thread t2 = new Thread(() ->{
            for (int i = 0; i < 10000; i++) {
                synchronized (Test3.class){ //Синхранизация по классу
                    a -= 1;
                }
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
