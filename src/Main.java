import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Main extends Application {

    static Stage window;
    static TextField lowerbound, upperbound;
    static Text output;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * setter for the lowerbound textfield
     * @param string
     */
    public static void setLowerbound(String string){
        lowerbound.setText(string);

    }

    /**
     * setter for the upperbound textfield
     * @param string
     */
    public static void setUpperbound(String string){
        upperbound.setText(string);
    }

    /**
     * setter for the output text.
     * @param random
     */
    public static void setOutput(String random){
        output.setText(random);
    }

    /**
     * Method of which its main function is more or less to check whether or not
     * input is empty.
     */
    public static void buttonpress(){
        if(!lowerbound.getText().equals("")|| !upperbound.getText().equals("")) {
                RandomNumberGenerator.JavaFXLauncher(lowerbound.getText(), upperbound.getText());
        }else{
            setOutput("EMPTY");
        }
    }

    /**
     * The primarystage consists of a small animation when generating a number
     * which basically generates a random number 20000 times to simulate an animation,
     * pause is also for the animation.
     * Then there is a functionality to skip to the next textfield when enter is pressed
     * and a functionality to generate a number when on the second textfield. 
     * @param primaryStage
     * @throws IOException
     */
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

        generate.setOnAction(e -> {
            int i =20000;
            while(i!=0) {
                PauseTransition pause = new PauseTransition(Duration.seconds(0.25));
                pause.setOnFinished(f -> {
                    buttonpress();
                });
                pause.play();
                i--;
            }

        });

        lowerbound.setOnKeyPressed( e -> {
            if (e.getCode() == KeyCode.ENTER) {
                upperbound.requestFocus();
            }
        });

        upperbound.setOnKeyPressed( e -> {
            if(e.getCode() == KeyCode.ENTER){
                generate.fire();
            }
        });

        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }
}
