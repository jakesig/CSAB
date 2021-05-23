import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Dijkstra {
    private final ArrayList<String> operators = new ArrayList<String>(Arrays.asList("(","sqrt(","*","/","+","-"));
    public int evaluate(String expression) {
        String[] exp = expression.split(" ");
        int ans = 0;
        char current = ' ';
        Stack<String> operator = new Stack<String>();
        Stack<Integer> operand = new Stack<Integer>();
        if (expression.length()==0)
            return Integer.MIN_VALUE;
        for (String s : exp) {
            switch (s) {
                case "(":
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "sqrt":
                    operator.push(s);
                    break;
                case ")":
                    if (operator.peek().equals("sqrt"))
                        operand.push(useOp(operator.pop(),operand.pop(),0));
                    else
                        operand.push(useOp(operator.pop(),operand.pop(),operand.pop()));
                    break;
                default:
                    operand.push(Integer.parseInt(s));
                    break;
            }
        }
        return (int)operand.pop();
    }
    public Integer useOp(String op, Integer i1, Integer i2) {
        if (op.equals("+")) {
            return i1+i2;
        }
        if (op.equals("-")) {
            return i2-i1;
        }
        if (op.equals("*")) {
            return i1*i2;
        }
        if (op.equals("/")) {
            return i2/i1;
        }
        if (op.equals("sqrt")) {
            return (int) Math.sqrt(i1);
        }
        return -1;
    }
    public static void main(String[] args) {
        Dijkstra d = new Dijkstra();
        System.out.println(d.evaluate("( ( ( 3 * 8 ) + sqrt ( 25 ) ) - 10 )"));
    }
}