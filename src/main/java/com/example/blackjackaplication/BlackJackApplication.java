package com.example.blackjackaplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Application version with GUI
 */

public class BlackJackApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BlackJackApplication.class.getResource("HelloScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("BlackJack");
        stage.setScene(scene);
        Image icon = new Image(getClass().getResourceAsStream("img/icon/Icon.png"));
        stage.getIcons().add(icon);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}