package ru.sber.controllers;

import com.sun.tools.javac.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    void testStartApp() throws Exception {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        InputStream in = new ByteArrayInputStream("0".getBytes());
        System.setIn(in);
        String stringActual = "[0] Exit\n" +
                "[1] Add\n" +
                "[2] Show\n" +
                "[3] Show sorted unique\n" +
                "[4] Save to file \n" +
                "[5] Read from file \n" +
                "[6] Clear data in memory \n" +
                "Make your choice: (type number of operation)";
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        menu.start();
        Assertions.assertEquals(stringActual,outputStreamCaptor.toString().trim());


    }
}