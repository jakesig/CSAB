import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem2 {
    private ArrayList<String> arr;
    public Problem2() {
        arr = new ArrayList<String>();
    }
    public void read() {
        Scanner scan;
        try {
            scan = new Scanner(new File("C:\\Users\\jsigm\\Documents\\CSAB\\Quinnipiac 2017\\input.txt"));
            while (scan.hasNextLine()) {
                arr.add(scan.nextLine());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
    public ArrayList<String> getArr() {
        return arr;
    }
    public String determine(String[] array) {
        int[] intArr = new int[array.length/2];
        double[] doubleArr = new double[array.length/2];
        int iIndex = 0;
        int dIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (i==array.length-1) {
                doubleArr[dIndex++]=Double.parseDouble(array[i]);
            }
            if (i%2==0) {
                doubleArr[dIndex++]=Double.parseDouble(array[i]);
            }
            else {
                intArr[iIndex++]=Integer.parseInt(array[i]);
            }
        }
    }
}
