public class Chihuahua extends ShowDog
{
    public Chihuahua(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override public void speak() {
        System.out.println("Woof!");
        System.out.println("Woof!\n");
    }
}
