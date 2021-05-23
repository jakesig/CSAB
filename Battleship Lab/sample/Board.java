package sample;
import javafx.scene.control.Button;
import java.util.*;

public class Board {
    private ArrayList<Coordinate> arr;
    private ArrayList<Coordinate> destroyer;
    private ArrayList<Coordinate> submarine;
    private ArrayList<Coordinate> cruiser;
    private ArrayList<Coordinate> battleship;
    private ArrayList<Coordinate> carrier;
    private ArrayList<ArrayList<Coordinate>> ships;
    public Board() {
        arr = new ArrayList<Coordinate>();
    }
    public void setShips() {
        ShipFactory factory = new ShipFactory(this);
        destroyer = factory.setRandomShip(2);
        submarine = factory.setRandomShip(3);
        cruiser = factory.setRandomShip(3);
        battleship = factory.setRandomShip(4);
        carrier = factory.setRandomShip(5);
        ships = new ArrayList<ArrayList<Coordinate>>(Arrays.asList(destroyer, submarine, cruiser, battleship, carrier));
        System.out.println(destroyer);
        System.out.println(submarine);
        System.out.println(cruiser);
        System.out.println(battleship);
        System.out.println(carrier);
    }
    public String sunk(ArrayList<Coordinate> guessed, Button[][] grid) {
        int hits = 0;
        ArrayList<Coordinate> ship;
        for (int i = 0; i < ships.size(); i++) {
            ship = ships.get(i);
            for (Coordinate coordinate : guessed) {
                for (Coordinate value : ship) {
                    if (coordinate.getX() == value.getX() && coordinate.getY() == value.getY())
                        hits++;
                }
            }
            if (hits == ship.size()) {
                if (ships.get(i).equals(destroyer)) {
                    for (Coordinate c: destroyer) {
                        grid[c.getX()][c.getY()].setStyle("-fx-background-color: #000000; ");
                    }
                    ships.remove(destroyer);
                    return "Destroyer";
                }
                if (ships.get(i).equals(submarine)) {
                    for (Coordinate c: submarine) {
                        grid[c.getX()][c.getY()].setStyle("-fx-background-color: #000000; ");
                    }
                    ships.remove(submarine);
                    return "Submarine";
                }
                if (ships.get(i).equals(cruiser)) {
                    for (Coordinate c: cruiser) {
                        grid[c.getX()][c.getY()].setStyle("-fx-background-color: #000000; ");
                    }
                    ships.remove(cruiser);
                    return "Cruiser";
                }
                if (ships.get(i).equals(battleship)) {
                    for (Coordinate c: battleship) {
                        grid[c.getX()][c.getY()].setStyle("-fx-background-color: #000000; ");
                    }
                    ships.remove(battleship);
                    return "Battleship";
                }
                if (ships.get(i).equals(carrier)) {
                    for (Coordinate c: carrier) {
                        grid[c.getX()][c.getY()].setStyle("-fx-background-color: #000000; ");
                    }
                    ships.remove(carrier);
                    return "Carrier";
                }
            }
        }
        return "None";
    }
    public void addCoord(Coordinate c) {
        arr.add(c);
    }
    public ArrayList<Coordinate> getTakenPoints() {
        return arr;
    }
    public boolean isTaken (Coordinate coord) {
        for (Coordinate c: arr) {
            if (c.getX()==coord.getX()&&c.getY()==coord.getY())
                return true;
        }
        return false;
    }
}
