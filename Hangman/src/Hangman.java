public class Hangman {
    private StringBuilder word;
    private StringBuilder lettersMissed;
    private StringBuilder gameplay;
    private int maxMisses;
    private int misses;
    private boolean gameOver;
    public Hangman (String word, int maxMisses) {
        this.word=new StringBuilder(word);
        this.lettersMissed=new StringBuilder("Letters Missed: ");
        this.gameplay=new StringBuilder(word.length());
        for (int i = 0; i <word.length() ; i++) {
            gameplay.append('-');
        }
        System.out.println(gameplay);
        this.maxMisses=maxMisses;
        this.misses=0;
        gameOver=false;
    }
    public void guess (char letter) {
        for (int i = 0; i < word.length() ; i++) {
            if (word.charAt(i)==letter) {
                System.out.println(correct(letter));
                return;
            }
        }
        System.out.println(lettersMissed(letter));
    }
    //Guess the specified letter.

    public StringBuilder correct(char goodGuess) {
        if (gameplay==word)
            System.out.println(gameWon());
        for (int i = 0; i <gameplay.length() ; i++) {
            if (word.charAt(i)==goodGuess) {
                gameplay.setCharAt(i,goodGuess);
            }
        }
        return gameplay;
    }
    public StringBuilder lettersMissed(char miss) {
        if (++misses>=maxMisses) {
            return gameOver();
        }
        lettersMissed.append(miss+"\t");
        return lettersMissed;
    }
    public StringBuilder gameOver () {
        gameOver=true;
        return new StringBuilder("The game is over. You lost. The word was \""+word+"\".");
    }
    public StringBuilder gameWon () {
        gameOver=true;
        return new StringBuilder("You won!");
    }
    public boolean isGameOver() {
        return gameOver;
    }
}
