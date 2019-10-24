public class Human {
    private Brain myBrain;
    private Heart myHeart;
    public Human() {
        myBrain = new Brain(myHeart);
        myHeart = new Heart(60);
    }
    public void initialize() {

    }
}
