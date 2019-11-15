package sample;
import java.util.ArrayList;
import java.util.Random;
public class Board {
    private Coordinate[][] board;
    private ArrayList<Coordinate> arr;
    private ArrayList<Coordinate> destroyer;
    private ArrayList<Coordinate> submarine;
    private ArrayList<Coordinate> cruiser;
    private ArrayList<Coordinate> battleship;
    private ArrayList<Coordinate> carrier;
    public Board() {
        board = new Coordinate[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = Coordinate.newCoord(this, i, j);
            }
        }
        arr = new ArrayList<Coordinate>();
    }
    public void setShips() {
        //Pick random point to determine origin of ship
        ShipFactory factory = new ShipFactory(this);
        destroyer = factory.setRandomShip(2);
        submarine = factory.setRandomShip(3);
        cruiser = factory.setRandomShip(3);
        battleship = factory.setRandomShip(4);
        carrier = factory.setRandomShip(5);
        System.out.println(destroyer);
        System.out.println(submarine);
        System.out.println(cruiser);
        System.out.println(battleship);
        System.out.println(carrier);
    }
    public ArrayList<Coordinate> getTakenPoints() {
        return arr;
    }
    public void addCoord(Coordinate c) {
        arr.add(c);
    }
}
