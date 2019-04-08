package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.GameKernel;
import model.QuestionTools;


public class Controller {
    @FXML
    private TextField questionField, prizeField;

    @FXML
    private Button startButton, answer1, answer2, answer3, answer4;

    private GameKernel gameKernel;

    @FXML
    public void initialize() {
        gameKernel = new GameKernel();
        answer1.setVisible(false);
        answer2.setVisible(false);
        answer3.setVisible(false);
        answer4.setVisible(false);
    }

    @FXML
    public void startGame() {
        questionField.setText(gameKernel.getNextQuestion());
        prizeField.setText(String.valueOf(gameKernel.getPrizeSize()));
        startButton.setVisible(false);
        update();
        answer1.setVisible(true);
        answer2.setVisible(true);
        answer3.setVisible(true);
        answer4.setVisible(true);
    }

    private void update() {
        answer1.setText(QuestionTools.getTrueAnswer(gameKernel.getCurrentQuestion()));
        answer2.setText(QuestionTools.getFakeAnswers(gameKernel.getCurrentQuestion())[0]);
        answer3.setText(QuestionTools.getFakeAnswers(gameKernel.getCurrentQuestion())[1]);
        answer4.setText(QuestionTools.getFakeAnswers(gameKernel.getCurrentQuestion())[2]);
    }

    @FXML
    public void sendAnswer1() {

    }

}
