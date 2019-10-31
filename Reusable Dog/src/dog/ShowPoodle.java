package dog;

/**
 * Write a description of class dog.ShowPoodle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ShowPoodle extends Dog
{
    private int medals;
    
    @Override public String toString() {
        return super.toString() +"\nMedals Won: " + medals;
    }
    
    public int getMedals() {
        return medals;
    }
    
    public void setMedals(int m) {
        medals=m;
    }
}
