public class Fibonacci {
    public int calculate(int n) {
        if (n==1 || n==2) {
            return 1;
        }
        return calculate(n-1)+calculate(n-2);
    }

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        for (int i = 0; i < 48 ; i++) {
            System.out.println(fib.calculate(i+1));
        }
    }
}
