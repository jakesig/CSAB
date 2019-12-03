public class Node {
    public String data;
    public int otherData;
    public Node next;
    public Node(String str, int num) {
        this.data = str;
        this.otherData = num;
    }
    public void display() {
        System.out.println("String: "+data+"\nInteger: "+otherData);
    }
    @Override public String toString() {
        return data+" | "+otherData;
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertFirstNode("A", 3);
        list.insertFirstNode("B", 7);
        list.insertFirstNode("C", 9);
        list.insertFirstNode("D", 7);
        //list.removeNode(7);
        System.out.println(list);
        list.removeLast(list.firstLink);
        System.out.println(list);
    }
}

class LinkedList {
    public Node firstLink;
    public int size;
    public LinkedList() {
        firstLink = null;
    }
    public boolean isEmpty() {
        return (firstLink==null);
    }
    public void insertFirstNode(String str, int num) {
        Node newNode = new Node(str, num);
        newNode.next = firstLink;
        firstLink = newNode;
        size++;
    }
    public Node removeFirst() {
        Node nodeRef = firstLink;
        if(!isEmpty()) {
            firstLink = firstLink.next;
        }
        else {
            System.out.println("Empty LinkedList");
        }
        return nodeRef;
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
    public Node find(String str) {
        Node node = firstLink;
        if (!isEmpty()) {
            while (!node.data.equals(str)) {
                if (node.next == null) {
                    return null;
                }
                else {
                    node = node.next;
                }
            }
        }
        else {
            System.out.println("Empty Linked List");
        }
        return node;
    }
    public Node removeNode(int num) {
        Node current = firstLink;
        Node previous = firstLink;
        while(current.otherData!=num) {
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
    public void removeLast(Node front) {
        if (front==null) {
            return;
        }
        Node temp = front.next;
        Node prev = front;
        while (temp.next!=null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next=null;
    }
}