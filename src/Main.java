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

    static Stage window;
    static TextField lowerbound, upperbound;
    static Text output;

    public static void main(String[] args) {
        launch(args);
    }

    public static void setLowerbound(String string){
        lowerbound.setText(string);

    }

    public static void setUpperbound(String string){
        upperbound.setText(string);
    }

    public static void setOutput(String random){
        output.setText(random);
    }

    public static void buttonpress(){
        if(!lowerbound.getText().equals("")|| !upperbound.getText().equals("")){
                RandomNumberGenerator.JavaFXLauncher(lowerbound.getText(), upperbound.getText());
        }else{
            setOutput("EMPTY");
        }
    }

    @FXML
    @Override
    public void start(Stage primaryStage) throws IOException {
        window = primaryStage;
        window.setTitle("RNG");
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));

        lowerbound = (TextField) root.lookup("#lowerboundinput");
        upperbound = (TextField) root.lookup("#upperboundinput");
        output = (Text) root.lookup("#randomnumberoutput");
        Button generate = (Button) root.lookup("#generatebutton");

        generate.setOnAction( e -> buttonpress());

        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }
}
