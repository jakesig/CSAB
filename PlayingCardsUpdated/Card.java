import java.util.*;
/**
 * Write a description of class Card here.
 *
 * @author (Jacob Sigman)
 * @version (9/23/2019)
 */
public class Card implements Comparable<Card>
{
    //variable declaration
    
    private SUITS suit;
    private RANKS rank;

    //Constructor creates a new card

    public Card(int s, int r) {
        suit = SUITS.values()[s];
        rank = RANKS.values()[r];
    }

    public Card(Card other) {
        suit = other.getSuit();
        rank = other.getRank();
    }

    public Card (SUITS s, RANKS r){
        suit = s;
        rank = r;
    }
    
    //Getters (no setters needed)
    
    public SUITS getSuit() {
        return suit;
    }
    
    public RANKS getRank() {
        return rank;
    }
    
    @Override public int compareTo(Card other) {
        if (suit.getValue()<other.suit.getValue())
            return -1;
        if (suit.getValue()>other.suit.getValue())
            return 1;
        else {
            if (rank.getValue()<other.rank.getValue())
                return -1;
            else
                return 1;
        }
    }
}
