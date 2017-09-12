package NumSense;

import com.sun.org.apache.xerces.internal.dom.ParentNode;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class practiceController {
    @FXML
    private Text problem;
    @FXML
    private TextField input;
    @FXML
    private Text result;
    @FXML
    private Rectangle pTimer;
    @FXML
    private Text timer;

    private static int correct = 0, total = 0;
    private static double practiceD, initpracticeD, answer;
    private static int problemT, pracitceT;
    private static String problemText;
    private FadeTransition textFade = new FadeTransition(Duration.millis(500));
    private ScaleTransition visualTimer = new ScaleTransition();
    private Timeline countdown = new Timeline();
    private ArrayList<Problem> problemset;

    DecimalFormat timef = new DecimalFormat("###.00");

    private Text getProblem() {
        return problem;
    }

    public static int[] getPracticeData(){
        int[] data = {correct, total};
        return data;
    }
    private void checkAnswer(String input, double key) {
        if (isNumber(input) && Double.parseDouble(input) == key) {
            result.setText("Correct");
            result.setFill(Color.GREEN);
            setCorrect(getCorrect() + 1);
        } else {
            result.setText("Incorrect");
            result.setFill(Color.RED);
        }
        result.setOpacity(1.0);
        setTotal(getTotal() + 1);

        textFade.stop();
        textFade.setDelay(Duration.millis(500));
        textFade.play();
        resetProblem();
    }

    private static String getProblemText() {
        return problemText;
    }
    private static void setProblemText(String s){problemText = s; }

    private static void setPracticeDuration(double d){practiceD = d;}
    public static double getPracticeDuration(){ return practiceD; }

    private static void setinitPracticeDuration(double d){initpracticeD = d;}
    public static double getinitPracticeDuration(){ return initpracticeD; }

    private static void setCorrect(int i){correct = i;}
    private static int getCorrect(){return correct;}

    private static void setTotal(int i ){total = i;}
    private static int getTotal(){return total;}


    public static void setProblemType(int t) {
        problemT = t;
    }

    public static void setPracticeType(int t) {
        pracitceT = t;
    }

    private void setupPractice() {
        setCorrect(0);
        setTotal(0);
        problemset = new ArrayList<Problem>();
        switch (pracitceT) {
            case 0:
                problemset.add(new Problem(0));
                setPracticeDuration(100);
                break;
            case 1:
                problemset.add(new Problem(1));
                setPracticeDuration(100);
            default:
                break;
        }
        //for use in time per question
        setinitPracticeDuration(getPracticeDuration());
    }

    public static boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private void resetProblem() {
        int index = (int) Math.random()*problemset.size();
        Problem curr = problemset.get(index);
        curr.generateNewProblem(curr.getid());

        problem.setVisible(true);
        problem.setText(curr.getProblem());
        input.setText("");
        answer = curr.getAnswer();

        visualTimer.stop();
        visualTimer.setDuration(Duration.seconds(curr.getDuration()));
        visualTimer.setNode(pTimer);
        visualTimer.setFromX(pTimer.getWidth());
        visualTimer.setToX(0);
        visualTimer.play();
    }

    @FXML
    void initialize() {
        //initialize
        Platform.runLater(() ->{
        textFade.setFromValue(1.0);
        textFade.setToValue(0.0);
        textFade.setNode(result);

        setupPractice();
        timer.setText(Double.toString(getPracticeDuration()));

        countdown.setCycleCount(Timeline.INDEFINITE);
        countdown.getKeyFrames().add(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                timer.setText(timef.format(getPracticeDuration()));
                setPracticeDuration(getPracticeDuration() - 0.01);
                if(getPracticeDuration() <= 0) {
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("results.fxml"));
                        Scene resultsScene = new Scene(root, 300, 275);
                        Stage thisStage = (Stage) problem.getScene().getWindow();
                        thisStage.setScene(resultsScene);
                        countdown.stop();

                    } catch (IOException e) {
                        System.out.println("Not good! Something has went terribly wrong. Please restart the program.");
                        Stage thisStage = (Stage) problem.getScene().getWindow();
                        thisStage.close();
                    }
                }

            }
        }));


        countdown.playFromStart();

        visualTimer.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkAnswer(input.getText(), answer);
            }
        });


        resetProblem();
        Scene thisScene = problem.getScene();

        //answer entered
        thisScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    String enteredText = input.getText();
                    checkAnswer(enteredText, answer);
                }

            }

        });
        });
    }

}