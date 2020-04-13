public class Node {
    public char ch;
    public int freq;
    Node left = null;
    Node right = null;
    public Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
    @Override public String toString() {
        return "Character: " + ch + "\nFrequency: " + freq;
    }
}
