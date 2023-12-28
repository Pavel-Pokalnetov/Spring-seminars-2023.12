package loc.homework;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Hello world!
 */
public class App {
    private static final String SEP = "-------------------";

    public static void main(String[] args) {
        System.out.println("\n" + SEP + "ToString" + SEP);
        Person person = new Person("Jhon", "Connor", 44);
        Person person1 = new Person("Terminator", "T1000", 1);
        System.out.println("Person:  " + person);
        System.out.println("Person1: " + person1);
        System.out.println("\n" + SEP + "HashCode" + SEP);
        System.out.println("HashCode Person:  " + person.hashCode());
        System.out.println("HashCode Person1: " + person1.hashCode());
        System.out.println("\n" + SEP + "Equals" + SEP);
        System.out.println("(Person==Person):  " + person.equals(person));
        System.out.println("(Person==Person1): " + person.equals(person1));
        System.out.println("\n" + SEP + "JSON" + SEP);
        Gson gson = new GsonBuilder().create();
        String jsonString = gson.toJson(person);
        System.out.println("JSON Person: " + jsonString);
        Person person2 = gson.fromJson(jsonString, Person.class);
        System.out.println("Person(original):  " + person);
        System.out.println("Person2(fromJson): " + person2);


    }
}
