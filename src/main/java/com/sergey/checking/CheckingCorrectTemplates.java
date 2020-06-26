package com.sergey.checking;

import com.sergey.exception.WrongTemplateException;
import com.sergey.pojo.DataTemplates;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckingCorrectTemplates {

    public static void correctTempl(String s, String fileName) {
        for (Pattern p : DataTemplates.getTemplates()) {
            Matcher matcher = p.matcher(s);
            if (matcher.matches()) {
                return;
            }
        }
        throw new WrongTemplateException(fileName);
    }
    public static int checkingIntegerInput(String in) {
        try {
            return Integer.parseInt(in);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    public static double checkingDoubleInput(String in) {
        try {
            return Double.parseDouble(in);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    public static String boolInput(String s){
        if (s.toLowerCase().equals("y")){
            return "true";
        } else if (s.toLowerCase().equals("n")){
            return "false";
        } else {
            System.out.println("Please type only 'y' if it`s true, otherwise 'n' - false");
            return "Wrong";
        }
    }
}
