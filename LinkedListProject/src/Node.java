import java.util.ArrayList;

public class Node {
    public Object data;
    public Node next;
    public Node(Object obj) {
        this.data = obj;
    }
    @Override public String toString() {
        return ""+data;
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(3);
        list.add(7);
        list.add(5);
        list.add(7);
        list.add(6);
        System.out.println(list);
        System.out.println(list);
    }
}

class LinkedList {
    public Node firstLink;
    private int size;
    public LinkedList() {
        firstLink = null;
    }
    public boolean isEmpty() {
        return (firstLink==null);
    }
    public int size() {
        return size;
    }
    public ArrayList<Node> navigate(int index) {
        ArrayList<Node> arr = new ArrayList<Node>();
        int i = 0;
        if (index>=this.size) {
            throw (new ArrayIndexOutOfBoundsException());
        }
        Node current = firstLink.next;
        Node previous = firstLink;
        while(i<index-1) {
            previous = current;
            current = current.next;
            i++;
        }
        arr.add(previous);
        arr.add(current);
        return arr;
    }
    public void add(Object obj) {
        Node newNode = new Node(obj);
        newNode.next = firstLink;
        firstLink = newNode;
        size++;
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
        alter.get(0).next.next = alter.get(1).next;
    }
    public void insert(Object obj, int index) {
        if (this.isEmpty()) {
            return;
        }
        if (index==0) {
            Node temp = firstLink;
            firstLink = new Node(obj);
            firstLink.next = temp;
            return;
        }
        ArrayList<Node> alter = this.navigate(index);
        alter.get(0).next = new Node(obj);
        alter.get(0).next.next = alter.get(1);
        size++;
    }
    @Override public String toString() {
        String s = "";
        Node node = firstLink;
        while (node!=null) {
            s=s+node.toString();
            s=s+"\nNext: "+node.next;
            node = node.next;
            s=s+"\n";
        }
        return s;
    }
    public Node remove(Object obj) {
        if (this.isEmpty()) {
            return null;
        }
        Node current = firstLink;
        Node previous = firstLink;
        while(current.data!=obj) {
            if (current.next==null) {
                return null;
            }
            else {
                previous = current;
                current = current.next;
            }
        }
        if (current == firstLink) {
            firstLink = firstLink.next;
        }
        else {
            previous.next = current.next;
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
    }
}