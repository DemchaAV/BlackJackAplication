/**
 * Sample Skeleton for 'scratch-scene.fxml' Controller Class
 */

package com.example.blackjackaplication;


import com.example.blackjackaplication.back.NewGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainGame extends Game implements Initializable {
    /**
     * Sample Skeleton for 'main-game.fxml' Controller Class
     */


    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;


    @FXML // fx:id="playersHolder"
    private HBox playersHolder; // Value injected by FXMLLoader
    @FXML
    Button startGameButton;
    List<PlayerPane> playersPane = new ArrayList<>();
    {
        playersPane.add(new PlayerPane(game.getPlayer(0)));
    }

    private boolean isActiveButton = true;

    {
        System.out.println(game == null);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (Game.game==null) {
            return;
        } else {
            loadPlayers();
        }
    }

    @FXML
    private void loadPlayers() {
        if (isActiveButton) {
            // Создаем новый экземпляр Pane для нового игрока
            for (int i = 1; i < game.getAmountPlayers(); i++) {

                PlayerPane newPlayerPane = createPlayerPane(i);

                // Добавляем нового игрока в playersHolder
                playersPane.add(newPlayerPane);
                playersHolder.getChildren().add(newPlayerPane);
            }
        }
        isActiveButton = false;
    }

    private void  drop(){
        game.firstDropCard();

    }


    private PlayerPane createPlayerPane(int id) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("player.fxml"));
        PlayerPane playerPane = new PlayerPane(game.getPlayer(id));
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Получите контроллер
        PlayerController playerController = loader.getController();

        // Установите данные для нового игрока

        return playerPane;
    }


    @FXML
    private void dropCards(){
        game.firstDropCard();
    }
I





}
