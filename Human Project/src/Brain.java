public class Brain {
    private Heart myHeart;
    public Brain(Heart myHeart) {
        this.myHeart = myHeart;
    }
    public void senseDanger() {
        myHeart.increaseHeartRate(10);
    }
}
