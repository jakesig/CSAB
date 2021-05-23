import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem1 {
    private ArrayList<String> arr;
    public Problem1() {
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
    public int determinePeak(String[] array) {
        int[] newArr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArr[i] = Integer.parseInt(array[i]);
        }
        int largest = 0;
        int currentHeight = 0;
        for (int i = 1; i < array.length; i++) {
            currentHeight+=newArr[i];
            if (currentHeight<0) {
                currentHeight=0;
            }
            if (largest<currentHeight) {
                largest = currentHeight;
            }
        }
        return largest;
    }
    public int determineEnd(String[] array) {
        int[] newArr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArr[i] = Integer.parseInt(array[i]);
        }
        int currentHeight = 0;
        for (int i = 1; i < array.length; i++) {
            currentHeight+=newArr[i];
            if (currentHeight<0) {
                currentHeight=0;
            }
        }
        return currentHeight;
    }
    public int determineClimbed(String[] array) {
        int[] newArr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArr[i] = Integer.parseInt(array[i]);
        }
        int climbed = 0;
        for (int i = 1; i < array.length; i++) {
            if (newArr[i]<=0);
            else {
                climbed+=newArr[i];
            }
        }
        return climbed;
    }
    public static void main(String[] args) {
        Problem1 p1 = new Problem1();
        p1.read();
        for (int i = 1; i < p1.getArr().size(); i++) {
            System.out.print(p1.determinePeak(p1.getArr().get(i).split(" "))+" ");
            System.out.print(p1.determineEnd(p1.getArr().get(i).split(" "))+" ");
            System.out.println(p1.determineClimbed(p1.getArr().get(i).split(" ")));
        }

    }
}
