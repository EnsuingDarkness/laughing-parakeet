package NumSense;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;

/**
 * Created by Trent on 7/4/2017.
 */
public class resultsController {
    @FXML private Text correctText;
    @FXML private Text incorrectText;
    @FXML private Text totalText;
    @FXML private Text tpqText;
    @FXML


    void initialize() {

        DecimalFormat format = new DecimalFormat("0.##");

        int[] data = practiceController.getPracticeData();
        correctText.setText(correctText.getText() + data[0]);
        incorrectText.setText(incorrectText.getText() + (data[1] - data[0]));
        totalText.setText(totalText.getText() + data[1]);
        tpqText.setText(tpqText.getText() +  format.format(practiceController.getinitPracticeDuration()/data[1]) + " s");
        Platform.runLater(() -> {
            Stage thisStage = (Stage) correctText.getScene().getWindow();
            thisStage.setTitle("Results");
        });
    }

        @FXML
    void handleMain() throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("primary.fxml"));
            Scene mainScene = new Scene(root, 300, 275);
            Stage thisStage = (Stage) correctText.getScene().getWindow();
            thisStage.setScene(mainScene);
        }

}
