import java.util.Random;

public class Task2 {
    public static void task2() {

        float a= (float)(Math.round((new Random().nextDouble()*100)*10000))/1000;
        System.out.println("Округление с функцией round числа "+a+" = "+Math.round(a)); // Математическое округление

        a= (float)(Math.round((new Random().nextDouble()*100)*10000))/1000;
        System.out.println("Округление с функцией ceil числа "+a+" = "+Math.ceil(a)); // округление в большую сторону

        a= (float)(Math.round((new Random().nextDouble()*100)*10000))/1000;
        System.out.println("Округление с функцией floor числа "+a+" = "+Math.floor(a)); // округление в меньшую сторону

        a= (float)(Math.round((new Random().nextDouble()*100)*10000))/1000;
        System.out.println("Округление с функцией rint числа "+a+" = "+Math.rint(a)); // математическое округление (аналог round)
        System.out.println("\n\n\n");
    }
}
