package com.example.blackjackaplication;

// PlayerController.java


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayerController implements Initializable {
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

    @FXML
    private Label nameLabel;

    @FXML
    private Label balanceLabel;

    public void setName(String name) {
        nameLabel.setText(name);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setBalance(int balance) {
        balanceLabel.setText(String.valueOf(balance));
    }
}

