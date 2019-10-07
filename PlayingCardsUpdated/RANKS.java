enum RANKS {
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    NONE(0);

    private final int value;
    private final String strValue;

    private RANKS(int value) {
        this.value = value;
        this.strValue = ""+value;
    }

    public int getValue() {
        return value;
    }

    public String getStrValue() { return strValue; }
}
