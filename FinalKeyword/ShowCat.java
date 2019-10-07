public class ShowCat extends Cat {
    private int medals;

    public ShowCat(int medals) {
        this.medals = medals;
    }

    public int getMedals() {
        return medals;
    }

    public void setMedals(int medals) {
        this.medals = medals;
    }

    @Override public void speak() {
        System.out.println("Mo money!");
    }
}
