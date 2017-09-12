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
        Parent root = FXMLLoader.load(getClass().getResource("submenu1.fxml"));
        Stage stage = (Stage) addButton.getScene().getWindow();
        Scene scene = new Scene(root, 300, 275);
        stage.setScene(scene);
        stage.setTitle("Addition/Subtraction");



    }
}
