public class Doctor extends TeamMember {
    private static Doctor ourInstance = null;
    private FireFighter fireFighter;
    private PoliceOfficer policeOfficer;

    public static Doctor getInstance() {
        if (ourInstance==null)
            ourInstance = new Doctor();
        return ourInstance;
    }

    private Doctor() {
        super("Dr. John");
        fireFighter = FireFighter.getInstance();
        policeOfficer = PoliceOfficer.getInstance();
    }

    public void giveHelp() {
        System.out.println(getName()+" is giving help.");
    }

    @Override public void work() {
        System.out.println(getName() + " is working.");
    }
}
