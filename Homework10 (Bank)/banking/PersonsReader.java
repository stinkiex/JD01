package banking;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonsReader {
    public static List<Person> read(File file) throws IOException, ClassNotFoundException {
        List<Person> personList = new ArrayList<>();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))
                ){
            while (true){
                personList.add((Person) ois.readObject());
            }
        } catch (EOFException e){
            System.out.println("Чтение файла завершено");
        }
        return personList;
    }
}
