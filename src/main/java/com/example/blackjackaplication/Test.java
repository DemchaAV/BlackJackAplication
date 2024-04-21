package com.example.blackjackaplication;

import com.example.blackjackaplication.back.Deck;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;

public class Test extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage)throws IOException {
        Group root = new Group();

        Scene scene = new Scene(root, 600, 600, Color.STEELBLUE);

        stage.setScene(scene);

        Text text = new Text();

        text.setText("WHOOOOA!!");

        // Устанавливаем позицию (X, Y)
        text.setX(50);
        text.setY(50);
        Deck deck = new Deck();
        String card = deck.cardView((int)(Math.random()*52));
        Image image =  new Image(getClass().getResourceAsStream(card));
        ImageView imageView = new ImageView(image);
        imageView.setX(80);
        imageView.setY(80);
        Label newLabal = new Label("Hello ", imageView);


        // Устанавливаем шрифт и размер
        text.setFont(Font.font("Verdana", 50));

        // Устанавливаем цвет текста
        text.setFill(Color.LIMEGREEN);
        root.getChildren().add(newLabal);

        // Добавляем текст в корневую группу
        root.getChildren().add(text);
        root.getChildren().add(imageView);

        // Показываем окно
        stage.show();

    }
}
