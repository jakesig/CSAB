import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Prob04 {
    private static ArrayList<String> arr = new ArrayList<String>();

    public void read() {
        Scanner scan = null;
        try {
            scan = new Scanner(new File("C:\\Users\\jsigm\\Documents\\CSAB\\CodeQuest2015\\Prob04.in.txt"));
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
            if (arr.get(i).contains("F") || arr.get(i).contains("C"));
            else {
                arr.remove(i);
                --i;
            }
        }
    }
    public void convert() {
        String[] scale;
        double convert;
        for (String s : arr) {
            scale = s.split(" ");
            convert = Double.parseDouble(scale[0]);
            if (scale[1].equals("C")) {
                convert*=(double)(9)/(5);
                convert+=32;
                convert=(double)Math.round(convert*10)/10;
                System.out.println(scale[0]+" "+scale[1]+ " = "+ convert+ " F");
            }
            if (scale[1].equals("F")) {
                convert-=32;
                convert*=(double)(5)/(9);
                convert=(double)Math.round(convert*10)/10;
                System.out.println(scale[0]+" "+scale[1]+ " = "+ convert+ " C");
            }
        }
    }

    public static void main(String[] args) {
        Prob04 p = new Prob04();
        p.read();
        p.removeNums();
        p.convert();
    }
}
