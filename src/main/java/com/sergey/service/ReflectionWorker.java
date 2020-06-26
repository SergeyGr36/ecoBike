package com.sergey.service;

import com.sergey.checking.CheckingCorrectTemplates;
import com.sergey.pojo.Bike;
import com.sergey.pojo.DataTemplates;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Scanner;

public class ReflectionWorker {
    private Class<?> clazz;
    private String[] templates;
    private String[] forConstructor;
    private Bike dataToWrite;
    private final String SEARCH_LABEL = "search";
    private final String CREATE_LABEL = "create";
    public Bike searchData(String className){
        addData(className, SEARCH_LABEL);
        return dataToWrite;
    }
    public Bike createInstance(String className){
        addData(className, CREATE_LABEL);
        return dataToWrite;
    }

    private void addData(String className, String forWhat) {
        templates = className.equals("Folding") ? DataTemplates.getFoldingtouser() : DataTemplates.getSpeedelectouser();
        try {
            clazz = clazz.forName(DataTemplates.getPackageName() + className);
            getConstructorsType(clazz, forWhat);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void getConstructorsType(Class<?> cl, String forWhat) {
        Constructor[] constructors = cl.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            if (constructors[i].getParameterCount() > 0)
                fillClassFields(templates, constructors[i].getParameterTypes(), forWhat);
        }
        try {
            Constructor constructor = cl.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            dataToWrite = (Bike) constructor
                    .newInstance((Object)forConstructor);
        } catch (InstantiationException
                | IllegalAccessException
                | InvocationTargetException
                | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    private String[] fillClassFields(String[] strings, Class[] types, String forWhat) {
        System.out.println("Good choice! Let`s fill parameters out");
        forConstructor = new String[types.length];
        String temp;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
            temp = scanner.nextLine();
            if (types[i].equals(int.class)) {
                temp = fillIntegers(scanner, forWhat, temp);
            } else if (types[i].equals(BigDecimal.class)) {
                temp = fillDoubles(scanner, forWhat, temp);
            } else if (types[i].equals(boolean.class)) {
                temp = fillBoolean(scanner, temp);
            } else {
                fillString(scanner, forWhat, temp, i);
            }
            forConstructor[i] = temp;
        }
        System.out.println("\n\nCongratulations!!! The bike has been created\n\n");
        return forConstructor;
    }
    private String fillIntegers(Scanner sc, String forWhat, String data){
        String temp;
        int val;
        if (forWhat.equals(CREATE_LABEL)){
            while (CheckingCorrectTemplates.checkingIntegerInput(data) <= 0) {
                System.out.println("Use only positive numbers");
                data = sc.nextLine();
            }
        } else {
            if (CheckingCorrectTemplates.checkingIntegerInput(data) <= 0){
                System.out.println("Are you really want to skip? Please input only positive number, otherwise I skipp this value");
                temp = sc.nextLine();
                val = CheckingCorrectTemplates.checkingIntegerInput(temp);
                data = val<=0? null:String.valueOf(val);
                }
        }
        return data;
    }
    private String fillDoubles(Scanner sc, String forWhat, String data){
        String temp;
        double val;
        if (forWhat.equals(CREATE_LABEL)){
            while (CheckingCorrectTemplates.checkingDoubleInput(data) <= 0) {
                System.out.println("Use only positive numbers");
                data = sc.nextLine();
            }
        } else {
            if (CheckingCorrectTemplates.checkingDoubleInput(data) <= 0){
                System.out.println("Are you really want to skip? Please input only positive number, otherwise I skipp this value");
                temp = sc.nextLine();
                val = CheckingCorrectTemplates.checkingDoubleInput(temp);
                data =  val <= 0? null:String.valueOf(val);
            }
        }
        return data;
    }
    private String fillString(Scanner sc, String forWhat, String data, int position){
        if (forWhat.equals(CREATE_LABEL)||position==0) {
            while (!data.matches("[a-zA-Z]*")) {
                System.out.println("Use only letters");
                data = sc.nextLine();
            }
        }  else {
            if (data.matches("[a-zA-Z]*")){
                return data;
            } else {
                System.out.println("if you want to skipp this value press 'y'. Otherwise input only letters");
                data = sc.nextLine().equals("y")? null:fillString(sc, CREATE_LABEL, data, position);
            }
        }

        return data;
    }
    private String fillBoolean(Scanner sc, String data){
        while (!(CheckingCorrectTemplates.boolInput(data)).matches("(true|false)")) {
            data = sc.nextLine();
        }
        data = CheckingCorrectTemplates.boolInput(data);
        return data;
    }
}
