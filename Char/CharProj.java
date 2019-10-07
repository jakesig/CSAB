import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CharProj {
    private Scanner scan;
    public ArrayList<Character> getChars() {
        ArrayList<Character> charArr = new ArrayList<Character>();
        ArrayList<String> stringArr = new ArrayList<String>();
        try {
            this.scan = new Scanner(new File("H:\\CSAB Library\\Quarter 1\\Char Project\\input.txt"));
        }
        catch (FileNotFoundException f) {
            System.out.println("Error: File not found");
        }
        while (scan.hasNext()) {
            stringArr.add(scan.next());
            if (scan.hasNext())
                stringArr.add(" ");
        }
        for (int i = 0; i < stringArr.size() ; i++) {
            for (int j = 0; j < stringArr.get(i).length(); j++) {
                charArr.add(stringArr.get(i).charAt(j));
            }
        }
        return charArr;
    }

    public static void main(String[] args) {
        CharProj cp = new CharProj();
        ArrayList<Character> chars = cp.getChars();
        System.out.println(chars);
    }
}
