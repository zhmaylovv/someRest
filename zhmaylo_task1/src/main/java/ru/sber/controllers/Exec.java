package ru.sber.controllers;

import ru.sber.entity.Person;

import java.util.List;
import java.util.Scanner;


/**
 * Функциональный интерфейс, для выполнения действийсо списком обьектов Person
 */
@FunctionalInterface
public interface Exec {
    void exec(List<Person> personList, Scanner scanner);
}
