public class Tester {
    public static void main(String[] args) {
        Doctor d = Doctor.getInstance();
        FireFighter f = FireFighter.getInstance();
        PoliceOfficer p = PoliceOfficer.getInstance();
        d.work();
        f.work();
        p.work();
        System.out.println(d.getName() + " is asking "+d.getFireFighter().getName()+" for help.");
        d.getFireFighter().giveHelp();
        System.out.println(d.getName() + " is asking "+d.getPoliceOfficer().getName()+" for help.");
        d.getPoliceOfficer().giveHelp();
        System.out.println(f.getName() + " is asking "+f.getPoliceOfficer().getName()+" for help.");
        f.getPoliceOfficer().giveHelp();
        System.out.println(f.getName() + " is asking "+f.getDoctor().getName()+" for help.");
        f.getDoctor().giveHelp();
        System.out.println(p.getName() + " is asking "+p.getFireFighter().getName()+" for help.");
        p.getFireFighter().giveHelp();
        System.out.println(p.getName() + " is asking "+p.getDoctor().getName()+" for help.");
        p.getDoctor().giveHelp();
    }
}
