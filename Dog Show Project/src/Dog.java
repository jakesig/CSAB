
/**
 * Write a description of class dog.Dog here.
 *
 * @author Jacob Sigman
 * @version 9/17/2018
 */
public class Dog
{
    private String name;
    private double weight;
    private int age;
    
    @Override public String toString() {
        return "Name: " + name + "\nAge: " + age + "\nWeight: " + weight;
    }
    public void setName(String newName) {
        name=newName;
    }
    
    public void setWeight(double newWeight) {
        weight=newWeight;
    }
    
    public void setAge(int newAge) {
        age=newAge;
    }
    
    public String getName() {
        return "Name: " + name;
    }
    
    public String getWeight() {
        return "Weight: " + weight;
    }
    
    public String getAge() {
        return "Age: " + age;
    }
    
    public void speak() {
        System.out.println("Woof!\n");
    }
}
