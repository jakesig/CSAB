public class Chihuahua extends ShowDog
{
    public Chihuahua(String name, int age, double weight) {
        super(name, age, weight);
    }
    public Chihuahua() {
        super("None",0,0);
    }

    @Override public void speak() {
        System.out.println("Woof!");
        System.out.println("Woof!\n");
    }
}
