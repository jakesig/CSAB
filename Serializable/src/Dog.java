import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Dog implements Serializable {
    private String name;
    private double weight;
    private transient int age;

    public Dog() {}

    public Dog(String name, double weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public static void main(String[] args) throws IOException {
        Dog d = new Dog();
        d.setName("Rover");;
        d.setAge(3);
        d.setWeight(47.6);
        System.out.println("Original Dog:"+d);
        try {
            File dog = new File("H:\\CSAB Library\\Quarter 1\\Serializable Project\\dog.txt");
            FileOutputStream out = new FileOutputStream(dog);
            ObjectOutputStream obj = new ObjectOutputStream(out);
            obj.writeObject(d);
            obj.close();
        }
        catch (FileNotFoundException e) {
        }
        ArrayList<Dog> pack = new ArrayList<Dog>(Arrays.asList(
                new Dog("Ron",30.4,5),
                new Dog("Jon", 40.6, 6),
                new Dog("Larry",32.5,15)));
        System.out.println("Original List:"+pack);
        try {
            File dogList = new File("H:\\CSAB Library\\Quarter 1\\Serializable Project\\dogList.txt");
            FileOutputStream outList = new FileOutputStream(dogList);
            ObjectOutputStream objList = new ObjectOutputStream(outList);
            objList.writeObject(pack);
            objList.close();
        }
        catch (FileNotFoundException e) {
        }
    }

    public String toString() {
        return "\nName: " + this.name + "\nAge: " + this.age + "\nWeight: " + this.weight;
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