import java.util.*;
/**
 * @author (Jacob Sigman)
 * @version (9/23/2019)
 */
public class Deck
{
    //Variable declaration
    
    private ArrayList<Card> deck;
    private static final int MAXCARDS = 52;
    
    //Constructor that creates an empty deck
    
    public Deck() {
        deck = new ArrayList<Card>();
    }
    
    //Constructor that creates a deck of size n
    
    public Deck(int n) {
        deck = new ArrayList<Card>();
        if (n>MAXCARDS) {
            n = MAXCARDS;
            System.out.println("Number greater than 52. Deck with 52 cards will be created.");
        }
        for (int i=0; i<4; ++i) {
            for (int j = 0; j < 13; j++) {
                deck.add(new Card(i, j));
            }
        }
        for (int i = 51; i > n-1; i--) {
            deck.remove((int)(Math.random()*n));
        }
    }
    
    public int findCard(String rank, String suit) {
        SUITS numSuit=SUITS.valueOf(suit.toUpperCase());
        RANKS numRank=RANKS.NONE;
        //Determines what enum to put into the variable numRank
        for (RANKS e : RANKS.values()) {
            if (e.getStrValue().equals(rank)) {
                numRank=e;
            }
        }
        for (Card c : deck) {
            if (c.getSuit().equals(numSuit)&&c.getRank().equals(numRank)) {
                return deck.indexOf(c);
            }
        }
        return -1;
    }
    
    public void sortDeck() {
        Collections.sort(deck);
    }
    
    public void shuffleDeck() {
        Collections.shuffle(deck);
    }
    
    @Override public String toString() {
        String toPrint = "[";
        for (Card c : deck) {
            toPrint+=""+c.getRank()+" OF "+c.getSuit()+", ";
        }
        if (deck.size()!=0) {
            return toPrint+deck.get(deck.size()-1).getRank()+" OF "+deck.get(deck.size()-1).getSuit()+"]";
        }
        return toPrint+"]";
    }
    
    public boolean addCard(String rank, String suit) {
        SUITS numSuit=SUITS.valueOf(suit.toUpperCase());
        RANKS numRank=RANKS.NONE;
        //Determines what enum to put into the variable numRank.
        for (RANKS e : RANKS.values()) {
            if (e.getStrValue().equals(rank)) {
                numRank=e;
            }
        }
        int find = findCard(rank, suit);
        if (find!=-1) {
            return false;
        }
        deck.add(new Card(numSuit, numRank));
        return true;
    }
    
    //Uses the findCard function to seek out and remove a card from the deck
    
    public boolean removeCard(String cardRank, String cardSuit) {
        int find = findCard(cardRank, cardSuit);
        if (find!=-1) {
            deck.remove(find);
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if (deck.size()==MAXCARDS)
            return true;
        return false;
    }
    
    public boolean isSorted() {
        ArrayList<Card> sortedDeck = new ArrayList<Card>();
        for (Card c : deck)
            sortedDeck.add(new Card(c));
        Collections.sort(sortedDeck);
        for (int i=0; i<deck.size(); ++i) {
            if (sortedDeck.get(i).getRank()!=deck.get(i).getRank() || sortedDeck.get(i).getSuit()!=deck.get(i).getSuit())
                return false;
        }
        return true;
    }
}
