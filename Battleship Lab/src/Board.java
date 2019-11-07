public class Board {
    private Coordinate[][] board;
    public Board() {
        board = new Coordinate[10][10];
    }
    public void setCoord(int r, int c, Coordinate coord) {
        board[r][c] = coord;
    }
    public Coordinate getCoord(int r, int c) {
        return board[r][c];
    }
}
