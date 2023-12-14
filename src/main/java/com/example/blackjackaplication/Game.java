package com.example.blackjackaplication;

import com.example.blackjackaplication.back.GameSetter;
import com.example.blackjackaplication.back.NewGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class Game implements GameSetter, Initializable {
    protected static NewGame game;

    protected Stage stage;
    protected Parent root;
    protected Scene scene;

    public <T extends Game & Initializable> void changeScene(ActionEvent event, String newScene_fxml,
                                                             String title, Class<T> controllerClass) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(newScene_fxml));
            this.root = fxmlLoader.load();
            T controller = fxmlLoader.getController();

            // Устанавливаем игру в контроллер, если он поддерживает интерфейс GameSetter


            this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            this.scene = new Scene(this.root);
            this.stage.setScene(this.scene);
            this.stage.setTitle(title);
            ((GameSetter) controller).setGame(game);
            this.stage.show();
        } catch (IOException e) {
            // Handle the exception (e.g., log it or show an error message)
            e.printStackTrace();
        }
    }


    public void setGame(NewGame game) {
        this.game = game;
    }
}
