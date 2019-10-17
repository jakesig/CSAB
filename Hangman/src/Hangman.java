public class Hangman {
    private String word;
    private int maxMisses;

    public Hangman (String word, int maxMisses) {
        this.word=word;
        this.maxMisses=maxMisses;
    }
    public String word () {
        return this.word;
    }
    public int maxMissesAllowed () {
        return this.maxMisses;
    }
    public void guess (char letter) {

    }
    //Guess the specified letter.

    public String correct () {

    }
    //The word with the correctly guessed letters shown. Letters not
    //yet guessed are shown as hyphens (-).

    public String lettersMissed ()
    //Erroneous guesses. Letters either are not in the word, or guessed more than once.

    public boolean gameOver ()
    //The game is over.

    public boolean gameWon ()
    //The game has been won.
}
