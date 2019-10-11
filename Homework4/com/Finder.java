package com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.CASE_INSENSITIVE;

public class Finder {
    public static int regFind(String input, String textFile) {
        int a = 0;
        String input2 = " " + input + " | "+ input + ", | "+ input + ". ";
        Pattern regPat = Pattern.compile(input2, Pattern.CASE_INSENSITIVE);
        Matcher regMat = regPat.matcher(textFile);
        while (regMat.find()) {
            a++;
        }
        return a;
    }
}


