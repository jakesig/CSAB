import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Controller extends Application implements EventHandler<ActionEvent> {
    private GridPane pane;
    private Scene scene;
    private Button[][] grid;
    private Board myBoard;
    private static final int GRIDSIZE = 10;
    @Override public void start(Stage stage) {
        pane = new GridPane();
        scene = new Scene(pane, GRIDSIZE*50,GRIDSIZE*50);
        setButtons();
        stage.setScene(scene);
        stage.show();
    }
    @Override public void handle(ActionEvent event) {
        System.out.println("Button Clicked");
    }
    public void setButtons() {
        grid = new Button[GRIDSIZE][GRIDSIZE];
        for (int i = 0; i < GRIDSIZE; i++) {
            for (int j = 0; j < GRIDSIZE; j++) {
                grid[i][j] = new Button("");
                grid[i][j].setPrefSize(GRIDSIZE*5,GRIDSIZE*5);
                pane.add(grid[i][j],i,j);
                grid[i][j].setOnAction(this);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
