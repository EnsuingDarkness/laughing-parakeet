package NumSense;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class submenu2Controller {

    //cases 12 - 23

    @FXML
    private Button b0;

    @FXML
    private void handle0() throws IOException{
        practiceController.setPracticeType(12);
        loadNextScene();
    }
    @FXML
    private void handle1() throws IOException{
        practiceController.setPracticeType(13);
        loadNextScene();
    }
    @FXML
    private void handle2() throws IOException{
        practiceController.setPracticeType(14);
        loadNextScene();
    }

    private void loadNextScene() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("add.fxml"));
        Scene addScene = new Scene(root, 300, 275);
        Stage oldStage = (Stage) b0.getScene().getWindow();
        oldStage.setScene(addScene);
        oldStage.setTitle("Practice");
    }
}
