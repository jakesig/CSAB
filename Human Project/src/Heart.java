public class Heart {
    private int heartrate;
    public Heart(int heartrate) {
        this.heartrate = heartrate;
    }
    public int increaseHeartRate(int hr) {
        heartrate+=hr;
        return heartrate;
    }
}
