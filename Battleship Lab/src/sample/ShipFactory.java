package sample;

import java.util.ArrayList;
import java.util.Random;

public class ShipFactory {
    private Board myBoard;
    private static Random generator;
    private int direction;
    public ShipFactory(Board myBoard) {
        this.myBoard = myBoard;
        generator = new Random();
    }
    public Coordinate generatePointInDirection(ArrayList<Coordinate> ship) {
        int x = ship.get(ship.size()-1).getX();
        int y = ship.get(ship.size()-1).getY();
        switch (direction) {
            case 0:
                if (myBoard.isTaken(Coordinate.newCoord(myBoard, x + 1, y)) || myBoard.isTaken(Coordinate.newCoord(myBoard, x - ship.size(), y)))
                    ;
                else if (x + 1 <= 9)
                    return Coordinate.newCoord(myBoard, x + 1, y);
                else {
                    direction = 2;
                    return Coordinate.newCoord(myBoard, x - ship.size(), y);
                }
            case 1:
                if (myBoard.isTaken(Coordinate.newCoord(myBoard, x, y+1)) || myBoard.isTaken(Coordinate.newCoord(myBoard, x, y- ship.size())))
                    ;
                else if (y + 1 <= 9)
                    return Coordinate.newCoord(myBoard, x, y + 1);
                else {
                    direction = 3;
                    return Coordinate.newCoord(myBoard, x, y - ship.size());
                }
            case 2:
                if (myBoard.isTaken(Coordinate.newCoord(myBoard, x-1, y)) || myBoard.isTaken(Coordinate.newCoord(myBoard, x+ship.size(), y)))
                    ;
                else if (x - 1 >= 0)
                    return Coordinate.newCoord(myBoard, x - 1, y);
                else {
                    direction = 0;
                    return Coordinate.newCoord(myBoard, x + ship.size(), y);
                }
            case 3:
                if (myBoard.isTaken(Coordinate.newCoord(myBoard, x, y-1)) || myBoard.isTaken(Coordinate.newCoord(myBoard, x, y+ship.size())))
                    ;
                else if (y - 1 >= 0)
                    return Coordinate.newCoord(myBoard, x, y - 1);
                else {
                    direction = 1;
                    return Coordinate.newCoord(myBoard, x, y + ship.size());
                }
        }
        return Coordinate.newCoord(myBoard, -1, -1);
    }
    public ArrayList<Coordinate> setRandomShip(int size) {
        ArrayList<Coordinate> ship = new ArrayList<Coordinate>();
        Coordinate origin = Coordinate.newCoord(myBoard, generator.nextInt(10), generator.nextInt(10));
        for (int i = 0; i < myBoard.getTakenPoints().size(); ++i)
            if (origin.getX()==myBoard.getTakenPoints().get(i).getX() && origin.getY()==myBoard.getTakenPoints().get(i).getY()) {
                origin = Coordinate.newCoord(myBoard, generator.nextInt(10), generator.nextInt(10));
                i=0;
            }
        ship.add(origin);
        myBoard.addCoord(origin);
        direction = generator.nextInt(4);
        Coordinate point = generatePointInDirection(ship);
        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < myBoard.getTakenPoints().size() ; j++) {
                if (point.getX()==myBoard.getTakenPoints().get(i).getX() && point.getY()==myBoard.getTakenPoints().get(i).getY()) {
                    point = generatePointInDirection(ship);
                    i=0;
                }
            }
            ship.add(point);
            myBoard.addCoord(point);
            point = generatePointInDirection(ship);
        }
        return ship;
    }
}
