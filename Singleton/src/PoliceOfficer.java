public class PoliceOfficer {
    private static PoliceOfficer ourInstance = new PoliceOfficer();

    public static PoliceOfficer getInstance() {
        return ourInstance;
    }

    private PoliceOfficer() {
    }
}
