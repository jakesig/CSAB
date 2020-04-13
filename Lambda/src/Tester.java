public class Tester {
    public static void main(String[] args) {
        Adder a = (arr) -> {
            int sum = 0;
            for (int i : arr) {
                sum+=i;
            }
            return sum;
        };
        int[] arr = {1,2,3,4,5};
        System.out.println(a.add(arr));
    }
}
