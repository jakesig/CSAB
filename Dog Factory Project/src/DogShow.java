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
    private void randomDogs() {
        show.clear();
        int rand;
        for (int i = 0; i < DEFAULT ; i++) {
            rand = generator.nextInt(TYPE);
            if (rand==0)
                show.add(new Poodle("Poodle "+generator.nextInt(MEDALS), generator.nextInt(MAXAGE), Math.round(generator.nextDouble()*MAXWEIGHT)));
            if (rand==1)
                show.add(new Poodle("Basenji "+generator.nextInt(MEDALS), generator.nextInt(MAXAGE), Math.round(generator.nextDouble()*MAXWEIGHT)));
            if (rand==2)
                show.add(new Poodle("Beagle "+generator.nextInt(MEDALS), generator.nextInt(MAXAGE),Math.round(generator.nextDouble()*MAXWEIGHT)));
            if (rand==3)
                show.add(new Poodle("Chihuahua "+generator.nextInt(MEDALS), generator.nextInt(MAXAGE),Math.round(generator.nextDouble()*MAXWEIGHT)));
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
        randomDogs();
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
