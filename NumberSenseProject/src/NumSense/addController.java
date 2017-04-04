package NumSense;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

/**
 * Created by 586905 on 2/14/2017.
 */
public class addController {
    @FXML private Button toPractice;



        @FXML protected void handlegoToPractice(ActionEvent event) throws IOException{
            practiceController.setProblemType(0);
            Parent root = FXMLLoader.load(getClass().getResource("practice.fxml"));
            Scene addScene = new Scene(root, 300, 275);
            Stage oldStage = (Stage) toPractice.getScene().getWindow();
            oldStage.setScene(addScene);
            oldStage.setTitle("GO!");
    }

}
