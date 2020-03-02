import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class StringStack {
    public Set<String> permute(String word) {
        String constant = "-";
        String first = constant+word;
        Set<String> set = new HashSet<String>();
        Stack<String> stack = new Stack<String>();
        stack.push(first);
        while(!stack.isEmpty()) {
            String temp = stack.pop();
            if (temp.endsWith(constant)) {
                set.add(temp.substring(0, temp.length()-1)+"\n");
            }
            else {
                String[] splitUp = temp.split(constant);
                for (int i = 0; i < splitUp[1].length(); i++) {
                    stack.push(splitUp[0]+splitUp[1].charAt(i)+constant+splitUp[1].substring(0,i)+splitUp[1].substring(i+1));
                }
            }
        }
        return set;
    }
    public static void main(String[] args) {
        StringStack ss = new StringStack();
        Set<String> set = ss.permute("free");
        int i = 1;
        for (String s : set) {
            System.out.print(i++ + ".\t"+ s);
        }
    }
}
