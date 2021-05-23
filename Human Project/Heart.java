public class Heart {
    private int heartrate;
    private Lung myLung;
    public Heart(int heartrate) {
        this.heartrate = heartrate;
    }

    public void initializeLung(Lung myLung) {
        this.myLung = myLung;
    }

    public void getMoreOxygen() {
        System.out.println("Increasing amount of Oxygen supply to bloodstream.");
    }

    public void setHeartRate(int heartrate) {
        this.heartrate = heartrate;
    }

    public int increaseHeartRate(int hr, Human human) {
        heartrate+=hr;
        System.out.println(human.getName()+"'s heartrate has increased to "+heartrate+" beats per minute.");
        myLung.breatheFaster();
        return heartrate;
    }
}
