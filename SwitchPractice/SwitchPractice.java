import java.sql.SQLOutput;

public class SwitchPractice {
    public static void main(String[] args) {
        int y = 40;
        int z = 50;
        int x = 61;
        switch (y) {
            default:
                System.out.println("Breakfast.");
            case 40:
                switch (z) {
                    case 30:
                        System.out.println("You lose.");
                        break;
                    case 50:
                        switch (x) {
                            case 75:
                                System.out.println("Life gave you lemons");
                                break;
                            case 82:
                                System.out.println("Good morning");
                                break;
                            case 61:
                                System.out.println("Okay");
                                x=43;
                            default:
                                System.out.println("Whoops.");
                        }
                        break;
                    case 93:
                        System.out.println("Switch");
                    case 43:
                        System.out.println("Welcome to Westhill High.");
                        break;
                }
            case 3:
                System.out.println("Wow.");
                break;
            case 56:
                System.out.println("Lovely.");
                break;
        }
    }
}
