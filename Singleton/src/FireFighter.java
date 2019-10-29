public class FireFighter {
    private static FireFighter ourInstance = new FireFighter();

    public static FireFighter getInstance() {
        return ourInstance;
    }

    private FireFighter() {
    }
}
