module com.example.blackjackaplication {
    requires javafx.controls;
    requires javafx.fxml;



    opens com.example.blackjackaplication to javafx.fxml;
    exports com.example.blackjackaplication;
    exports com.example.blackjackaplication.app;
    opens com.example.blackjackaplication.app to javafx.fxml;
}