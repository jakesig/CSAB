import java.util.*;
import java.io.*;

public class Sample {
    private int sticks;
    private Scanner scan;
    private ArrayList<Integer> antArr;
    public Sample() {
        ArrayList<String> stringArr = new ArrayList<String>();
        ArrayList<Integer> greenPos = new ArrayList<Integer>();
        ArrayList<Integer> blackPos = new ArrayList<Integer>();
        sticks=0;
        //Read file.
        try {
            scan = new Scanner(new File("H:\\CSAB Git\\Ants on A Log\\input.txt"));//"C:\\Users\\jsigm\\Documents\\CSAB\\Ants on A Log\\input.txt"));//
        }
        catch (FileNotFoundException f) {
            System.out.println("Error: File not found");
        }
        //Make ArrayList of one string for each line.
        for (int i = 0; i < 3; i++) {
            stringArr.add(scan.nextLine());
        }
        //First String: The length of the log. Store as instance variable.
        int logLength=Integer.parseInt(stringArr.get(0));
        //Second Line: Position of Green Ants. Use String.split() to remove the spaces.
        ArrayList<String> greenPosStr = new ArrayList<String>(Arrays.asList(stringArr.get(1).split(" ")));
        //Third Line: Position of Black Ants. Use String.split() to remove the spaces.
        ArrayList<String> blackPosStr = new ArrayList<String>(Arrays.asList(stringArr.get(2).split(" ")));
        //Convert Strings in both ArrayLists to Integers. Store as separate ArrayLists.
        for (String s: greenPosStr) {
            greenPos.add(Integer.valueOf(s));
        }
        for (String s: blackPosStr) {
            blackPos.add(Integer.valueOf(s));
        }
        //Consolidate into one array of Integers using a balanced trinary model.
        Integer[] isAnt = new Integer[logLength];
        for (int i = 0; i < isAnt.length; i++) {
            if (greenPos.contains(i))
                isAnt[i] = 1;
            else if (blackPos.contains(i))
                isAnt[i] = -1;
            else
                isAnt[i] = 0;
        }
        //Put it in an ArrayList and remove all the zeros since all we need are the sign changes.
        antArr = new ArrayList<Integer>(Arrays.asList(isAnt));
        for (int i = antArr.size()-1; i >=0 ; i--) {
            if (antArr.get(i)==0)
                antArr.remove(i);
        }
    }

    public int getSticks() {
        //Determine the number of sign changes stored in variable sticks.
        for (int i = 1; i < antArr.size() ; i++) {
            if (antArr.get(i)>antArr.get(i-1) || antArr.get(i)<antArr.get(i-1))
                sticks++;
        }
        return sticks;
    }
    //Tester code
    public static void main(String[] args) {
        Sample s = new Sample();
        System.out.println(s.getSticks());
    }
}
