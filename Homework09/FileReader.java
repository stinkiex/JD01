import com.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileReader {
    public static void studReader(String filename, int count) {
        boolean flag = true;
        List<Person> list = new ArrayList<>();
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename));
            Person person;
            while ((person = (Person)inputStream.readObject())!=null) {
                    list.add(person);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (int i=(list.size()-count-1); i<list.size();i++){
            System.out.println(list.get(i));
        }

    }
}

