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
        String book = Reader.readText(arr);

        //System.out.println(book);
        System.out.println("Слово война :"+Finder.regFind("война", book));
        System.out.println("Союз и :"+Finder.regFind("и", book));
        System.out.println("Слово мир :"+Finder.regFind("мир", book));
        System.out.println("Искомое слово "+arr+ " встречается "+Finder.regFind(arr, book));







    }
}
