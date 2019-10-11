package com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.CASE_INSENSITIVE;


public class WarAndPeace {

    public static void warAndPeace (String arr) {
        System.out.println("\n\n\nВойна и мир!!! ");
        FileInputStream  text= null;
        try {
            //text = new FileInputStream("D:/WarAndPeace.txt");
            text = new FileInputStream(arr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error: File Not Found");
        }
        byte[]array = new byte[0];
        try {
            array = new byte[text.available()];
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            text.read(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String book = new String(array);
        String[]bookArr = book.split(" +");
        //System.out.println(book);

        Pattern warPat = Pattern.compile(" война | война, | война.",Pattern.CASE_INSENSITIVE);
        Pattern andPat = Pattern.compile(" и | и, ", CASE_INSENSITIVE);
        Pattern peacePat = Pattern.compile(" мир | мир, | мир.", CASE_INSENSITIVE);
        Matcher warMatch = warPat.matcher(book);
        Matcher andMatch = andPat.matcher(book);
        Matcher peaceMatch = peacePat.matcher(book);


        int wordWar=0, wordAnd=0, wordPeace=0;

        while (warMatch.find()){
            wordWar++;
        }
        while (andMatch.find()){
            wordAnd++;
        }
        while (peaceMatch.find()){
            wordPeace++;
        }

        System.out.println("Слово \"Война\" встречается "+wordWar+" раз");
        System.out.println("Союз \"И\" встречается "+wordAnd+" раз");
        System.out.println("Слово \"Мир\" встречается "+wordPeace+" раз");

    }
}
