package com.example.blackjackaplication.app.back;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Player  implements Action {
    private String name;
    private int balance;

    //FXML
    private final StringProperty nameLabel = new SimpleStringProperty();
    private final StringProperty balanceLabel = new SimpleStringProperty();
    private ObjectProperty<Image> cardView = new SimpleObjectProperty<>();

public void setNameLabel(){
//    nameLabel.set(name);
}

    public int getBalance() {
        return balance;
    }

    private ArrayList<Integer> pool= new ArrayList<>();
    private int sumPoint = 0;
    int sumBet;


    public Player() {
    }

    @Override
    public void getCard(int card) {
        pool.add(card);
    }

    @Override
    public void  setBet(int x) throws outOfMoney {
        if (balance - bet * x < 0) {
            throw new outOfMoney();
        }else {
            balance -= bet * x;
            sumBet +=bet*x;
        }
    }

    public ArrayList<Integer> getPool() {
        ArrayList<Integer> show = pool;

        return show;
    }



    @Override
    public String toString() {
        return "Name : " + name + ", Balance: " + balance;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void clearPool(){
        for (int i = 0; i < pool.size(); i++) {
            pool.set(i,0);

        }
    }
    public void reset(){
        pool=new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public void getProtect() {

    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
public void topUp(int amount){
        balance+=amount;
}
}


class outOfMoney extends RuntimeException {
    outOfMoney() {
        super("Not enough money for a bet");
    }

    outOfMoney(String mesage) {
        super(mesage);
    }

}
