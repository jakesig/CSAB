import java.math.BigInteger;

public class Factorial {
    private static final BigInteger[] factorialArr = new BigInteger[40];
    public Factorial() {
        factorialArr[0]=BigInteger.ZERO;
        factorialArr[1]=BigInteger.ONE;
        factorialArr[2]=BigInteger.TWO;
        BigInteger num;
        for (int i = 3; i<40; i++) {
            num = new BigInteger(""+i);
            BigInteger temp = num.multiply(factorialArr[i-1]);
            factorialArr[i] = temp;
        }
    }
    public BigInteger calculate(int n) {
        return factorialArr[n];
    }

    public static void main(String[] args) {
        Factorial fact = new Factorial();
        System.out.println(fact.calculate(20));
    }
}
