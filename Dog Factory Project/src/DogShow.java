import java.util.*;

public class DogShow{
    private static ArrayList<ShowDog> show;
    private static Random generator = new Random();
    public static final int DEFAULT = 100;
    public static final int MEDALS = 1000;
    public static final int TYPE = 4;
    public static final int MAXWEIGHT = 100;
    public static final int MAXAGE = 10;
    public DogShow() {
        show = new ArrayList<ShowDog>();
    }
    public void registerRandomDogs() {
        ShowDog d;
        RandomShowDogFactory temp = new RandomShowDogFactory();
        for (int i = 0; i < 100 ; i++) {
            try {
                d = temp.createShowDog();
                show.add(d);
            }
            catch(Exception e) {
            }
        }
    }
    private void sortDogs() {
        Comparator<ShowDog> comp = new Comparator<ShowDog>(){
            public int compare(ShowDog d1, ShowDog d2) {
                return d2.getMedals()-d1.getMedals();
            }
        };
        Collections.sort(show, comp);
    }
    private void awardMedals() {
        for (int i = 0; i < MEDALS; i++) {
            show.get(generator.nextInt(DEFAULT)).awardMedal();
        }
    }
    public void showTime() {
        registerRandomDogs();
        awardMedals();
        sortDogs();
        System.out.println("First:\n"+show.get(0));
        System.out.println("Second:\n"+show.get(1));
        System.out.println("Third:\n"+show.get(2));
    }
    public static void main(String[] args) {
        DogShow ds = new DogShow();
        ds.showTime();
    }
}
