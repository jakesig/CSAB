package sample;

import java.lang.reflect.Array;
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
    private static Random generator = new Random();

    public Board() {
        board = new Coordinate[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = Coordinate.newCoord(this, i, j);
            }
        }
        arr = new ArrayList<Coordinate>();
    }

    public void setCoord(int r, int c, Coordinate coord) {
        board[r][c] = coord;
    }

    public Coordinate getCoord(int r, int c) {
        return board[r][c];
    }

    public void setShips() {
        //Pick random point to determine origin of ship
        destroyer = setRandomShip(2);
        submarine = setRandomShip(3);
        cruiser = setRandomShip(3);
        battleship = setRandomShip(4);
        carrier = setRandomShip(5);
        System.out.println(destroyer);
        System.out.println(submarine);
        System.out.println(cruiser);
        System.out.println(battleship);
        System.out.println(carrier);
    }
    public Coordinate generatePointInDirection(ArrayList<Coordinate> ship, int direction) {
        int x = ship.get(ship.size()-1).getX();
        int y = ship.get(ship.size()-1).getY();
        if (direction == 0) {
            if (!(x + 1 > 9))
                return Coordinate.newCoord(this, x + 1, y);
            else
                direction = 2;
        }
        if (direction == 1) {
            if (!(y + 1 > 9))
                return Coordinate.newCoord(this, x, y + 1);
            else
                direction = 3;
        }
        if (direction == 2) {
            if (!(x - 1 < 0))
                return Coordinate.newCoord(this, x - 1, y);
            else
                direction = 0;
        }
        if (direction == 3) {
            if (!(y - 1 < 0))
                return Coordinate.newCoord(this, x, y - 1);
            else
                direction = 1;

        }
        return Coordinate.newCoord(this, -1, -1);
    }
    public ArrayList<Coordinate> setRandomShip(int size) {
        ArrayList<Coordinate> ship = new ArrayList<Coordinate>();
        Coordinate origin = Coordinate.newCoord(this, generator.nextInt(10), generator.nextInt(10));
        for (int i = 0; i < arr.size(); ++i)
            if (origin.getX()==arr.get(i).getX() && origin.getY()==arr.get(i).getY()) {
                origin = Coordinate.newCoord(this, generator.nextInt(10), generator.nextInt(10));
                i=0;
            }
        ship.add(origin);
        arr.add(origin);
        int direction = generator.nextInt(4);
        Coordinate point = generatePointInDirection(ship, direction);
        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < arr.size() ; j++) {
                if (point.getX()==arr.get(i).getX() && point.getY()==arr.get(i).getY()) {
                    point = generatePointInDirection(ship, direction);
                    i=0;
                }
            }
            ship.add(point);
            arr.add(ship.get(ship.size()-1));
            point = generatePointInDirection(ship, direction);
        }
        return ship;
    }
    public ArrayList<Coordinate> getTakenPoints() {
        return arr;
    }
}
