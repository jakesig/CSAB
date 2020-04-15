import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PersonTesterLambda {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Bob", 140),
                new Person("Anita", 137),
                new Person("Fred", 187),
                new Person("Jane", 156),
                new Person("Dave", 150),
                new Person("Anthony", 200)
        );
        //Sort by name
        Collections.sort(people, (o1, o2)-> o1.getName().compareTo(o2.getName()));
        Person.printList(people);
        //Starting with A
        Filter f = p -> {
            return(p.getName().toUpperCase().startsWith("A"));
        };
        Person.printLetter(people, f);
    }
}
