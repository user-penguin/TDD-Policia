package model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static Stage mainStage;

    // @TODO реализовать получение ширины окна
    public static double getWindowWidth() {
        return 900;
    }

    public void setMainStage(Stage stage) {
        mainStage = stage;
    }
    public static Stage getMainStage() {
        return mainStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        setMainStage(primaryStage);
        Parent root = FXMLLoader.load(getClass().getResource("../../resources/fxml/sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
