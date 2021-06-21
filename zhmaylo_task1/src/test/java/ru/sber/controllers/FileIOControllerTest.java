package ru.sber.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.sber.entity.Person;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileIOControllerTest {

    @Test
    void testFileIOWriteAndReadSameTime() {
        Person person = new Person("First" , "Last");
        List<Person> personList = new ArrayList<>();
        List<Person> personList2 = new ArrayList<>();
        personList.add(person);
        FileIOController.writeToFile(personList, "./src/test/resources/personList");
        personList2 = FileIOController.readPersonListFromFile(personList, "./src/test/resources/personList");
        Assertions.assertEquals(personList, personList2);
    }
}