import dto.*;

public class Task {
    public static void sdvig() {
        int a = 1, b = 999, c = 2;
        int num1 = a + (int) (Math.random() * b);
        int num2 = a + (int) (Math.random() * c);
        int num3 = num1 << num2;
        int num4 = num1 >> num2;
        int num5 = -(num1);
        int num6 = -(num2);
        int num7 = num5 << num6;
        int num8 = num5 >> num6;
        double num9 = a + Math.random() * b;
        double num10 = a + Math.random() * c;
//    double  num11=num9>>num10; ошибка. нельзя применить операции сдвига к дробным числам.
        System.out.println("Задание №1:");
        System.out.println("1-ое случайное число: " + num1 + " В двоичной системе: " + Integer.toBinaryString(num1));
        System.out.println("2-ое случайное число: " + num2 + " В двоичной системе: " + Integer.toBinaryString(num2));
        System.out.println("При сдвиге влево получится: " + Integer.toBinaryString(num3));
        System.out.println("При сдвиге вправо получится: " + Integer.toBinaryString(num4));
        System.out.println("1-ое отрицательное число: " + num5 + " В двоичной системе: " + Integer.toBinaryString(num5));
        System.out.println("2-ое отрицательное число: " + num6 + " В двоичной системе: " + Integer.toBinaryString(num6));
        System.out.println("При сдвиге влево получится: " + Integer.toBinaryString(num7));
        System.out.println("При сдвиге вправо получится: " + Integer.toBinaryString(num8));
        // Пример использования if:
        System.out.println("\nЗадание 3:");
        if (num1 > num2) {
            System.out.println(num1 + " больше чем " + num2);
        } else if (num1 < num2) {
            System.out.println(num1 + "меньше чем" + num2);
        } else {
            System.out.println(num1 + "равно" + num2);
        }
        // Тернарный оператор:
        String someText = num1 == num2 ? num1 + " равно " + num2 : num1 + " не равно " + num2;
        System.out.println(someText);
    }

public static void computers() {
    IComputer c1 = new AsusComputer(10, 1008);
    IComputer c2 = new AcerComputer(1024, 80000);
//    AsusComputer c3 = (AsusComputer)c2;
    if (c2 instanceof AsusComputer) {
        AsusComputer c3 = (AsusComputer) c2;
        } else{
        System.out.println("Ошибка ClassCastException";}
}


public static void prioritety() {
        // Приоритетность операторов:
        int a5 = 5, a2 = 2, a8 = 8, a7 = 7, a20 = 20, a68 = 68, a22 = 22, a6 = 6, a3 = 3, a12 = 12, a119 = 119;
        int itog1, itog2, itog3, itog4, itog5, itog6, itog7;
        boolean itog8, itog9, i2 = true, i3 = false; //false
        itog1 = a5 + a2 / a8; //5 сначала деление, затем сложение
        itog2 = (a5 + a2) / a8; //0 сначала сложение в скобках, затем деление
        itog3 = (a5 + a2++) / a8; //0 сначала постфиксное сложение, потомсложение хатем деление
        itog4 = (a5 + a2++) / --a8; //1 сначала постфиксное сложение, затем префиксное вычитание, потом сложение
        itog5 = (a5 * a2 >> a2++) / --a8; //0 сначала постфиксное сложение, затем префиксное вычитание, после умножение и сдвиг
        itog6 = (a5 + a7 > a20 ? a68 : a22 * a2 >> a2++) / --a8; //0 -
//    itog7=(a1+a4>a5?a6=>a6:a7*a2>>a2++)/--a3; //возникнет ошибка
        itog8 = a6 - a2 > a3 && a12 * a12 <= a119; //false
        itog9 = i2 && i3; // false
        System.out.println("Пункт 5.1 " + itog1);
        System.out.println("Пункт 5.2 " + itog2);
        System.out.println("Пункт 5.3 " + itog3);
        System.out.println("Пункт 5.4 " + itog4);
        System.out.println("Пункт 5.5 " + itog5);
        System.out.println("Пункт 5.6 " + itog6);
//    System.out.println("Пункт 5.7 "+itog7);
        System.out.println("Пункт 5.8 " + itog8);
        System.out.println("Пункт 5.9 " + itog9);
    }
}
