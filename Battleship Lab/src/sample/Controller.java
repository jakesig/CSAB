package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.*;

public class Controller extends Application implements EventHandler<ActionEvent> {
    private GridPane pane;
    private Scene scene;
    private Button[][] grid;
    private Board myBoard;
    private static final int GRIDSIZE = 10;
    private ArrayList<Coordinate> guessed = new ArrayList<Coordinate>();
    @Override public void start(Stage stage) {
        myBoard = new Board();
        myBoard.setShips();
        pane = new GridPane();
        scene = new Scene(pane, GRIDSIZE*50,GRIDSIZE*50);
        stage.setTitle("BattleShip");
        setButtons();
        stage.setScene(scene);
        stage.show();
    }
    @Override public void handle(ActionEvent event) {
        Coordinate coord = Coordinate.newCoord(myBoard, 10, 10);
        boolean correct = false;
        int x = 0;
        int y = 0;
        for (int i = 0; i <GRIDSIZE; i++) {
            for (int j = 0; j <GRIDSIZE; j++) {
                if (event.getSource()==grid[i][j]){
                    coord = Coordinate.newCoord(myBoard, i, j);
                }
            }
        }
        for (Coordinate c : myBoard.getTakenPoints()) {
            if (c.getX()==coord.getX() && c.getY()==coord.getY()) {
                x = c.getX();
                y = c.getY();
                grid[x][y].setStyle("-fx-background-color: #ff0000; ");
                grid[x][y].setPrefSize(GRIDSIZE*5,GRIDSIZE*5);
                guessed.add(c);
                correct = true;
                break;
            }
        }
        if (!correct) {
            guessed.add(coord);
            grid[coord.getX()][coord.getY()].setStyle("-fx-background-color: #ffffff; ");
        }

    }
    public void setButtons() {
        grid = new Button[GRIDSIZE][GRIDSIZE];
        for (int i = 0; i < GRIDSIZE; i++) {
            for (int j = 0; j < GRIDSIZE; j++) {
                grid[i][j] = new Button();
                grid[i][j].setPrefSize(GRIDSIZE*5,GRIDSIZE*5);
                grid[i][j].setStyle("-fx-background-color: #808080; ");
                pane.add(grid[i][j],i,j);
                grid[i][j].setOnAction(this);
            }
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
