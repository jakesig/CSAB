import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Dijkstra {
    public int evaluate(String expression) {
        int ans = 0;
        char current = ' ';
        ArrayList<Character> operators = new ArrayList<Character>(Arrays.asList('+','-','/','*'));
        Stack<Character> operator = new Stack<Character>();
        Stack<Integer> operand = new Stack<Integer>();
        if (expression.length()==0)
            return Integer.MIN_VALUE;
        for (int i = 0; i < expression.length(); i++) {
            current = expression.charAt(i);
            //If it's a number
            if (Character.isDigit(current))
                operand.push((int)current);
            //If it's an operator
            else if (operators.contains(current))
                ;
            //If it's a left parenthesis
            else if (current == '(') {
                operator.push(current);
            }
            //If it's a right parenthesis
            else if (current == ')') {

            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Dijkstra d = new Dijkstra();
    }
}