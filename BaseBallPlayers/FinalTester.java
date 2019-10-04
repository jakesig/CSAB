public class FinalTester {
    private final int X;

    public FinalTester() {
        X=7;
    }

    public static void main(String[] args) {
        final int y = 9;
        FinalTester a = new FinalTester();
        System.out.printf("%d\n", a.X);
        System.out.println(y);
    }
}
