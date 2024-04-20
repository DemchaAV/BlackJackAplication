package com.example.blackjackaplication;

import com.example.blackjackaplication.back.NewGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloSceneController extends Game implements Initializable {
    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    Pane helloPane;
    /**
     * choiceBox can be only with number on position 0
     */
    String[] choiceList = {"1 Player         ", "2 Players       ", "3 Players         ", "4 Players         "};
    @FXML
    private Label infoError;

    private int amountPlayers;

    @FXML
    private void setAmountPlayers(ActionEvent event) {
        String choice = choiceBox.getValue();

        try {
            infoError.setText(null);
            amountPlayers = Integer.parseInt(String.valueOf(choice.charAt(0)));
            System.out.println(amountPlayers);
        } catch (NumberFormatException e) {
            infoError.setText("Please pick the Amount of players");
            System.err.println("Invalid input. Please enter a valid number.");
        }
    }

    @FXML
    private void acceptGame(ActionEvent event) {
        if (amountPlayers != 0) {
            game = new NewGame(amountPlayers);
            registration(event);
        } else {
            infoError.setText("Please pick the Amount of players");
        }
    }


    @FXML
    private void registration(ActionEvent event) {
        changeScene(event, "registration-scene.fxml", "BlackJack", AutorizationController.class);
        System.out.println("Registration");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox.getItems().setAll(choiceList);
        choiceBox.getSelectionModel().select(" Player");
        choiceBox.setOnAction(this::setAmountPlayers);
    }
}


