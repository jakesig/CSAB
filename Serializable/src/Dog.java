import java.io.*;

public class Dog implements Serializable {
    private String name;
    private double weight;
    private int age;

    public Dog() {}

    public static void main(String[] args) throws IOException {
        Dog d = new Dog();
        d.setName("Rover");;
        d.setAge(3);
        d.setWeight(47.6);
        try {
            File dog = new File("H:\\CSAB Library\\Quarter 1\\Serializable Project\\dog.txt");
            FileOutputStream out = new FileOutputStream(dog);
            ObjectOutputStream obj = new ObjectOutputStream(out);
            obj.writeObject(d);
            obj.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return "Name: " + this.name + "\nAge: " + this.age + "\nWeight: " + this.weight;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setWeight(double newWeight) {
        this.weight = newWeight;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }

    public String getName() {
        return "Name: " + this.name;
    }

    public String getWeight() {
        return "Weight: " + this.weight;
    }

    public String getAge() {
        return "Age: " + this.age;
    }

    public void speak() {
        System.out.println("Woof!\n");
    }
}