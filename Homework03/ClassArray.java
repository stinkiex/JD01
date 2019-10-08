import com.Phones;

public class ClassArray {
    public static void classArray() {
        Phones[]myArray = new Phones[3];
        System.out.println("\n Задание №3: ");
        myArray[0] = new Phones("Apple", "iPhone 6S",2017);
        myArray[1] = new Phones("Samsung", "Galaxy S9",2018);
        myArray[2] = new Phones("Xiaomi", "Redmi-Note 7",2019);
        for(int i=0;i<3;i++) {
            System.out.println("Элемент № "+i+" "+myArray[i]);
        }

    }
}
