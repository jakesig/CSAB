import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Controller extends Application implements EventHandler<ActionEvent> {
    private GridPane pane;
    private Scene scene;
    @Override public void start(Stage stage) {
        pane = new GridPane();
        scene = new Scene(pane, 200,300);
        stage.setScene(scene);
        stage.show();
    }

    @Override public void handle(ActionEvent event) {

    }

    public static void main(String[] args) {
        launch(args);
    }
}
