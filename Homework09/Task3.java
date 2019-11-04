import com.BackComparator;
import com.Person;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task3 {

    public static int id = 0;

    /*
            3. Сгенерироват 10000 студентов, вывести top 100 по оценке, осортировать по имени
        4. Записать получившийся результат (топ 100) в файл
        5. В новом классе прочитать этот файл через stream и вывести последние 34 студента
     */
    public static void task3() {
        Stream<Person> studentsStream = Stream.generate(()-> {
            id++;
            String name = String.valueOf(new Random().nextDouble());
            float avgValue = ((float)(Math.round((new Random().nextDouble()*10)*100)))/100;
            return new Person(id, name, avgValue);
        } ).limit(10000)
                .sorted(Comparator.comparing(Person::getAvgValue).reversed())
                .limit(100);

        Map<Integer, Person> students = new TreeMap<>(studentsStream.collect(Collectors.toMap(Person::getId, Person->Person)));

        try {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("top100.txt"));
        students.forEach((k,v)-> {
            try{
                outputStream.writeObject(students.get(k));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }


        FileReader.studReader("top100.txt", 34);

}



}
