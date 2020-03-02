import java.util.*;

public class Converter {
    private final Set<Character> open= new HashSet<Character>(Arrays.asList('(','{','['));
    private final Set<Character> closed= new HashSet<Character>(Arrays.asList(')','}',']'));
    private final ArrayList<Character> operators = new ArrayList<Character>(Arrays.asList('(','*','/','+','-'));
    public boolean isOpenParen(char token) {
        return open.contains(token);
    }
    public boolean isClosedParen(char token) {
        return closed.contains(token);
    }
    public boolean hasPrecedence(char a, char b) {
        return operators.indexOf(a)>operators.indexOf(b);
    }
    public String infixToPostfix(String exp) {
        String result = "";
        Stack<Character> stack = new Stack<Character>();
        char[] charArr = exp.toCharArray();
        for (char c : charArr) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                case '}':
                case ']':
                    while (!stack.isEmpty() && !open.contains(stack.peek()))
                        result+=stack.pop();
                    stack.pop();
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!stack.isEmpty() && hasPrecedence(stack.peek(), c))
                        result+=stack.pop();
                    stack.push(c);
                    break;
                default:
                    result+=c;
                    break;
            }
        }
        while (!stack.isEmpty())
            result+=stack.pop();
        return result;
    }
    public static void main(String[] args) {
        Converter c = new Converter();
        System.out.println(c.infixToPostfix("2+(3-(4*5)+1)"));
    }
}
