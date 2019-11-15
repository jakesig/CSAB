package sample;

import java.util.ArrayList;
import java.util.Random;

public class ShipFactory {
    private Board myBoard;
    private static Random generator;
    public ShipFactory(Board myBoard) {
        this.myBoard = myBoard;
        generator = new Random();
    }
    public Coordinate generatePointInDirection(ArrayList<Coordinate> ship, int direction) {
        int x = ship.get(ship.size()-1).getX();
        int y = ship.get(ship.size()-1).getY();
        switch (direction) {
            case 0:
                if (x + 1 <= 9)
                    return Coordinate.newCoord(myBoard, x + 1, y);
                else
                    return Coordinate.newCoord(myBoard, x-ship.size(), y);
            case 1:
                if (y + 1 <= 9)
                    return Coordinate.newCoord(myBoard, x, y + 1);
                else
                    return Coordinate.newCoord(myBoard, x, y-ship.size());

            case 2:
                if (x - 1 >= 0)
                    return Coordinate.newCoord(myBoard, x - 1, y);
                else
                    return Coordinate.newCoord(myBoard, x+ship.size(), y);

            case 3:
                if (y - 1 >= 0)
                    return Coordinate.newCoord(myBoard, x, y - 1);
                else
                    return Coordinate.newCoord(myBoard, x, y+ship.size());
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
        int direction = generator.nextInt(4);
        Coordinate point = generatePointInDirection(ship, direction);
        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < myBoard.getTakenPoints().size() ; j++) {
                if (point.getX()==myBoard.getTakenPoints().get(i).getX() && point.getY()==myBoard.getTakenPoints().get(i).getY()) {
                    point = generatePointInDirection(ship, direction);
                    i=0;
                }
            }
            ship.add(point);
            myBoard.addCoord(point);
            point = generatePointInDirection(ship, direction);
        }
        return ship;
    }
}
