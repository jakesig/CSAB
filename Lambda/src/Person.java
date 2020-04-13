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
        return  "Name:" + name + '\n' + "Weight:" + weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}
