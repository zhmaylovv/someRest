package ru.sber.controllers;

import ru.sber.DAO.PersonDAO;
import ru.sber.entity.Person;

import java.io.*;
import java.util.List;

public class FileIOController {

    public static void writeToFile(Object object, String path){
        try{
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream outStream = new ObjectOutputStream(fos);
            outStream.writeObject(object);
            outStream.flush();
            outStream.close();
        }catch(IOException e){
            System.out.println(" Error: File not found");
        }
    }
    @SuppressWarnings("unchecked")
    public static List<Person> readPersonListFromFile (List<Person> personList, String path){
        try{
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            personList = (List<Person>) objectInputStream.readObject();
            objectInputStream.close();
        }catch (Exception e){
        }
        return personList;
    }
}
