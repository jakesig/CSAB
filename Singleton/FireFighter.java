public class FireFighter extends TeamMember{
    private static FireFighter ourInstance = null;
    private static PoliceOfficer policeOfficer;
    private static Doctor doctor;

    public static FireFighter getInstance() {
        if (ourInstance==null) {
            ourInstance = new FireFighter();
            policeOfficer = PoliceOfficer.getInstance();
            doctor = Doctor.getInstance();
        }
        return ourInstance;
    }

    private FireFighter() {
        super("Fire Fighter Jim");
    }

    public void giveHelp() {
        System.out.println(getName()+" is giving help.");
    }

    public PoliceOfficer getPoliceOfficer() {
        return policeOfficer;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    @Override public void work() {
        System.out.println(getName() + " is working.");
    }
}
