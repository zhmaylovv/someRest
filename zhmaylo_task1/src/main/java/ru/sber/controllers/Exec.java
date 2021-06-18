package ru.sber.controllers;

import ru.sber.entity.Person;

import java.util.List;
import java.util.Scanner;

@FunctionalInterface
public interface Exec {
    void exec(List<Person> personList, Scanner scanner);
}
