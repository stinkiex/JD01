package banking;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadInfoBank {

    public List<Bank> readInfo() {
        List<Bank> listBank = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("MyFileBank.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)){
            while (true) {
                Bank bank = (Bank) ois.readObject();
                listBank.add(bank);
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (EOFException e){
            System.out.println("Чтение файла завершено");
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listBank;
    }
}
