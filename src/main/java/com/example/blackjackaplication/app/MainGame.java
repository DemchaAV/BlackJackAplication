/**
 * Sample Skeleton for 'scratch-scene.fxml' Controller Class
 */

package com.example.blackjackaplication.app;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainGame extends Game implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private HBox playersHolder;

    @FXML
    private Button dropCard;
    @FXML
    private VBox dealerBox;

    private List<Pane> playersPane = new ArrayList<>();

    private boolean isActiveButton = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (Game.game == null) {
            return;
        } else {
            loadPlayers();
            System.out.println("Players hold  " + playersHolder.getChildren().size());
        }
    }

    @FXML
    private void loadPlayers() {
        if (isActiveButton) {
            Pane newPlayerPane = createPlayerPane(0);
            newPlayerPane.setLayoutX(100);
            newPlayerPane.setLayoutY(100);
            dealerBox.setAlignment(Pos.CENTER);
            dealerBox.getChildren().add(newPlayerPane);
            for (int i = 1; i < game.getAmountPlayers(); i++) {
                newPlayerPane = createPlayerPane(i);
                playersHolder.getChildren().add(newPlayerPane);
            }
        }
        isActiveButton = false;
    }

    private Pane createPlayerPane(int id) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/blackjackaplication/player.fxml"));
        Pane playerPane;
        try {
            playerPane = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        PlayerController playerController = loader.getController();
        playerController.setInfo(game.getPlayer(id));
        return playerPane;
    }

    @FXML
    private void dropCards(ActionEvent event) {
        System.out.println("drop card");
        if (dropCount == 0) {
            game.firstDropCard();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/blackjackaplication/main-game.fxml"));
            Parent root;
            try {
                root = loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            MainGame mainGameController = loader.getController();
            mainGameController.setGame(game);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            mainGameController.dropCard.setText("GetCard");
            mainGameController.playersHolder.setSpacing(80);
            dropCount++;
        } else {
            System.out.println("get card for first player");
        }
    }
}

