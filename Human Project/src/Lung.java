public class Lung {
    private Heart myHeart;
    public Lung () {

    }
    public void initializeHeart(Heart myHeart) {
        this.myHeart = myHeart;
    }
    public void breatheFaster() {
        System.out.println("*Breathes Heavily*");
        myHeart.getMoreOxygen();
    }
}
