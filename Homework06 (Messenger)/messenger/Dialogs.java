package messenger;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Dialogs {
    private Message[] messages = new Message[0];
    private Message[] delayMessages = new Message[0];

    public void addMessages(Message message){
        this.addMessages(new Message[]{message});
    }

    public void addMessages(Message [] messages){
        if (messages != null && messages.length != 0) {
            this.messages = Arrays.copyOf(this.messages, this.messages.length + messages.length);
            int messagesLength = messages.length;
            for (Message mes : messages) {
                this.messages[this.messages.length - messagesLength--] = mes;
            }
        }
    }
    public void addDelayMessages(Message message){
        this.addDelayMessages(new Message[]{message});
    }

    public void addDelayMessages(Message [] messages){
        if (messages != null && messages.length != 0) {
            this.delayMessages = Arrays.copyOf(this.delayMessages, this.messages.length + messages.length);
            int messagesLength = messages.length;
            for (Message mes : messages) {
                mes.getDate().setTime(mes.getDate().getTime()+300000);
                this.delayMessages[this.delayMessages.length - messagesLength--] = mes;
            }
        }
    }



    public Message[] getMessages() {
        return messages;
    }

    public Message[] getDelayMessages() {
        return delayMessages;
    }

    public static void editMessage(Message message){
        if (message.getUser().getPassword().equals(new Scanner(System.in).nextLine())) {
            if ((new Date().getTime() - message.getDate().getTime()) <= 60000) {
                message.setDate(new Date());
                message.setMessage(new Scanner(System.in).nextLine());
            } else {
                System.out.println("Прошло больше 1 минуты");
            }
        }else System.out.println("Access Denied.");

    }

    public void history(IHistorySaver s){
        Message[]messages = Arrays.copyOf(this.messages, this.messages.length + this.delayMessages.length);
        System.arraycopy(this.delayMessages, 0, messages, this.messages.length, this.delayMessages.length);
        this.messages=messages;
        for (Message message : this.messages) {
            s.println(message.toString());
        }
    }
    public void userHistory(User user){
        System.out.println("История пользователя: "+user.getLogin());
        for (Message message:this.messages){
            if (message.getUser().equals(user)){
                System.out.println(message.toString());
            }
        }

    }



}
