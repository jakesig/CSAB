enum SUITS {
    CLUBS(0), DIAMONDS(1), HEARTS(2), SPADES(3);

    private final int value;

    private SUITS(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}