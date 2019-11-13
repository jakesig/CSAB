import java.util.Random;

public class RandomShowDogFactory {
    enum DogTypes {
        Poodle, Basenji, Beagle, Chihuahua
    };
    private static Random generator = new Random();
    public ShowDog createShowDog() throws Exception {
        ShowDog d = new ShowDog();
        DogTypes [] types = DogTypes.values();
        DogTypes randomDogType = types[generator.nextInt(types.length)];
        try {
            d = (ShowDog)(Class.forName(randomDogType.toString())).newInstance();
        }
        catch (Exception e) {
            //Empty
        }
        d.setName(d.getClass().getName()+generator.nextInt(1000));
        d.setAge(generator.nextInt(10));
        d.setWeight(generator.nextDouble()*100);
        return d;
    }

}
