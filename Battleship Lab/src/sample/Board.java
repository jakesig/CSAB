package sample;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Board {
    private Coordinate[][] board;

    public Board() {
        board = new Coordinate[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = Coordinate.newCoord(this, i, j);
            }
        }
    }

    public void setCoord(int r, int c, Coordinate coord) {
        board[r][c] = coord;
    }

    public Coordinate getCoord(int r, int c) {
        return board[r][c];
    }

    public void setShips() {
        ArrayList<Coordinate> arr = new ArrayList<Coordinate>();
        //Pick random point to determine origin of ship
        Random generator = new Random();
        Coordinate origin = Coordinate.newCoord(this, generator.nextInt(10), generator.nextInt(10));
        arr.add(origin);
        //Start with destroyer
        ArrayList<Coordinate> destroyer = new ArrayList<Coordinate>();
        destroyer.add(origin);
        //Then Submarine
        Coordinate origin2 = Coordinate.newCoord(this, generator.nextInt(10), generator.nextInt(10));
        /*while (origin2.getX()==origin.getX() && origin2.getY()==origin.getY()) {
            origin2 = Coordinate.newCoord(this, generator.nextInt(10), generator.nextInt(10));
        }*/
        arr.add(origin2);
        System.out.println(arr);
    }
}
