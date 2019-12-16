import java.util.ArrayList;
public class CircularQueue {
    public Node thisNode;
    private Node lastNode;
    private int size;
    public CircularQueue(int size) {
        thisNode = new Node(1);
        Node current = thisNode;
        for (int i = 1; i < size; i++) {
            current.next = new Node(i+1);
            current = current.next;
        }
        this.size = size;
        current.next = thisNode;
    }
    @Override public String toString() {
        String toReturn = "";
        Node current = thisNode;
        while (current.next!=null) {
            toReturn += current.nodeID + "\n";
            current = current.next;
        }
        return toReturn;
    }
    public int execute() {
        Node current = thisNode;
        while (size!=1) {
            current.next = current.next.next;
            current = current.next;
            size--;
        }
        return current.nodeID;
    }
}
class Node {
    public int nodeID;
    public Node next;
    public boolean hasSword;
    public Node(int obj) {
        this.nodeID = obj;
    }
    @Override public String toString() {
        return ""+nodeID;
    }
    public static void main(String[] args) {
        //Tester Code
        CircularQueue list = new CircularQueue(229);
        System.out.println(list.execute());
    }
}
