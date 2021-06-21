package ru.sber.controllers;

import ru.sber.entity.Person;

import java.io.*;
import java.util.List;

/**
 * Класс содержит в себе методы работы с файлами.
 */
public class FileIOController {
    /**
     * Метод записи обьекта в файл. Обьект должен быть сериализующимся.
     *
     * @param object Обьект для сериализации и записи в файл
     * @param path   Путь и имя файла для записи
     */
    public static void writeToFile(Object object, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream outStream = new ObjectOutputStream(fos);
            outStream.writeObject(object);
            outStream.flush();
            outStream.close();
        } catch (IOException e) {
            System.out.println(" Error: File not found");
        }
    }

    /**
     * Метод чтения обьектов 'List<Person>' из файла.
     * При привидении типов прочтенного обьекта к 'List<Person>' обьктов отличных от него,
     * могут возникнуть проблемы, поэтому используется только для чения именно этих обьектов.
     * Для исключения из проверки по не безопасному приведению типов помечен аннотацией "unchecked"
     *
     * @param personList List<Person> для присвоения данных по информации из файла
     * @param path       Путь к файлу для чтения
     * @return List<Person> с обьектами из файла
     */
    @SuppressWarnings("unchecked")
    public static List<Person> readPersonListFromFile(List<Person> personList, String path) {
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            personList = (List<Person>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception ignored) {
        }
        return personList;
    }
}
