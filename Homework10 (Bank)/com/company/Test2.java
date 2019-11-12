package com.company;

/*
    Разбираемся как же работает синхранизация.
    Пример который я вам показывал заведомо неверный.... Можете в отзыве обо мне написать что я идиот :)
    Правильный пример в Test3
 */
public class Test2 {

    private static Integer a = 0;

    public static void main(String[] args) {

        Thread t1 = new Thread(() ->{
            for (int i = 0; i < 10000; i++) {
                synchronized (a){ // Тут должна быть неизменяемая ССЫЛКА, а ссылка в переменной а постоянной меняется.
                    a += 1;
                }
            }
        });

        Thread t2 = new Thread(() ->{
            for (int i = 0; i < 10000; i++) {
                synchronized (a){ // Тут должна быть неизменяемая ССЫЛКА, а ссылка в переменной а постоянной меняется
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
