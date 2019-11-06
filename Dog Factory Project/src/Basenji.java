public class Basenji extends ShowDog
{
    public Basenji(String name, int age, double weight) {
        super(name, age, weight);
    }
    public Basenji() {
        super("None",0,0);
    }

    @Override public void speak() {
       System.out.println("");
    }
}
