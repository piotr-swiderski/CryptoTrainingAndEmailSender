package eu.szestkam.application.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class EmailMainController {


    public EmailMainController() {
    }

    @FXML
    private StackPane mainStackPane;

    @FXML
    public void initialize() throws MalformedURLException {
        FXMLLoader loader = new FXMLLoader(new File("D:\\SDA_Academy\\CryptoTrainnig\\CryptoTraining-master\\" +
                "src\\main\\java\\eu\\szestkam\\application\\resources\\fxml\\EmailLogin.fxml").toURI().toURL());
        SplitPane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        EmailLoginController emailLoginController = loader.getController();
        emailLoginController.setEmailLoginController(this);
        setScreen(pane);
    }

    public void setScreen(SplitPane pane){
        mainStackPane.getChildren().clear();
        mainStackPane.getChildren().add(pane);
    }

}
