import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

public class HuffmanDecoder {
    private Scanner scan;
    private String text;
    private String decodedString;
    private HuffmanTransmitter thisHuffman;
    public HuffmanDecoder(HuffmanTransmitter h) {
        thisHuffman = h;
        text = h.getText();
    }
    public void read() {
        text = "";
        try {
            scan = new Scanner(new File("D:\\numsigm\\Documents\\CSAB New\\Huffman\\input.txt"));
        }
        catch (FileNotFoundException f) {
            System.out.println("File Not Found.");
        }
        while (scan.hasNextLine())
            text+=scan.nextLine();
        text = text.toLowerCase();
    }
    public void decode(Node root, String str) {
        Node current = root;
        for (int i = 0; i < str.length(); i++) {
            int num = Integer.parseInt(String.valueOf(str.charAt(i)));
            if (num == 0) {
                current = current.left;
                if (current.left == null && current.right == null) {
                    decodedString+=current.ch;
                    current = root;
                }
            }
            if (num == 1) {
                current = current.right;
                if (current.left == null && current.right == null) {
                    decodedString+=current.ch;
                    current = root;
                }
            }
        }
        decodedString = decodedString.substring(8);
    }
    public void write(String str) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File("output.txt"));
        }
        catch (FileNotFoundException f) {
            System.out.println("File Not Found.");
        }
        pw.write(str);
        pw.close();
    }
    public void run() {
        this.decode(thisHuffman.getRoot(), thisHuffman.getEncodedString());
        write(decodedString);
    }
}
