import java.util.Scanner;

public class HangmanTest {
    public static void main(String[] args) {
        Hangman game1 = new Hangman("aardvark", 4);
        while(!game1.isGameOver()) {
            System.out.print("Guess: ");
            Scanner scan = new Scanner(System.in);
            String letter = scan.next();
            game1.guess(letter.charAt(0));
        }
    }
}
