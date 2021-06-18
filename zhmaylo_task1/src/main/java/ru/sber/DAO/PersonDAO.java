package ru.sber.DAO;

import ru.sber.entity.Person;

import java.util.*;


public class PersonDAO {


    public static void addPerson(List<Person> personList, Scanner scanner) {
        System.out.println("Please enter first and last name of person, split by space. " +
                "For add to person list. ");
        String input = scanner.nextLine();
        String[] inputData = input.split(" ");
        if (inputData.length == 2) {
            Person person = new Person(inputData[0], inputData[1]);
            personList.add(person);
            System.out.println("Person added to list");
        } else {
            System.out.println("Person didnt added, please check correctness of the input ");
        }
    }


    public static void exit(List<Person> personList, Scanner scanner) {
        System.exit(0);
    }

    public static void show(List<Person> personList, Scanner scanner) {
        personList.sort(Comparator.comparing(Person::getLastName).thenComparing(Person::getLastName));
        personList.forEach(System.out::println);
    }

    public static void showSorted(List<Person> personList, Scanner scanner) {
        TreeSet<Person> unic = new TreeSet<>(Comparator.comparing(Person::getLastName));
        unic.addAll(personList);
        unic.forEach(System.out::println);
    }
}
