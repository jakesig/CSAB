public class ShowDog extends Dog {
    private int medals;
    public ShowDog(String name, int age, double weight) {
        super(name, age, weight);
        medals = 0;
    }

    public ShowDog() {
        super("None", 0, 0);
    }

    public int getMedals() {
        return medals;
    }
    public void awardMedal() {
        medals++;
    }
    @Override public String toString() {
        return super.toString()+"\nMedals: "+medals+"\n";
    }

}
