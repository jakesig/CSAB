import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Prob02 {
    private static ArrayList<String> arr = new ArrayList<String>();

    public void read() {
        Scanner scan = null;
        try {
            scan = new Scanner(new File("C:\\Users\\jsigm\\Documents\\CSAB\\CodeQuest2015\\Prob02.in.txt"));
        }
        catch (Exception e) {
            //Empty catch
        }
        while(scan.hasNextLine()) {
            arr.add(scan.nextLine());
        }
    }
    public void sumItUp() {
        BigInteger sum = BigInteger.ZERO;
        BigInteger num;
        for (int i = 2; i < arr.size() ; i++) {
            num = new BigInteger(arr.get(i));
            sum=sum.add(num);
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Prob02 p = new Prob02();
        p.read();
        p.sumItUp();
    }
}
