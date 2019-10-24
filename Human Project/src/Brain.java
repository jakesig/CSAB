public class Brain {
    private Heart myHeart;
    private Lung myLung;
    private Human owner;
    private boolean inDanger;
    public Brain(Heart myHeart, Lung myLung, Human myHuman) {
        this.myHeart = myHeart;
        this.myLung = myLung;
        this.owner = myHuman;
        inDanger=false;
    }
    public boolean isInDanger() {
        return inDanger;
    }
    public void senseDanger() {
        System.out.println(owner.getName()+" is in danger.");
        owner.sweat();
        inDanger=true;
        myHeart.increaseHeartRate(10, owner);
    }
}
