import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Huffman {
    private Scanner scan;
    private Map<Character, String> encoded;
    private String encodedString;
    private Node root;
    private String text;
    public String getText() {
        return text;
    }
    public Node getRoot() {
        return root;
    }
    public void read() {
        try {
            scan = new Scanner(new File("D:\\jsigm\\Documents\\CSAB New\\Huffman\\input.txt"));
        }
        catch (FileNotFoundException f) {
            System.out.println("File Not Found.");
        }
        while (scan.hasNextLine()) {
            text += scan.nextLine();
            text += "\n";
        }
        //text = text.toLowerCase();
    }
    public void buildHuffmanTree() {
        this.read();
        Map<Character, Integer> frequencies = new HashMap<>();
        for (int i = 0 ; i < text.length(); i++) {
//            if (!(text.charAt(i)==' ') && !Character.isLetter(text.charAt(i)))
//                continue;
            if (!frequencies.containsKey(text.charAt(i))) {
                frequencies.put(text.charAt(i), 0);
            }
            frequencies.put(text.charAt(i), frequencies.get(text.charAt(i)) + 1);
        }
        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        PriorityQueue<Node> pq = new PriorityQueue<Node>(frequencies.size(), new Comparator<Node>() {
            @Override public int compare(Node o1, Node o2) {
                return o1.freq-o2.freq;
            }
        });
        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }
        root = null;
        while (pq.size() > 1) {
            Node a = pq.poll();
            Node b = pq.poll();
            Node sum = new Node('-', a.freq+b.freq);
            sum.left = a;
            sum.right = b;
            root = sum;
            pq.add(sum);
        }
    }
}
