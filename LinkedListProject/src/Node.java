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
        list.insertFirstLink("Kurtzman", 15);
        list.insertFirstLink("Lemon", 12);
        list.display();
    }
}

class LinkedList {
    public Node firstLink;
    public LinkedList() {
        firstLink = null;
    }
    public boolean isEmpty() {
        return (firstLink==null);
    }
    public void insertFirstLink(String str, int num) {
        Node newNode = new Node(str, num);
        newNode.next = firstLink;
        firstLink = newNode;
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
    public void display() {
        Node node = firstLink;
        while (node!=null) {
            node.display();
            System.out.println("Next Node: "+node.next);
            node = node.next;
            System.out.println();
        }
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
    public Node removeNode(String str) {
        Node current = firstLink;
        Node previous = firstLink;
        while(!current.data.equals(str)) {
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
}