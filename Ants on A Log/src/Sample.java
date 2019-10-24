import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Sample {
    private Scanner scan;
    private int logLength;
    private ArrayList<Integer> greenPos;
    private ArrayList<Integer> blackPos;
    public Sample() {
        ArrayList<String> stringArr = new ArrayList<String>();
        try {
            scan = new Scanner(new File("H:\\CSAB Git\\Ants on A Log\\input.txt"));
        }
        catch (FileNotFoundException f) {
            System.out.println("Error: File not found");
        }
        while (scan.hasNextLine()) {
            stringArr.add(scan.nextLine());
        }
        logLength=Integer.parseInt(stringArr.get(0));
        greenPos = new ArrayList<Integer>();//keep this in mindArrays.asList(stringArr.get(1).split(" ")));
        blackPos = new ArrayList<Integer>();
        for (int i = 0; i <stringArr.get(1).length(); i++) {
            if ((int)stringArr.get(1).charAt(i)!=32)
                greenPos.add((int)stringArr.get(1).charAt(i)-48);
        }
        for (int i = 0; i <stringArr.get(2).length(); i++) {
            if ((int)stringArr.get(2).charAt(i)!=32)
                blackPos.add((int)stringArr.get(2).charAt(i)-48);
        }
        System.out.println(logLength);
        System.out.println(greenPos);
        System.out.println(blackPos);
    }

    public static void main(String[] args) {
        Sample s = new Sample();
    }
}
