import java.util.*;
import java.io.*;
public class Rotationally {
    private ArrayList<String> strArr;
    private Scanner scan;
    private Rotationally r;
    public Rotationally() {
        strArr = new ArrayList<String>();
    }
    public static void main(String[] args) {
        Rotationally r = new Rotationally();
        r.figureItOut();
    }

    public void figureItOut() {
        boolean isEquivalent = false;
        try {
            scan = new Scanner(new File("src\\input.txt"));
        }
        catch (Exception e) {
            //Empty catch
        }
        scan.nextLine();
        while (scan.hasNextLine()){
            strArr.add(scan.nextLine());
        }
        String[] splitArr;
        for (int i = 0; i < strArr.size(); i++) {
            splitArr = strArr.get(i).split(" ");
            if (splitArr.length==1) {
                System.out.println("YES");
                continue;
            }
            for (int j = 0; j < splitArr[0].length(); j++) {
                splitArr[0]=this.rotate(splitArr[0]);
                if (splitArr[0].equals(splitArr[1])){
                    System.out.println("YES");
                    isEquivalent = true;
                    break;
                }
            }
            if (!isEquivalent) {
                System.out.println("NO");
                continue;
            }
            else {
                isEquivalent = false;
            }
        }
    }

    public String rotate(String s) {
        return s.substring(s.length()-1)+s.substring(0,s.length()-1);
    }
}
