public class Doctor extends TeamMember {
    private static Doctor ourInstance = null;
    private static FireFighter fireFighter;
    private static PoliceOfficer policeOfficer;

    public static Doctor getInstance() {
        if (ourInstance==null) {
            ourInstance = new Doctor();
            fireFighter = FireFighter.getInstance();
            policeOfficer = PoliceOfficer.getInstance();
        }
        return ourInstance;
    }

    private Doctor() {
        super("Dr. John");
    }

    public void giveHelp() {
        System.out.println(getName()+" is giving help.");
    }

    public FireFighter getFireFighter() {
        return fireFighter;
    }

    public PoliceOfficer getPoliceOfficer() {
        return policeOfficer;
    }

    @Override public void work() {
        System.out.println(getName() + " is working.");
    }
}
