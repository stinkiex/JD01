import com.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        String arr="";
        if (args[0]!=null){
            for (int i=0; i<args.length;i++){
                arr=arr+args[i];
            }
        }

        Task1.Task1();
        Task2.findH();
        Task2.phones();
        com.WarAndPeace.warAndPeace(arr);




    }
}
