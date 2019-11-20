import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import messenger.*;

import java.io.File;
import java.io.IOException;
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
        User curUser = user2;
        Dialogs dialogs = new Dialogs();
        Scanner sc = new Scanner(System.in);
        long time = 0;
        long minutes = 0;
        Date date2 = new Date();
        File file = new File("History.txt");
        FileSaver fs = new FileSaver(file);

        fs.readFile(file);

        for (int i = 1; i < 3; ) {
            if (curUser.equals(user1)){
                curUser=user2;
            }else {
                curUser=user1;
            }
            System.out.println(curUser.getLogin() + " сообщение ");
            String text = new Scanner(System.in).nextLine();

            if (text.contains("DELAY")) {
                System.out.println("Через сколько минут отправить сообщение"); //1 минута = 60_000секунд
                minutes = sc.nextLong();
                time = (date2.getTime() + (minutes * 60000));
                String regex = "DELAY";
                text = text.replaceAll(regex, "");
                dialogs.addDelayMessages(new Message(text, curUser, new Date(time)));
            }else {
                dialogs.addMessages(new Message(text, curUser, new Date()));
            }

            if (text.contains("EDIT")) {
                Message edited = dialogs.getMessages()[dialogs.getMessages().length - 1];
                Dialogs.editMessage(edited);
            }

            if (text.contains("STOP")) break;
        }


//        for (Message message:dialogs.getMessages()) {
//            System.out.println(message);
//            }

        dialogs.history(new ConsoleSaver(System.out));
        dialogs.history(new FileSaver(null));
        dialogs.userHistory(user1);
        try {
            fs.saveFile(dialogs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
