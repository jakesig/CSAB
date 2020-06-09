import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonTester {
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
        Comparator<Person> c = new Comparator<Person>() {
            @Override public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Collections.sort(people, c);
        Person.printList(people);
        //Starting with A
        Filter f = new Filter(){
            @Override public boolean test(Person p) {
                if(p.getName().toUpperCase().startsWith("A"))
                    return true;
                return false;
            }
        };
        Printer p = new Printer(){
            @Override public void printAList(List<Person> data) {
                for (Person per : data)
                    if (f.test(per))
                        System.out.print(per);
            }
        };
        p.printAList(people);
    }
}
