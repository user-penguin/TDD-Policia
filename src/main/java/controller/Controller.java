package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.GameKernel;
import model.QuestionTools;


public class Controller {
    @FXML
    private TextField questionField, prizeField;

    @FXML
    private Button startButton, answer1, answer2, answer3, answer4, helpButton;

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
        Button[] buttons = new Button[] {answer1, answer2, answer3, answer4};
        setRandomQuestion(buttons);
    }

    private void setRandomQuestion(Button[] buttons) {
        int random = QuestionTools.getRandom();
        int index = 0;
        buttons[random].setText(QuestionTools.getTrueAnswer(gameKernel.getCurrentQuestion()));
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setVisible(true);
            if (i != random) {
                buttons[i].setText(QuestionTools.getFakeAnswers(gameKernel.getCurrentQuestion())[index]);
                index++;
            }
        }
    }


    private void checkAnswer(String currentValue) {
        if (!QuestionTools.checkAnswer(currentValue, gameKernel.getCurrentQuestion())) {
            Stage stage = (Stage) answer1.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Блин блинский");
            alert.setContentText("Проигрыш, пока");
            alert.showAndWait();
            stage.close();
        } else {
            nextQuestion();
        }
    }

    private void nextQuestion() {
        if (gameKernel.getCountOfQuestions() == gameKernel.getCurrentQuestion() + 1) {
            answer1.setVisible(false);
            answer2.setVisible(false);
            answer3.setVisible(false);
            answer4.setVisible(false);
            prizeField.setText(String.valueOf(Integer.parseInt(prizeField.getText()) + 200 * (gameKernel.getCurrentQuestion()+1)));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Поздравляем");
            alert.setContentText("Вы выиграли " + prizeField.getText() + " BTC!");
            alert.showAndWait();
        } else {
            gameKernel.getNextQuestion();
            update();
        }
    }

    @FXML
    public void get75on25Help() {
        Button[] buttons = new Button[] {answer1, answer2, answer3, answer4};
        for (Button button: buttons) {
            if (!QuestionTools.checkAnswer(button.getText(), gameKernel.getCurrentQuestion())) {
                button.setVisible(false);
            }
        }
        helpButton.setVisible(false);
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
