import java.util.*;
/**
 * This is the test class you must use to test your code.
 * 
 * @author (Daniel Scalzi) 
 * @version (Due 3/27/15)
 */
public class DeckRunner
{
    public static void main(String [] args){
        System.out.print("\f"); //Clears the console
        
        System.out.println("Original Decks:");
        //Deck error = new Deck(-34); //Use this line to view the error message and handling
        Deck d = new Deck(52);
        Deck s = new Deck(20);
        Deck zero = new Deck();
        Deck zero2 = new Deck(0);
        System.out.println(d +"\n" + s + "\n" + zero + "  " + zero2 +
        " Empty Decks, the first was created with the zero-argument constructor");
        System.out.println("Is the first deck full? " +d.isFull() + "\nIs the second deck full? " 
        + s.isFull());
        System.out.println("\nShuffled");
        
        d.shuffleDeck();
        s.shuffleDeck();
        System.out.println(d + "\n" + s);
        System.out.println("Are they sorted? " + d.isSorted());
        
        System.out.println("\nSorted");
        
        d.sortDeck();
        s.sortDeck();
        
        System.out.println(d + "\n" + s);
        
        System.out.println("Are they sorted? " + d.isSorted());
        
        System.out.println("\nCan we add the Five of Hearts to the first deck? " +
        d.addCard("5", "Hearts"));
        System.out.println("Can we add the Five of Hearts to the second deck? " +
        s.addCard("5", "Hearts"));
        System.out.println(s);
        
        System.out.println("\nCan we remove the Five of Hearts from the second deck? " +
        s.removeCard("5", "Hearts"));
        System.out.println(s);
        System.out.println("Can we remove the Five of Hearts from the second deck again? " +    s.removeCard("5", "Hearts"));
    }
}
