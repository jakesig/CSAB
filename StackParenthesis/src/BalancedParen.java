import java.util.EmptyStackException;
import java.util.Stack;

public class BalancedParen {
    public static boolean balanced(String s) {
        try {
            Stack<Character> stack = new Stack();
            char thisChar = s.charAt(0);
            char toPop = 0;
            for (int i = 0; i < s.length(); i++) {
                thisChar = s.charAt(i);
                if (thisChar == '(' || thisChar == '[' || thisChar == '{') {
                    stack.push(thisChar);
                }
                if (thisChar == ')' || thisChar == ']' || thisChar == '}') {
                    toPop = stack.pop();
                    if (thisChar - toPop > 2)
                        return false;
                }
            }
            return stack.isEmpty();
        }
        catch (EmptyStackException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(balanced("{[()()]}"));
    }
}
