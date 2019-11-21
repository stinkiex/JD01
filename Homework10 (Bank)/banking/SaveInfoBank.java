package banking;

import javax.imageio.IIOException;
import java.io.*;
import java.util.List;

public class SaveInfoBank {
    public void saveInfo(List<Bank> listBank) {
        try(FileOutputStream fos = new FileOutputStream("MyFileBank");
                ObjectOutputStream oos = new ObjectOutputStream(fos)){
            listBank.forEach(v ->{
                try{
                    oos.writeObject(v);
                }
                catch (IOException e){

                }
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
