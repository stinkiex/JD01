import java.util.ArrayList;


public class Main {
    /**
     * Домашнее задание (выполнить до 23.10):
     * [1.] Написать свою аннотацию @Version которая будет иметь поле String value для хранения номера версии.
     * Аннотацию можно проставлять на класс и конструктор
     * 2. Написать дженерик класс FilterApplicator который умеет обрабатывать коллекцию ЛЮБЫХ элементов
     * будет иметь следующие методы:
     *  2.1. статический метод filter. У метода filter будет два параметра.
     *  1 коллекция в которой будет происходить фильтрация,
     *  2 класс который реализует алгоритм фильтрации. И будет возвращать результат фильтрации
     *  [2.2.] статический ДЖЕНЕРИК МЕТОД sort который будет принимать 1 параметр
     *  коллекцию элементов реализующих интерфейс Comparable. И будет возвращать результат сортировки
     *
     */

    public static void main(String[] args) {
        ArrayList<Phones> list = new ArrayList();
        int filter1 = 2017;
        Phones phone1 = new Phones("iPhone", "2G", 2004);
        Phones phone2 = new Phones("iPhone", "3G", 2005);
        Phones phone3 = new Phones("Таксофон", "Уличный", 1980);
        Phones phone4 = new Phones("Lenovo", "S2", 2014);
        Phones phone5 = new Phones("HTC", "Wildfire", 2009);
        Phones phone6 = new Phones("HTC", "Desire", 2012);
        Phones phone7 = new Phones("Samsung", "Galaxy A5", 2019);
        Phones phone8 = new Phones("Nokia", "6630", 2002);
        Phones phone9 = new Phones("IPhone", "X", 2017);
        Phones phone10 = new Phones("iPhone", "XS", 2018);
        Phones phone11 = new Phones("iPhone", "XXL", 2029);
        list.add(phone1);
        list.add(phone2);
        list.add(phone3);
        list.add(phone4);
        list.add(phone5);
        list.add(phone6);
        list.add(phone7);
        list.add(phone8);
        list.add(phone9);
        list.add(phone10);
        list.add(phone11);

        System.out.println("Применяем метод сорт:");
        FilterApplicator.sort(list);
        for (Object s:list
             ) {
            System.out.println(s);
        }

        System.out.println("\nА теперь фильтр:");
        FilterApplicator.filter(list, filter1);
        for (Object s:list
        ) {
            System.out.println(s);
        }
    }

}
