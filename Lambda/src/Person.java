import java.util.List;

public class Person {
    private String name;
    private int weight;
    public Person(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Person() {
        this(null, 0);
    }

    @Override public String toString() {
        return  "Name: " + name + "\t\t\t" + "Weight: " + weight + "\n";
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public static void printList(List<Person> ppl) {
        for (Person p : ppl)
            System.out.print(p);
    }

    public static void printLetter(List<Person> ppl, Filter f) {
        for(Person per : ppl)
            if (f.test(per))
                System.out.println(per);
    }
}
