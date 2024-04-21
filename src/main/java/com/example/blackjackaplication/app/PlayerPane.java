package com.example.blackjackaplication.app;


import com.example.blackjackaplication.app.back.Player;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class PlayerPane extends Pane {
    private VBox playerBox;
    private Label nameLabel;
    private HBox balanceHold;
    private Label balanceLabel;
    private HBox cardHoldBacket;

    public PlayerPane(Player playerBox) {
        this.nameLabel = new Label(playerBox.getName());
        this.balanceLabel = new Label(String.valueOf(playerBox.getBalance()));
        this.cardHoldBacket = new HBox();  // Assuming this is your card container

        // Set font for nameLabel
        nameLabel.setFont(Font.font("System Bold", 24.0));

        // Set font and other properties for balanceLabel
        balanceLabel.setFont(Font.font("Comic Sans MS Bold", 18.0));

        // Set up the layout
        initializeControls();
        layoutControls();
    }
    public void reLoadInfo(){

    }
    public void setPlayer(Player playe){

    }

    public VBox getPlayerBox() {
        return playerBox;
    }

    public void setPlayerBox(VBox playerBox) {
        this.playerBox = playerBox;
    }

    public Label getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(Label nameLabel) {
        this.nameLabel = nameLabel;
    }

    public HBox getBalanceHold() {
        return balanceHold;
    }

    public void setBalanceHold(HBox balanceHold) {
        this.balanceHold = balanceHold;
    }

    public Label getBalanceLabel() {
        return balanceLabel;
    }

    public void setBalanceLabel(Label balanceLabel) {
        this.balanceLabel = balanceLabel;
    }

    public void setCardHoldBacket(HBox cardHoldBacket) {
        this.cardHoldBacket = cardHoldBacket;
    }

    private void initializeControls() {
        playerBox = new VBox();
        balanceHold = new HBox();

        // Add other initialization logic if needed
    }

    private void layoutControls() {
        playerBox.getChildren().addAll(nameLabel,balanceLabel, balanceHold, cardHoldBacket);
        getChildren().add(playerBox);
    }

    public HBox getCardHoldBacket() {
        return cardHoldBacket;
    }
}


