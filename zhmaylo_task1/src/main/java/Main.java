import entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();

        if (args.length == 2) {
            Person person = new Person(args[0], args[1]);
            System.out.println("Added new " + person);
            personList.add(person);
        }else if (args.length != 0){
            System.out.println("Bad params - person not create");
        }
        System.out.println("Please enter first and last name of person, split by space. " +
                            "For add to person list. ");
        while(true){
            if (scanner.hasNext()) {
                String input = scanner.nextLine();
                if (input.equals("exit")) {
                    System.out.println("Person list: ");
                    System.out.println(personList);
                    break;
                } else {
                    String[] inputData = input.split(" ");
                    if (inputData.length == 2) {
                        Person person = new Person(inputData[0], inputData[1]);
                        personList.add(person);
                        System.out.println("Person added to list, enter next:");
                    } else {
                        System.out.println("Please check correctness of the input");
                    }
                }
            }else{
                break;
            }
        }
    }
}