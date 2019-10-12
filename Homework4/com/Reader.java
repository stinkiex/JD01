package com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Reader {
    public static String readText(String input) {
        FileInputStream text = null;
        try {
            text = new FileInputStream("D:/WarAndPeace.txt");
            //text = new FileInputStream(input);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error: File Not Found");
        }
        byte[] array = new byte[0];
        try {
            array = new byte[text.available()];
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        try {
            text.read(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String book = new String(array);
        return book;
    }
}
