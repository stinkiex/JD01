package messenger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileSaver implements IHistorySaver {

    private final File stream;

    public FileSaver(File stream) {
        this.stream = stream;
    }

    @Override
    public void println(String s) {
        //....
    }

    public void saveFile(Dialogs dialogs) throws IOException {
        ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream(stream));
            oos.writeObject(dialogs);
            oos.close();
    }

    public List<Dialogs> readFile(File file) {
        List<Dialogs> dialogsList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)){
            while (true) {
                Dialogs message = (Dialogs) ois.readObject();
                dialogsList.add(message);
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
        return dialogsList;

    }

}
