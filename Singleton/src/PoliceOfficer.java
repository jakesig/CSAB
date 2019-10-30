public class PoliceOfficer extends TeamMember {
    private static PoliceOfficer ourInstance = null;
    private static FireFighter fireFighter;
    private static Doctor doctor;

    public static PoliceOfficer getInstance() {
        if (ourInstance==null) {
            ourInstance = new PoliceOfficer();
            fireFighter = FireFighter.getInstance();
            doctor = Doctor.getInstance();
        }
        return ourInstance;
    }

    private PoliceOfficer() {
        super("Officer Paul");
    }

    public void giveHelp() {
        System.out.println(getName()+" is giving help.");
    }

    public FireFighter getFireFighter() {
        return fireFighter;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    @Override public void work() {
        System.out.println(getName() + " is working.");
    }
}
