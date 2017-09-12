package NumSense;

import com.sun.org.apache.xerces.internal.dom.ParentNode;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.event.ActionListener;

public class practiceController {
    @FXML
    private Text problem;
    @FXML
    private TextField input;
    @FXML
    private Button startButton;
    @FXML private Text result;

    int num1, num2, answer;
    int correct = 0, total = 0;
    String problemText;
    static int problemT;
    boolean correctbool = false;


    private Text getProblem() {
        return problem;
    }

    private TextField getInput(){
        return input;
    }


    private String getProblemText(){
        return problemText;
    }

    public static void setProblemType(int type){
      problemT = type;
    }

    private void resetProblem(){
        switch (problemT){
            case 0:
                num1 = (int) ((Math.random()*9)+1)*1000;
                num1 += (int) ((Math.random()*9)+1)*(int) Math.pow(10, Math.random()*2);
                num2 = (int) ((Math.random()*9)+1)*1000;
                num2 += (int) ((Math.random()*9)+1)*(int) Math.pow(10, Math.random()*2);

                answer = num1 + num2;
                problemText = num1 + " + " + num2 + " = ";
                break;
            default:
                num1 = 0;
                num2 = 0;
                answer = -1;
                break;

        }
        problem.setVisible(true);
        problem.setText(getProblemText());
        input.setText("");
    }
    @FXML void handleStart(){
        resetProblem();
        startButton.setVisible(false);
        input.setVisible(true);


        Scene thisScene = problem.getScene();
        thisScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.ENTER){
                    int test = Integer.parseInt(input.getText());
                    if(test == answer){
                        result.setText("Correct");
                        result.setFill(new Color(0,1,0,1));
                        correct++;
                        correctbool = true;

                    }else{
                        result.setText("Incorrect");
                        result.setFill(Color.RED);
                        total++;
                    }
                    FadeTransition textFade = new FadeTransition(Duration.millis(500), result);
                    textFade.setFromValue(1);
                    textFade.setToValue(0);
                    textFade.setDelay(Duration.seconds(2));
                    textFade.play();

                    resetProblem();
                }

            }

        });
    }


}