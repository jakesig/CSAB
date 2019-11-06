import java.util.Random;

public class RandomShowDogFactory {
    enum DogTypes {
        Poodle, Basenji, Beagle, Chihuahua
    };
    private static Random generator = new Random();
    public ShowDog createShowDog() throws Exception {
        ShowDog d;
        DogTypes [] types = DogTypes.values();
        DogTypes randomDogType = types[generator.nextInt(types.length)];
        switch (randomDogType) {
            case Poodle:
                d = new Poodle();
                break;
            case Basenji:
                d = new Basenji();
                break;
            case Beagle:
                d = new Beagle();
                break;
            case Chihuahua:
                d = new Chihuahua();
                break;
            default:
                d = new ShowDog();
                break;
        }
        d.setName(d.getClass().getName()+generator.nextInt(1000));
        d.setAge(generator.nextInt(10));
        d.setWeight(generator.nextDouble()*1000);
        return d;
    }

}
