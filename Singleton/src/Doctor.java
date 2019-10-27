public class Doctor {
    private static Doctor ourInstance = new Doctor();

    public static Doctor getInstance() {
        return ourInstance;
    }

    private Doctor() {
    }
}
