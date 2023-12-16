package com.example.blackjackaplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class PlayerController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private HBox balanceHold;

    @FXML
    private Label balanceLabel;

    @FXML
    private HBox cardHoldBacket;

    @FXML
    private Label nameLabel;

    @FXML
    private Pane player;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert balanceHold != null : "fx:id=\"balanceHold\" was not injected: check your FXML file 'player.fxml'.";
        assert balanceLabel != null : "fx:id=\"balanceLabel\" was not injected: check your FXML file 'player.fxml'.";
        assert cardHoldBacket != null : "fx:id=\"cardHoldBacket\" was not injected: check your FXML file 'player.fxml'.";
        assert nameLabel != null : "fx:id=\"nameLabel\" was not injected: check your FXML file 'player.fxml'.";
        assert player != null : "fx:id=\"player\" was not injected: check your FXML file 'player.fxml'.";

    }
    public void reflection(PlayerPane playerPane){
        if(playerPane.getNameLabel()!=null){
            nameLabel = playerPane.getNameLabel();
        }
    }
    public Label getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(Label nameLabel) {
        this.nameLabel = nameLabel;
    }

    public Label getBalanceLabel() {
        return balanceLabel;
    }

    public void setBalanceLabel(Label balanceLabel) {
        this.balanceLabel = balanceLabel;
    }

    public void setName(String name) {
        nameLabel.setText(name);
    }



    public void setBalance(int balance) {
        balanceLabel.setText(String.valueOf(balance));
    }
}

