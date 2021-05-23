import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HuffmanTransmitter {
    private Huffman thisHuffman;
    private Map<Character, String> encoded;
    private String text;
    private Scanner scan;
    private String encodedString;
    private Node root;
    public HuffmanTransmitter(Huffman h) {
        thisHuffman = h;
        encoded = new HashMap<Character, String>();
        text = h.getText();
        root = thisHuffman.getRoot();
    }
    public String getText() {
        return text;
    }
    public Node getRoot() {
        return root;
    }
    public void encode(Node root, String code, Map<Character, String> huff) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            huff.put(root.ch, code);
        }
        encode(root.left, code + "0", huff);
        encode(root.right, code + "1", huff);
    }
    public String getEncodedString() {
        return encodedString;
    }
    public void write(String str) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File("encoded.txt"));
        }
        catch (FileNotFoundException f) {
            System.out.println("File Not Found.");
        }
        pw.write(str);
        pw.close();
    }
    public void run() {
        this.encode(thisHuffman.getRoot(), "", encoded);
        for (Map.Entry<Character, String> entry : encoded.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        encodedString = "";
        for (int i = 0; i < text.length(); i++) {
//            if (!(text.charAt(i)==' ') && !Character.isLetter(text.charAt(i)))
//                continue;
            encodedString+=encoded.get(text.charAt(i));
        }
        this.write(encodedString);
    }
}
