package NumSense;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

/**
 * Created by 586905 on 2/14/2017.
 */
public class intermediateController {

    @FXML AnchorPane anchorPane;

        @FXML void initialize(){
            Button toPractice = new Button("GO!");
            anchorPane.getChildren().add(toPractice);
            toPractice.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event){
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("practice.fxml"));
                        Scene addScene = new Scene(root, 300, 275);
                        Stage oldStage = (Stage) toPractice.getScene().getWindow();
                        oldStage.setScene(addScene);
                        oldStage.setTitle("Practicing...");
                    }catch(IOException e){ System.out.println("Something went wrong, closing!!!"); }

                }
            });
            Platform.runLater(() -> {
                double hdist = anchorPane.getWidth()/2 - toPractice.getWidth()/2;
                System.out.println(hdist);
                double vdist = anchorPane.getHeight()/2 - toPractice.getHeight()/2;
                System.out.println(vdist);
                anchorPane.setLeftAnchor(toPractice, hdist);
                anchorPane.setTopAnchor(toPractice, vdist);
            });

        }


}
