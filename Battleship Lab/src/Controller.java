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
    @Override public void start(Stage stage) {
        pane = new GridPane();
        scene = new Scene(pane, 500,500);
        setButtons();
        stage.setScene(scene);
        stage.show();
    }

    @Override public void handle(ActionEvent event) {

    }

    public static void main(String[] args) {
        launch(args);
    }

    public void setButtons() {
        grid = new Button[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = new Button("");
                grid[i][j].setPrefSize(50,50);
                pane.add(grid[i][j],i,j);
                grid[i][j].setOnAction(this);
            }
        }
    }
}
