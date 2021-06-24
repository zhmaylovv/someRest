package ru.sber;

import ru.sber.controllers.Menu;
import ru.sber.entity.Person;

import java.util.List;
import java.util.Scanner;


/**
 * Класс main запускающий основное меню и проверяющий налчие и обработку аргументов запуска
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        checkArgs(args, menu.personList);
        menu.start();
    }

    /**
     * Метод обрабатывающий параметры запуска если они есть.
     *
     * @param args       аргументы командной строки
     * @param personList список сущностей Person для добавления в него обьекта из параметров.
     */
    public static void checkArgs(String[] args, List<Person> personList) {
        if (args.length == 2) {
            Person person = new Person(args[0], args[1]);
            System.out.println("Added new " + person);
            personList.add(person);
        } else if (args.length != 0) {
            System.out.println("Bad lunch params - person not create");
        }
    }
}