public class SwitchPractice {
    public static void main(String[] args) {
        int score = 7;
        switch (score) {
            case 90: //Constants only. Not condtitional.
                System.out.println("Lovely.");
                break;
            case 60:
                System.out.println("Borderline fail.");
                break;
            case 30:
                System.out.println("Whoops.");
            default:
                System.out.println("What?");
                break;
        }
    }
}
