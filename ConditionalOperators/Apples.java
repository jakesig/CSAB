import java.util.Scanner;

public class Apples {
    public static void main(String [] args) {
        System.out.print("How old are you?  ");
        Scanner scan = new Scanner(System.in);
        int result = scan.nextInt();
        boolean answer = result>50 ? true:false;
        System.out.println(answer ? "Old" : "Young");
    }
}
