import Entity.Person;

public class Main {

    /**
     * Класс реализующий считывание данных Person из параметров.
     * @param args firsName, lastName
     */
    public static void main(String[] args) {
        if (args.length == 2) {
            Person person = new Person(args[0], args[1]);
            System.out.println("Added new " + person);
        }
        else {
            throw new IllegalArgumentException("Please check args");
        }
    }

}
