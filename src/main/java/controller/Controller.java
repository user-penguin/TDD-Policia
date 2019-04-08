package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.GameKernel;


public class Controller {
    @FXML
    private TextField questionField, prizeField;

    private GameKernel gameKernel;

    @FXML
    public void initialize() {
        gameKernel = new GameKernel();
    }

    @FXML
    public void getNextQuestion() {
        questionField.setText(gameKernel.getNextQuestion());
        prizeField.setText(String.valueOf(gameKernel.getPrizeSize()));
    }

}
