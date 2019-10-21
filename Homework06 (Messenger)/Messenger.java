import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import messenger.*;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Messenger {
    /**
     * Мессенджер
     * [1.] Вводить ник:
     * [1.1] Должен быть только латинскими буквами
     * [1.2] Должен быть не меньше 5 символов
     * [1.3] Не должен начинаться с цифры
     * [1.4] Не должен содержать #,!,\
     * [2.] Сообщения вводятся через консоль
     * [3]. Сообщения хранятся в массиве
     * 4. Можно отредактировать своё сообщение если оно не старше минуты
     * [5.] Можно писать отложенные сообщения
     **/


    public static User getValidUser() {
        String login, password;
        Scanner sc = new Scanner(System.in);
        User user = null;
        boolean flag = false;
        do {
            System.out.println("Enter your login: ");
            login = sc.nextLine();
            System.out.println("Enter your password: ");
            password = sc.nextLine();
            user = new User(login, password);
            flag = ValidateUser.checkUser(user);
            if (!flag) {
                System.out.println("Invalid user");
            }
        } while (!flag);
        return user;
    }


    public static void main(String[] args) {
        System.out.println("ИНСТРУКЦИЯ:\n 1.Для отложенного сообщения в начале сообщения напишите DELAY ");
        System.out.println("2.Для остановки ввода сообщений напишите STOP");
        System.out.println("3.Для редактирования сообщений напишите EDIT");

        User user1 = getValidUser();
        User user2 = getValidUser();
        //User user9 = new User("Ашот", "pass");

        Dialogs dialogs = new Dialogs();
        Scanner sc = new Scanner(System.in);
        long time = 0;
        long minutes = 0;
        Date date2 = new Date();
        for (int i = 1; i < 3; ) {
            if (i == 1) System.out.println(user1.getLogin() + " сообщение ");
            else {System.out.println(user2.getLogin() + " сообщение ");}
            String text = new Scanner(System.in).nextLine();
            if (text.contains("STOP")) i = 3;

            if (text.contains("DELAY") && i == 1) {
                System.out.println("Через сколько минут отправить сообщение"); //1 минута = 60_000секунд
                minutes = sc.nextLong();
                time = (date2.getTime() + (minutes * 60000));
                String regex = "DELAY";
                text = text.replaceAll(regex, "");
                dialogs.addDelayMessages(new Message(text, user1, new Date(time)));
                i = 2;
            } else if (i == 1) {
                dialogs.addMessages(new Message(text, user1, new Date()));
                i = 2;
            }

            if (text.contains("DELAY") && i == 2) {
                System.out.println("Через сколько минут отправить сообщение"); //1 минута = 60_000секунд
                minutes = sc.nextLong();
                time = (date2.getTime() + (minutes * 60000));
                String regex = "DELAY";
                text = text.replaceAll(regex, "");
                dialogs.addDelayMessages(new Message(text, user2, new Date()));
                i = 1;
            } else if (i == 2) {
                dialogs.addMessages(new Message(text, user2, new Date()));
                i = 1;
            } else if (i == 3) break;

            if (text.contains("EDIT")) {
                Message edited = dialogs.getMessages()[dialogs.getMessages().length - 1];
                Dialogs.editMessage(edited);
            }

        }


//        for (Message message:dialogs.getMessages()) {
//            System.out.println(message);
//            }

        dialogs.history(new ConsoleSaver(System.out));
        dialogs.history(new FileSaver(null));
        dialogs.userHistory(user1);
    }
}
