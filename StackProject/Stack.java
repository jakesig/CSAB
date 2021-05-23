/*
Jacob Sigman
12/5/2019
Stack Project
 */
public class Stack {
    private Object[] arr;
    private int size;
    private static final int MAXSIZE = 100;
    public Stack() {
        arr = new Object[MAXSIZE];
        size = 0;
    }
    public int size() {
        return size;
    }
    @Override public String toString() {
        String s = "";
        for (int i = this.size()-1; i >=0; i--) {
            s+=arr[i]+"\n";
        }
        return s;
    }
    public boolean isEmpty() {
        return (size==0);
    }
    public boolean isFull() {
        return (size==MAXSIZE);
    }
    public Object peek() {
        if (this.isEmpty()) {
            return null;
        }
        return arr[size-1];
    }
    public Object pop() {
        if (this.isEmpty()) {
            System.out.println("Can't pop. Empty Stack.");
            return null;
        }
        Object toReturn = arr[size-1];
        arr[size-1] = null;
        size--;
        return toReturn;
    }
    public void push(Object obj) {
        if (this.isFull()) {
            System.out.println("Maximum size reached. Can't push.");
            return;
        }
        arr[size] = obj;
        size++;
    }
    public void clear() {
        for (int i = 0; i < size; i++) {
            arr[i] = null;
        }
        size = 0;
    }
    public static void main(String[] args) {
        //Tester Code
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(5);
        s.push(3);
    }
}
