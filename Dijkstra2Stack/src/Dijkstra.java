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
            //If it's an operator
            if (operators.contains(s)) {
                operator.push(s);
            }
            //If it's a right parenthesis
            else if (!s.equals(")")){
                operand.push(Integer.parseInt(s));
            }
            if (!operand.isEmpty()&&s.equals(")")) {
                operand.push(useOp(operator.pop(),operand.pop(),operand.pop()));
                //operator.pop();
            }
        }
        while (!operator.isEmpty()) {
            operand.push(useOp(operator.pop(),operand.pop(),operand.pop()));
        }
        ans=(int)operand.pop();
        return ans;
    }
    public Integer useOp(String op, Integer i1, Integer i2) {
        if (op.equals("+")) {
            return i1+i2;
        }
        if (op.equals("-")) {
            return i1-i2;
        }
        if (op.equals("*")) {
            return i1*i2;
        }
        if (op.equals("/")) {
            return i1/i2;
        }
        return -1;
    }
    public static void main(String[] args) {
        Dijkstra d = new Dijkstra();
        System.out.println(d.evaluate("( 1 + ( 2 * 3 ) )"));
    }
}