package ru.sber.DAO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.sber.entity.Person;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class PersonDAOTest {

    @Test
    @Disabled
    void addPerson() {
        Scanner scanner = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        InputStream in = new ByteArrayInputStream("Vasiliy Zhmaylo".getBytes());
        System.setIn(in);
        PersonDAO.addPerson(personList, scanner);
        Assertions.assertEquals("Added new person: firstName='Vasiliy', lastName='Zhmaylo'",
                outputStreamCaptor.toString().trim());
    }

    @Test
    void show() {
        Scanner scanner = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("dd", "dd"));
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        PersonDAO.show(personList, scanner);
        Assertions.assertEquals("person: firstName='dd', lastName='dd'",
                outputStreamCaptor.toString().trim());
    }
}