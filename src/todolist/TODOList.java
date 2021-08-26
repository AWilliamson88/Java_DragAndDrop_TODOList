package todolist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Andrew Williamson / P113357
 * Date: 26/08/2021
 * Java 3 AT 2 
 * Question 5
 * JMC requires the implementation of a program that can create 
 * drag and drop TODO lists on one side you should have a list of tasks 
 * on the other a list of things to do. Your program must have help files, 
 * 2D graphics with the ability to drag and drop.
 * 
 */

public class TODOList extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Drag And Drop");
        Parent root 
                = FXMLLoader.load(getClass().getResource("TODOListFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
