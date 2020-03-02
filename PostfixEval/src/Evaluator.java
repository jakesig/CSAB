import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Evaluator {
    private final ArrayList<String> operators = new ArrayList<String>(Arrays.asList("(","sqrt(","*","/","+","-"));
    public double eval(String s) {
        String [] arr = s.split(",");
        Stack<Double> stack = new Stack<Double>();
        for (String str : arr) {
            if (operators.contains(str)) {
                stack.push(useOp(str,stack.pop(),stack.pop()));
            }
            else {
                stack.push(Double.parseDouble(str));
            }
        }
        return stack.pop();
    }
    public Double useOp(String op, Double i1, Double i2) {
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
        return -1.0;
    }

    public static void main(String[] args) {
        Evaluator e = new Evaluator();
        System.out.println(e.eval("6.4,3.2,1.7,*,-,5.7,/"));
    }
}
