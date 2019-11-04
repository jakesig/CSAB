

/**
 * Write a description of class dog.Beagle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Beagle extends Dog
{
    private int volume;
    
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
