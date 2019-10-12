import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Task1 {
    public static void Dates(){
        //Задание 1.1
        Date date1 = new Date();
        Date date2 = new Date();
        System.out.println("date1==date2: "+(date1==date2));
        System.out.println("date1  equals date2: "+date1.equals(date2));

        //Задание 1.2  Прибавить к дате + 5 дней и 1 месяц
        LocalDate futureDate= LocalDate.now().plusDays(5).plusMonths(1);
        System.out.println(LocalDate.now());
        System.out.println((futureDate));

        //Задание 1.3. прибавить к дате 29 февраля 2020 года + 1 год
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, 2020);
        calendar.set(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 29);
        System.out.println(calendar.getTime());
        calendar.add(Calendar.YEAR, 1);
        System.out.println(calendar.getTime());

    }
}
