import java.util.*;
import java.io.*;

public class Sample {
    private int sticks;
    private int logLength;
    private Scanner scan;
    private ArrayList<Integer> greenPos;
    private ArrayList<Integer> blackPos;
    public Sample() {
        ArrayList<String> stringArr = new ArrayList<String>();
        greenPos = new ArrayList<Integer>();
        blackPos = new ArrayList<Integer>();
        sticks=0;
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
        ArrayList<String> greenPosStr = new ArrayList<String>(Arrays.asList(stringArr.get(1).split(" ")));
        ArrayList<String> blackPosStr = new ArrayList<String>(Arrays.asList(stringArr.get(2).split(" ")));
        for (String s: greenPosStr) {
            greenPos.add(Integer.valueOf(s));
        }
        for (String s: blackPosStr) {
            blackPos.add(Integer.valueOf(s));
        }
    }

    public int getSticks() {
        int [] isAnt = new int[logLength];
        boolean blackAnt = false;
        boolean greenAnt = false;
        for (int i = 0; i < logLength; i++) {
            if (greenPos.contains(i))
                greenAnt=true;
            if (blackPos.contains(i))
                blackAnt=true;
            if (greenAnt && blackAnt) {
                sticks++;
                if (greenPos.contains(i))
                    blackAnt=false;
                if (blackPos.contains(i))
                    greenAnt=false;
            }
        }
        for (int i = 0; i < isAnt.length; i++) {
            if (greenPos.contains(i))
                isAnt[i] = 1;
            if (blackPos.contains(i))
                isAnt[i] = -1;
            else
                isAnt[i] = 0;
        }
        for (int i = 0; i <isAnt.length ; i++) {

        }
        return sticks;
    }

    public static void main(String[] args) {
        Sample s = new Sample();
        System.out.println(s.getSticks());
    }
}
