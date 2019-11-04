import java.util.*;

public class DogShow{
    private static ArrayList<ShowDog> show;
    private static Random generator = new Random();

    public DogShow() {
        show = new ArrayList<ShowDog>();
        Comparator<ShowDog> comp = new Comparator<ShowDog>(){
            public int compare(ShowDog d1, ShowDog d2) {
                return d2.getMedals()-d1.getMedals();
            }
        };
        int rand;
        for (int i = 0; i < 100 ; i++) {
            rand = generator.nextInt(4);
            if (rand==0)
                show.add(new Poodle("Poodle "+generator.nextInt(1000), generator.nextInt(9), generator.nextDouble()*100));
            if (rand==1)
                show.add(new Poodle("Basenji "+generator.nextInt(1000), generator.nextInt(9), generator.nextDouble()*100));
            if (rand==2)
                show.add(new Poodle("Beagle "+generator.nextInt(1000), generator.nextInt(9),generator.nextDouble()*100));
            if (rand==3)
                show.add(new Poodle("Chihuahua "+generator.nextInt(1000), generator.nextInt(9),generator.nextDouble()*100));
        }
        for (int i = 0; i < 1000 ; i++) {
            show.get(generator.nextInt(100)).awardMedal();
        }
        Collections.sort(show, comp);
    }

    public static void main(String[] args) {
        DogShow ds = new DogShow();
        //System.out.println("Winners:");
        System.out.println("First:\n"+ds.show.get(0));
        System.out.println("Second:\n"+ds.show.get(1));
        System.out.println("Third:\n"+ds.show.get(2));

    }
}
