import java.util.*;
public class Reverse {
    private Stack s;
    ArrayList<String> arr;
    public Reverse(String...arr) {
        this.arr = new ArrayList<String>(Arrays.asList(arr));
        s = new Stack();
    }
    public ArrayList<String> reverse() {
        ArrayList<String> toReturn = new ArrayList<String>();
        while (!arr.isEmpty()) {
            s.push(arr.remove(0));
        }
        while(!s.isEmpty()) {
            toReturn.add((String)s.pop());
        }
        return toReturn;
    }
    public static void main(String[] args) {
        Reverse r = new Reverse("He", "Hi", "Ho", "Ha");
        System.out.println(r.arr);
        System.out.println(r.reverse());
    }
}
