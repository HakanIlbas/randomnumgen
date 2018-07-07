import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    @Override
    public void start(Stage primaryStage) throws IOException {
        window = primaryStage;
        window.setTitle("Random Number Generator");
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));

        TextField lowerbound = (TextField) root.lookup("#lowerboundinput");
        TextField upperbound = (TextField) root.lookup("#upperboundinput");
        Text output = (Text) root.lookup("#randomnumbertext");
        Button generate = (Button) root.lookup("#generatebutton");

        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }
}
