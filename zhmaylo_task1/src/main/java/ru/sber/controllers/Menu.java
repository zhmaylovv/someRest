package ru.sber.controllers;

import ru.sber.DAO.PersonDAO;
import ru.sber.entity.Person;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    public List<Person> personList;
    private final List<MenuItem> menuItemList;
    private String menuString;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
        this.personList = new ArrayList<>();
        this.menuItemList = new ArrayList<>();
        menuItemList.add(new MenuItem("Exit", PersonDAO::exit));
        menuItemList.add(new MenuItem("Add", PersonDAO::addPerson));
        menuItemList.add(new MenuItem("Show", PersonDAO::show));
        menuItemList.add(new MenuItem("Show sorted unique", PersonDAO::showSorted));
        this.menuString = "";
    }

    public void start(){

        for (MenuItem item : menuItemList){
            menuString += "\n" + "[" + menuItemList.indexOf(item) + "] " + item.getName() ;
        }

        while(true){
            System.out.println(menuString);
            System.out.println("Make your choice: (type number of operation)");
            try{
                int userChoice = Integer.parseInt(scanner.nextLine());
                if (userChoice < 0 || userChoice > menuItemList.size()-1){
                    System.out.println("Bad request, check correctness of the input.");
                    continue;
                }
                MenuItem itemChoice = menuItemList.get(userChoice);
                itemChoice.Execute(personList, scanner);
            }catch (Exception e){
                System.out.println("Bad request, check correctness of the input.");
                System.out.println(e.getMessage());
            }
        }
    }




}
