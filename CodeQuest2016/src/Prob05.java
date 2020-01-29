import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Prob05 {
    private static ArrayList<String> arr = new ArrayList<String>();

    public void read() {
        Scanner scan = null;
        try {
            scan = new Scanner(new File("C:\\Users\\jsigm\\Documents\\CSAB\\CodeQuest2016\\Prob05.in.txt"));
        }
        catch (Exception e) {
            //Empty catch
        }
        while(scan.hasNextLine()) {
            arr.add(scan.nextLine());
        }
    }
    public void removeNums() {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).contains("-"));
            else {
                arr.remove(i);
                --i;
            }
        }
    }
    public void sortByArtist() {
        String[] stringArr;
        String thisStr;
        String prevStr = "";
        for (int i = 0; i < arr.size()-1; i++) {
            stringArr = arr.get(i).split(" - ");
            thisStr = stringArr[1];
            if (thisStr.compareTo(prevStr)>0) {
                arr.set(i, arr.remove(i));
            }
            else if (thisStr.compareTo(prevStr)<0) {
                arr.set(i-1, arr.remove(i));
            }
            else if (thisStr.compareTo(prevStr)==0) {
                arr.set(i, arr.remove(i));
            }
            prevStr = thisStr;
        }
    }

    public static void main(String[] args) {
        Prob05 p = new Prob05();
        p.read();
        p.removeNums();
        p.sortByArtist();
        for ( String s : arr) {
            System.out.println(s);
        }
    }
}
