package ru.sber.controllers;

import ru.sber.entity.Person;

import java.util.List;
import java.util.Scanner;

public class MenuItem {
    private final String name;
    private final Exec exec;

    public MenuItem(String name, Exec exec){
        this.exec = exec;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void Execute (List<Person> personList, Scanner scanner) {
        exec.exec(personList, scanner);
    }
}
