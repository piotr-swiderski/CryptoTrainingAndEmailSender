package eu.szestkam.application.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;

public class MainController {

    @FXML
    private StackPane mainStackPane;

    @FXML
    public void initialize() throws MalformedURLException {
        FXMLLoader loader = new FXMLLoader(new File("D:\\SDA_Academy\\CryptoTrainnig\\CryptoTraining-master\\src\\main\\java\\eu\\szestkam\\application\\resources\\fxml\\Menu.fxml").toURI().toURL());
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MenuController menuController = loader.getController();
        menuController.setMainController(this);
        setScreen(pane);
    }

    public void setScreen(Pane pane){
        mainStackPane.getChildren().clear();
        mainStackPane.getChildren().add(pane);
    }
}
