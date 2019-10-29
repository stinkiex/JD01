import com.*;
import exceptions.MinorAgeException;
import exceptions.WrongAgeException;

public class Task2 {
    public static void task2() throws WrongAgeException, MinorAgeException {
        try{
            BuyBeer buyer1 = new BuyBeer("Стасик", 26);
            BuyBeer buyer2 = new BuyBeer("Толян", 16);
            BuyBeer buyer3 = new BuyBeer("Колян", -6);
            People buyer4 = new BuyBeer("Вадик", -1);

        }catch(WrongAgeException|MinorAgeException e){
            System.out.println(e.getMessage());
        }
    }
}
