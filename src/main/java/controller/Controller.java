package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
        questionField.setText(QuestionTools.getQuestion(gameKernel.getCurrentQuestion()));
        prizeField.setText(String.valueOf(gameKernel.getPrizeSize()));
        answer1.setText(QuestionTools.getTrueAnswer(gameKernel.getCurrentQuestion()));
        answer2.setText(QuestionTools.getFakeAnswers(gameKernel.getCurrentQuestion())[0]);
        answer3.setText(QuestionTools.getFakeAnswers(gameKernel.getCurrentQuestion())[1]);
        answer4.setText(QuestionTools.getFakeAnswers(gameKernel.getCurrentQuestion())[2]);
    }

    private void checkAnswer(String currentValue) {
        if (!QuestionTools.checkAnswer(currentValue, gameKernel.getCurrentQuestion())) {
            Stage stage = (Stage) answer1.getScene().getWindow();
            stage.close();
        } else {
            nextQuestion();
        }
    }

    private void nextQuestion() {
        gameKernel.getNextQuestion();
        update();
    }

    @FXML
    public void sendAnswer1() {
        checkAnswer(answer1.getText());
    }

    @FXML
    public void sendAnswer2() {
        checkAnswer(answer2.getText());
    }

    @FXML
    public void sendAnswer3() {
        checkAnswer(answer3.getText());
    }

    @FXML
    public void sendAnswer4() {
        checkAnswer(answer4.getText());
    }

}
