package com.sergey.service;

import com.sergey.checking.CheckingCorrectTemplates;

import java.util.Scanner;

public class TaskDelegator {

    private final String WRONG_INPUT = "Please input only positive numbers in current range. Try it again";
    private FileWorkerForTask fileWorkerForTask = new FileWorkerForTask();
    private ReflectionWorker reflWork = new ReflectionWorker();
    private DataRepository dataRepository = new DataRepository();

    public TaskDelegator() {
        interactiveConsole();
    }

    public void interactiveConsole() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(consoleTemplate());
            choice = CheckingCorrectTemplates.checkingIntegerInput(scanner.next());
            switch (choice) {
                case 1:
                    fileWorkerForTask.printAllData();
                    break;
                case 2:
                    dataRepository.addData(reflWork.createInstance("Folding"));
                    break;
                case 3:
                    dataRepository.addData(reflWork.createInstance("Speedelec"));
                    break;
                case 4:
                    dataRepository.addData(reflWork.createInstance("EBike"));
                    break;
                case 5:
                    outer:
                    while (true) {
                        System.out.println("Which bike do you want to find?" +
                                "\n1 - Folding" +
                                "\n2 - E-Bike" +
                                "\n3 - Speedelec");
                        choice = CheckingCorrectTemplates.checkingIntegerInput(scanner.next());
                        switch (choice) {
                            case 1:
                                reflWork.searchData("Folding");
                                break outer;
                            case 2:
                                reflWork.searchData("EBike");
                                break outer;
                            case 3:
                                reflWork.searchData("Speedelec");
                                break outer;
                            default:
                                System.out.println(WRONG_INPUT);
                        }
                    }
                case 6:
                    fileWorkerForTask.saveDataToFile(dataRepository.getList());
                    dataRepository = new DataRepository();
                    break;
                case 7:
                    System.out.println("Program stopped");
                    scanner.close();
                    return;
                default:
                    System.out.println(WRONG_INPUT);
            }
        }
    }

    private String consoleTemplate() {
        return "Please make your choice \n" +
                "1 - Show the entire EcoBike catalog \n" +
                "2 - Add a new folding bike \n" +
                "3 - Add a new speedelec \n" +
                "4 - Add a new e-bike \n" +
                "5 - Find the first item of a particular brand \n" +
                "6 - Write to file \n" +
                "7 - Stop the program";
    }


}
