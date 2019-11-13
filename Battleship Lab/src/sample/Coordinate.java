package sample;

public class Coordinate {
    private int x;
    private int y;
    private static Coordinate myInstance = null;
    private Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public static final Coordinate newCoord(Board b, int x, int y) {
        if(b.getCoord(x,y)==null)
            myInstance = new Coordinate(x,y);
        return myInstance;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override public String toString() {
        return "("+x+", "+y+")";
    }
}
