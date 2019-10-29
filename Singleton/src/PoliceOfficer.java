public class PoliceOfficer extends TeamMember {
    private static PoliceOfficer ourInstance = null;
    private FireFighter fireFighter;
    private Doctor doctor;

    public static PoliceOfficer getInstance() {
        if (ourInstance==null)
            ourInstance = new PoliceOfficer();
        return ourInstance;
    }

    private PoliceOfficer() {
        super("Officer Paul");
        fireFighter = FireFighter.getInstance();
        doctor = Doctor.getInstance();
    }

    public void giveHelp() {
        System.out.println(getName()+" is giving help.");
    }

    @Override public void work() {
        System.out.println(getName() + " is working.");
    }
}
