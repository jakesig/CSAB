import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Prob03 {
    private static ArrayList<String> arr = new ArrayList<String>();

    public void read() {
        Scanner scan = null;
        try {
            scan = new Scanner(new File("C:\\Users\\jsigm\\Documents\\CSAB\\CodeQuest2015\\Prob03.in.txt"));
        }
        catch (Exception e) {
            //Empty catch
        }
        while(scan.hasNextLine()) {
            arr.add(scan.nextLine());
        }
        for (int i = 0; i < arr.size(); i++) {
            if (Integer.parseInt(arr.get(i))<10) {
                arr.remove(i);
                --i;
            }
        }
    }
    public void leaper() {
        int year;
        for (int i = 0; i < arr.size(); i++) {
            year = Integer.parseInt(arr.get(i));
            if (year<1582) {
                System.out.println("No");
                continue;
            }
            if (year%4!=0) {
                System.out.println("No");
                continue;
            }
            if (year%100!=0) {
                System.out.println("Yes");
                continue;
            }
            if (year%400!=0) {
                System.out.println("No");
                continue;
            }
            System.out.println("Yes");
        }
    }

    public static void main(String[] args) {
        Prob03 p = new Prob03();
        p.read();
        p.leaper();
    }
}
