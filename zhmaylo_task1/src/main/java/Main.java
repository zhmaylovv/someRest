import ru.sber.controllers.Menu;
import ru.sber.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        checkArgs(args, menu.personList);
        menu.start();

    }

    public static void checkArgs(String[] args, List<Person> personList){
        if (args.length == 2) {
            Person person = new Person(args[0], args[1]);
            System.out.println("Added new " + person);
            personList.add(person);
        }else if (args.length != 0){
            System.out.println("Bad lunch params - person not create");
        }
    }
}