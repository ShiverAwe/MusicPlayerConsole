import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Main extends Application{
    @Override
    public void start(Stage primaryStage) {



    }

    public static void main(String[] args) {
        Player player = new Player();
        player.playLine(NoteLine.getDemoLine());
        //launch(args);
    }
}
