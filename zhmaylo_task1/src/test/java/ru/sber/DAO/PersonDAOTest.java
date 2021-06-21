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
    void addPerson() {
        List<Person> personList = new ArrayList<>();
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        InputStream in = new ByteArrayInputStream("Vasiliy Zhmaylo".getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        PersonDAO.addPerson(personList, scanner);
        Assertions.assertEquals("Please enter first and last name of person, split by space. For add to person list. \n" +
                        "Person added to list",
                outputStreamCaptor.toString().trim());
    }




    @Test
    void checkShowMethod() {
        Scanner scanner = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("dd", "dd"));
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        PersonDAO.show(personList, scanner);
        Assertions.assertEquals("person: firstName='dd', lastName='dd'",
                outputStreamCaptor.toString().trim());
    }

    @Test
    void checkShowSortedMethod() {
        Scanner scanner = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("dd", "dd"));
        personList.add(new Person("dd", "dd"));
        personList.add(new Person("dd", "aa"));
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        PersonDAO.showSorted(personList, scanner);
        Assertions.assertEquals("person: firstName='dd', lastName='aa'\n" +
                        "person: firstName='dd', lastName='dd'",
                outputStreamCaptor.toString().trim());

    }

    @Test
    void checkClear(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("test", "test"));
        PersonDAO.clear(personList, null);
        Assertions.assertEquals(0, personList.size());
    }
}