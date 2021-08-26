package todolist;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.*;
import javafx.scene.text.Text;
import java.awt.Desktop;
import java.net.URI;

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

public class Controller implements Initializable {

    @FXML
    private Text source = new Text();

    private Text target = new Text();

    private URI help;

    @FXML
    private void setOnDragDetected(MouseEvent event) {

        source = (Text) event.getSource();

        /* drag was detected, start drag-and-drop gesture*/
        Dragboard db = source.startDragAndDrop(TransferMode.MOVE);

        ClipboardContent content = new ClipboardContent();

        /* put a string / Text  on the dragboard */
        content.putString(source.getText());
        db.setContent(content);

        event.consume();
    }

    /* data is dragged over the target */
    @FXML
    private void dragOver(DragEvent event) {

        /* accept it only if it is not dragged from the same node 
        * and if it has a string data */
        if (event.getDragboard().hasString()
                && event.getGestureSource() != event.getGestureTarget()) {

            /* allow for moving */
            event.acceptTransferModes(TransferMode.MOVE);
        }
        event.consume();
    }

    /* data dropped */
    @FXML
    private void dragDropped(DragEvent event) {

        Dragboard db = event.getDragboard();

        boolean success = false;
        /* if there is a string data on dragboard, read it and use it */
        if (db.hasString()) {

            target = (Text) event.getGestureTarget();
            target.setText(db.getString());

            success = true;
        }
        /* let the source know whether the string was successfully * transferred and used */
        event.setDropCompleted(success);
        event.consume();
    }

    /* 
    The drag event is finished, replace the original word with a blank line.
     */
    @FXML
    private void dragDone(DragEvent event) {

        if (event.getTransferMode() == TransferMode.MOVE) {
            source = (Text) event.getGestureSource();
            source.setText("___________");
        }
    }

    /* Open the JavaFX website if the help button is pressed. */
    @FXML
    private void buttonClicked(ActionEvent event) {

        String url = "https://openjfx.io/javadoc/15/index.html";

        try {
            help = new URI(url);
            Desktop.getDesktop().browse(help);

        } catch (Exception e) {
            System.out.println("Unable to open help.\n" + e);
        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
