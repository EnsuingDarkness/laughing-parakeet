package NumSense;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class primaryController {
    @FXML private Button addButton;
    @FXML protected void handledoAction(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("add.fxml"));
        Scene addScene = new Scene(root, 300, 275);
        Stage oldStage = (Stage) addButton.getScene().getWindow();
        oldStage.setScene(addScene);
        oldStage.setTitle("Addition Practice");


    }
}
