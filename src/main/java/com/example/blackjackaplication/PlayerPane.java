package com.example.blackjackaplication;


import com.example.blackjackaplication.back.Player;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class PlayerPane extends Pane {
    private VBox player;
    private Label nameLabel;
    private HBox balanceHold;
    private Label balanceLabel;
    private HBox cardHoldBacket;

    public PlayerPane(Player player) {
        this.nameLabel = new Label(player.getName());
        this.balanceLabel = new Label(String.valueOf(player.getBalance()));
        this.cardHoldBacket = new HBox();  // Assuming this is your card container

        // Set font for nameLabel
        nameLabel.setFont(Font.font("System Bold", 24.0));

        // Set font and other properties for balanceLabel
        balanceLabel.setFont(Font.font("Comic Sans MS Bold", 18.0));

        // Set up the layout
        initializeControls();
        layoutControls();
    }

    private void initializeControls() {
        player = new VBox();
        balanceHold = new HBox();

        // Add other initialization logic if needed
    }

    private void layoutControls() {
        player.getChildren().addAll(nameLabel,balanceLabel, balanceHold, cardHoldBacket);
        getChildren().add(player);
    }

    public HBox getCardHoldBacket() {
        return cardHoldBacket;
    }
}


