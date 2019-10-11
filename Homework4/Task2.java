import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task2 {
    public static void findH(){
        //Задание 2.1:
        String a1 = "Я люблю JAVA люблю";

        a1.contains("я");
        a1.endsWith("JAVA");
        a1.toLowerCase().concat("я");
        int я = a1.indexOf("Я");
        a1.substring(я+1).indexOf("я");
        System.out.println(я);
        System.out.println("20934".matches("-?[0-9]*"));

        String str10 = "Test            string for split";
        String[] words = str10.split(" +");
        for (String word : words){
            System.out.println(word + " ");
        }
        String str11 = "TEst multyple    spaces";
        System.out.println(str11.replaceAll(" +", " "));
        System.out.println(a1.matches("[h]*"));
        System.out.println(a1.matches("[h]+"));
        System.out.println(a1.matches("[h]?"));
    }

    public static void phones(){
        String phonesPattern = "(\\+[1-9\\)\\(]{7,12})";
        Pattern pattern = Pattern.compile(phonesPattern);
        String[] phones = new String[]{
                "+375(29)6494806", "375291115582", "+375291115585",
                "+375(29)5553628", "80293338092",
                "+375(29)444-99-02", "+7(129)444-99-02"
        };

        for (String tel: phones
        ) {
            System.out.println(tel);
            Matcher matcher = pattern.matcher(tel);
            System.out.println(matcher.find());

        }
    }
}
