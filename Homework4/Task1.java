import java.util.ArrayList;
import java.util.Scanner;

public class Task1
{
    public static void Task1() {
        //Задание 1.1:
        System.out.print("Задание 1.1:\n");
        String str1 = "Мама мыла раму";
        String str2 = "Мама" + " мыла " + "раму";
        System.out.println("str1 == str2: " + str1==str2+ "\n");
        System.out.println("str1 == str2: " + str1.intern()==str2.intern()+ "\n");
        System.out.println("str1 == str2: " + str1.equals(str2)+ "\n");

        //Задание 1.2:
        System.out.print("\nЗадание 1.2:\n");
        int lenStr1 = str1.length();
        char[] str1Array = new char[lenStr1];
        for (int i = 0; i < lenStr1; i++) {
            str1Array[i] = str1.charAt(i);
            System.out.print(str1Array[i] + "\t");
        }

        //Задание 1.3:
        ArrayList<String> list = new ArrayList<String>(0);
        String stopChar = "~";
        String str3;
        System.out.println("\nВведите ваш текст, по оканчание ввода нажмите ~");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; ; i++) {
            str3 = sc.nextLine();
            list.add(str3);
            if (str3.equals(stopChar)) {
                sc.close();
                break;
            }
        }
        int len=list.size();
        System.out.println("Размер " +len);
        String list2=String.join(", ", list);
        System.out.println(list2);

        //Задание 1.4:
        String sourceStr = "012312";
        Long l1 = Long.valueOf(sourceStr).longValue(); //Первый способ
        Long l2 = Long.parseLong(sourceStr); // Второй способ
        System.out.println("Первый способ: "+l1+"\nВторой способ: "+l2);


    }
}

