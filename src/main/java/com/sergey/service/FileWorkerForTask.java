package com.sergey.service;

import com.sergey.checking.CheckingCorrectTemplates;
import com.sergey.pojo.Bike;

import java.io.*;
import java.text.MessageFormat;
import java.util.List;

public class FileWorkerForTask {

    private final String FILENAME = "ecobike.txt";

    private MessageFormat format = new MessageFormat("{0} with {1} and {2}.\nPrice: {3} euros.");

    public FileWorkerForTask() {
    }

    public synchronized void printAllData() {
        try (LineNumberReader numberReader = new LineNumberReader(
                new FileReader(
                        "/home/sergey/IdeaProjects/echoBike/src/main/resources/ecobike.txt"))) {
//            LineNumberReader numberReader = new LineNumberReader(new FileReader((this.getClass().getClassLoader().getResource(FILENAME)).toString()));
            String line;
            while ((line = numberReader.readLine()) != null) {
                CheckingCorrectTemplates.correctTempl(line, FILENAME);
                parsingString(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public synchronized void saveDataToFile(List<Bike> list){
        try(FileWriter fw = new FileWriter("/home/sergey/IdeaProjects/echoBike/src/main/resources/ecobike.txt")) {
            for (Bike b: list) {
                fw.write(b.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private void parsingString(String s) {
        String[] mas = s.split("; ");
        String[] forPrint = new String[4];
        int count = 0;
        for (int i = 0; i < mas.length; i++) {
            count = CheckingCorrectTemplates.checkingIntegerInput(mas[i]) == (-1) ? 0 : ++count;

            //Якщо батарея знаходиться в іньшому місці, то як варіант то можна знаходить TRUE/FALSE
//            та визивать дані --і та ++і, тому що в завданні є деякі неточності.

            if (count == 2) {
                forPrint[1] = s.contains("FOLDING") ? mas[i] + " gear(s)" : mas[i] + " mAh battery";
            } else if (mas[i].contains("TRUE") || mas[i].contains("FALSE")) {
                forPrint[2] = mas[i].contains("TRUE") ? "head/tail light" : "no head/tail light";
                forPrint[0] = mas[0];
                forPrint[forPrint.length - 1] = mas[mas.length - 1];
                System.out.println(format.format(forPrint));
                return;
            }
        }
    }
}
