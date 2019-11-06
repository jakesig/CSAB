public class Beagle extends ShowDog
{
    private int volume;

    public Beagle(String name, int age, double weight) {
        super(name, age, weight);
    }
    public Beagle() {
        super("None",0,0);
    }

    public String toString()  {
        return super.toString()+"\nHowl Volume: " + volume +" db";
    }
    
    public void setVolume(int v) {
        volume=v;
    }
    
    public int getVolume() {
        return volume;
    }
    
    @Override public void speak() {
        System.out.println("Howl!\n");
    }
}
