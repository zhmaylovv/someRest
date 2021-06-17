import Entity.Person;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        System.out.println("Please enter first and last name of person, split by space.");
        Scanner scanner = new Scanner(System.in);
        String[] inputData = scanner.nextLine().split(" ");
        if (inputData.length != 2){
            throw new IllegalArgumentException("Please check correct input");
        }
        else{
            Person person = new Person(inputData[0], inputData[1]);
            System.out.println("Added new " + person);
        }

    }
}