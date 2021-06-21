package ru.sber.DAO;

import ru.sber.controllers.FileIOController;
import ru.sber.entity.Person;

import java.util.*;


public class PersonDAO {

    /**
     * Метод добавления элемента Person, из пользовательского ввода.
     * Корректная строка для воода: "firstname lastname", через пробел.
     *
     * @param personList Список обьектов класса Person в который нужно добавить обьект
     * @param scanner    сканнер с которого приходят входные данные
     */
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

    /**
     * Заглушка для метода выхода. Реализация выхода сделана через прерывание цикла ввода.
     *
     * @param personList Список обьектов класса Person. В данном случае передается из за шаблонизации элементов меню
     * @param scanner    сканнер с которого приходят входные данныеВ данном случае передается из за шаблонизации элементов меню
     */
    public static void exit(List<Person> personList, Scanner scanner) {
    }

    /**
     * Метод для отображения сортированного уникального списка обьектов класса Person
     *
     * @param personList Список обьектов класса Person для отображения.
     * @param scanner    сканнер с которого приходят входные данныеВ данном случае передается из за шаблонизации элементов меню
     */
    public static void show(List<Person> personList, Scanner scanner) {
        personList.sort(Comparator.comparing(Person::getLastName).thenComparing(Person::getLastName));
        personList.forEach(System.out::println);
    }

    /**
     * Метод для отображения сортированного уникального списка обьектов класса Person
     *
     * @param personList Список обьектов класса Person для отображения.
     * @param scanner    сканнер с которого приходят входные данныеВ данном случае передается из за шаблонизации элементов меню
     */
    public static void showSorted(List<Person> personList, Scanner scanner) {
        TreeSet<Person> unic = new TreeSet<>(Comparator.comparing(Person::getLastName));
        unic.addAll(personList);
        unic.forEach(System.out::println);
    }

    /**
     * Метод для сохранения в файл списка обьектов класса Person.
     *
     * @param personList Список обьектов класса Person для записи.
     * @param scanner    сканнер с которого приходят входные данные В данном случае передается из за шаблонизации элементов меню
     */
    public static void saveToFile(List<Person> personList, Scanner scanner) {
        FileIOController.writeToFile(personList, "./src/main/resources/personList");
    }

    /**
     * Метод для чтения из файла списка обьектов класса Person.
     *
     * @param personList Список обьектов класса Person для записи в него.
     * @param scanner    сканнер с которого приходят входные данные В данном случае передается из за шаблонизации элементов меню
     */
    public static void readFromFile(List<Person> personList, Scanner scanner) {
        personList.addAll(FileIOController.readPersonListFromFile(personList, "./src/main/resources/personList"));
    }

    /**
     * Метод очистки списка.
     *
     * @param personList Список обьектов класса Person для записи. В данном случае передается из за шаблонизации элементов меню
     * @param scanner    сканнер с которого приходят входные данные. В данном случае передается из за шаблонизации элементов меню
     */
    public static void clear(List<Person> personList, Scanner scanner) {
        personList.clear();
    }
}
