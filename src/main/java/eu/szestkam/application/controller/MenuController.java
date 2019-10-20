package eu.szestkam.application.controller;

import eu.szestkam.application.EmailSendApp;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MenuController {

    private MainController mainController;

    @FXML
    WebView webView;


    public void initialize(){
        WebEngine webEngine = webView.getEngine();
        File file = new File("D:\\SDA_Academy\\CryptoTrainnig\\CryptoTraining-master\\" +
                "src\\main\\java\\eu\\szestkam\\application\\resources\\fxml\\menu.html");
        URL url = null;

        try {
            url = file.toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        webEngine.load(url.toString());
    }

    @FXML
    public void cipherApp() throws MalformedURLException {
        FXMLLoader loader = new FXMLLoader(new File("D:\\SDA_Academy\\CryptoTrainnig\\" +
                "CryptoTraining-master\\src\\main\\java\\eu\\szestkam\\application\\" +
                "resources\\fxml\\CipherWindow.fxml").toURI().toURL());
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(pane);
        mainController.setScreen(pane);
        CipherController cipherController = loader.getController();
        cipherController.setMainController(mainController);
    }

    @FXML
    public void cipherClose() {
        Platform.exit();
    }

    @FXML
    public void emailSend() throws Exception {
        EmailSendApp emailSendApp = new EmailSendApp();
        emailSendApp.start(new Stage());
    }


    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
