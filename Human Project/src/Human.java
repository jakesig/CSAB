public class Human {
    private Brain myBrain;
    private Heart myHeart;
    private String name;
    private Lung myLung;

    public Human(String myName) {
        this.name=myName;
        myHeart = new Heart(60);
        myLung = new Lung();
        myBrain = new Brain(myHeart, myLung,this);
        myHeart.initializeLung(myLung);
        myLung.initializeHeart(myHeart);
        System.out.println(name+" is now alive.");
    }
    public String getName() {
        return name;
    }
    public void sweat() {
        System.out.println(name+" is sweating.");
    }
    public void senseDanger() {
        myBrain.senseDanger();
    }
    public static void main(String[] args) {
        Human tester = new Human("Jack");
        tester.senseDanger();
    }
}
