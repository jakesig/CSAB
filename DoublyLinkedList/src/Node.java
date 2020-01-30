import java.util.ArrayList;

public class Node {
    public Object data;
    public Node next;
    public Node previous;
    public Node(Object data) {
        this.data=data;
    }
    @Override public String toString() {
        return ""+data;
    }

    public static void main(String[] args) {
        TwoWayLinkedList dl = new TwoWayLinkedList();
        dl.add(7);
        dl.add(8);
        dl.add(4);
        dl.add(6);
        Node current = dl.firstLink;
        System.out.println("Parse Forwards");
        for(int i = 0; i<dl.size(); ++i) {
            System.out.println(current);
            if (current.next!=null)
                current=current.next;
        }
        System.out.println("Parse Backwards");
        for (int i = 0; i <dl.size() ; i++) {
            System.out.println(current);
            current=current.previous;
        }
    }
}
class TwoWayLinkedList {
    public Node firstLink;
    private int size;
    public TwoWayLinkedList() {
        firstLink = null;
    }
    public boolean isEmpty() {
        return (firstLink==null);
    }
    public int size() {
        return size;
    }
    @Override public String toString() {
        String s = "";
        Node node = firstLink;
        while (node!=null) {
            s=s+"Previous: "+node.previous;
            s=s+"\nValue: "+node.toString();
            s=s+"\nNext: "+node.next;
            node = node.next;
            s=s+"\n";
        }
        return s;
    }
    public ArrayList<Node> navigate(int index) {
        ArrayList<Node> arr = new ArrayList<Node>();
        int i = 0;
        if (index>=this.size) {
            throw (new ArrayIndexOutOfBoundsException());
        }
        Node current = firstLink.next;
        while(i<index-1) {
            current = current.next;
            i++;
        }
        arr.add(current.previous);
        arr.add(current);
        return arr;
    }
    public void add(Object obj) {
        Node newNode = new Node(obj);
        newNode.next = firstLink;
        firstLink = newNode;
        size++;
        if (this.size()>1) {
            newNode.next.previous = newNode;
        }
    }
    public Node get(int index) {
        if (this.isEmpty()) {
            return null;
        }
        if (index==0) {
            return firstLink;
        }
        ArrayList<Node> toGet = this.navigate(index);
        return toGet.get(1);
    }
    public void set(Object obj, int index) {
        if (this.isEmpty()) {
            return;
        }
        if (index==0) {
            Node temp = firstLink.next;
            firstLink = new Node(obj);
            firstLink.next = temp;
            return;
        }
        ArrayList<Node> alter = this.navigate(index);
        alter.get(0).next = new Node(obj);
        alter.get(0).next.previous = alter.get(0);
        alter.get(0).next.next = alter.get(1).next;
        alter.get(0).next.next.previous = alter.get(0).next;
    }
    public void insert(Object obj, int index) {
        if (this.isEmpty()) {
            return;
        }
        if (index==0) {
            this.add(obj);
            return;
        }
        ArrayList<Node> alter = this.navigate(index);
        alter.get(0).next = new Node(obj);
        alter.get(0).next.previous = alter.get(0);
        alter.get(0).next.next = alter.get(1);
        alter.get(0).next.next.previous = alter.get(0).next;
        size++;
    }
    public Node remove(Object obj) {
        if (this.isEmpty()) {
            return null;
        }
        Node current = firstLink;
        while(current.data!=obj) {
            if (current.next==null) {
                return null;
            }
            else {
                current = current.next;
            }
        }
        if (current == firstLink) {
            firstLink = firstLink.next;
        }
        else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
        return current;
    }
    public void remove(int index) {
        if (this.isEmpty()) {
            return;
        }
        if (index ==0) {
            firstLink=firstLink.next;
            return;
        }
        ArrayList<Node> alter = this.navigate(index);
        alter.get(0).next = alter.get(1).next;
        alter.get(1).next.previous = alter.get(0);
    }
}