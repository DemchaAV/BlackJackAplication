package com.example.blackjackaplication.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AutorizationController extends Game {
    private String tempName;
    private int tempBalance;
    @FXML
    private TextField playerNameField;
    @FXML
    private TextField playerBalenceField;
    @FXML
    private Label infoPlayer;
    int i = 1;


    public void setPlayer() {
        game.getPlayer(i).setName(tempName);
        game.getPlayer(i).setBalance(tempBalance);
        playerBalenceField.setText(null);
        playerNameField.setText(null);
        ++i;
        infoPlayer.setText("Player " + i);


        System.out.println(game.getPlayers());
    }

    public void newScene(ActionEvent event) {
        changeScene(event, "main-game.fxml", "Game", MainGame.class);
    }

    public void acceptInfoPlayr(ActionEvent event) {
        System.out.println("Iteration on " + i);
        String nameErr = null;
        infoPlayer.setText("Player " + i);
        System.out.println(playerNameField.getText().length());

        try {
            tempName = playerNameField.getText();
            if (playerNameField.getText().isEmpty()) {
                throw new NullPointerException("Name is empty");
            }
            tempBalance = Integer.parseInt(playerBalenceField.getText());

        } catch (NullPointerException e) {
            nameErr = "String is empty, enter name";
            infoPlayer.setText(nameErr);
        } catch (NumberFormatException e) {

            if (playerBalenceField.getText().length() == 0) {
                nameErr = "Enter your wallet balance";
            } else {
                nameErr = "Only numbers";
            }
            infoPlayer.setText(nameErr);
        }


        if (tempName != null && tempBalance >= 25) {

            setPlayer();
            if (i > game.getAmountPlayers()) {
                infoPlayer.setText("Player " + i);
            }
        }
        if (i == game.getAmountPlayers()) {
            newScene(event);
        }


    }

    public void sckiPlayers() {

        if (i <= 2) {
            game.getPlayer(i).setName("Artem");
            game.getPlayer(i).setBalance(325);
            playerBalenceField.setText(null);
            playerNameField.setText(null);
            ++i;
            game.getPlayer(i).setName("Mariia");
            game.getPlayer(i).setBalance(312);
            playerBalenceField.setText(null);
            playerNameField.setText(null);
            infoPlayer.setText("Player " + i);


            System.out.println(game.getPlayers());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(game == null);

        infoPlayer.setText("Player " + i);
//        sckiPlayers();
//        newScene(new ActionEvent());
    }
}

class LenghtField extends NullPointerException {

}