public class FireFighter extends TeamMember{
    private static FireFighter ourInstance = null;
    private PoliceOfficer policeOfficer;
    private Doctor doctor;

    public static FireFighter getInstance() {
        if (ourInstance==null)
            ourInstance = new FireFighter();
        return ourInstance;
    }

    private FireFighter() {
        super("Fire Fighter Jim");
        policeOfficer = PoliceOfficer.getInstance();
        doctor = Doctor.getInstance();
    }

    public void giveHelp() {
        System.out.println(getName()+" is giving help.");
    }

    @Override public void work() {
        System.out.println(getName() + " is working.");
    }
}
