import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Prob01 {
    private static ArrayList<String> arr = new ArrayList<String>();

    public void read() {
        Scanner scan = null;
        try {
            scan = new Scanner(new File("C:\\Users\\jsigm\\Documents\\CSAB\\CodeQuest2015\\Prob01.in.txt"));
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
            if (arr.get(i).charAt(0)>=48 && arr.get(i).charAt(0)<=57){
                arr.remove(i);
                --i;
            }
        }
    }
    public void printMono() {
        for (String s: arr) {
            String[] print = s.split(" ");
            System.out.print(print[0].substring(0,1).toUpperCase());
            System.out.print(print[2].substring(0,1).toUpperCase());
            System.out.print(print[1].substring(0,1).toUpperCase());
            System.out.println();
        }

    }
    public static void main(String[] args) {
        Prob01 p = new Prob01();
        p.read();
        p.removeNums();
        p.printMono();
        System.out.println(arr);
    }
}
