public class Dog
{
    private String name;
    private double weight;
    private int age;

    public Dog(String name, int age, double weight) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public Dog() {
        this.name = "None";
        this.weight = 0.0;
        this.age = 0;
    }

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
