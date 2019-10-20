package eu.szestkam.application.controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextFlow;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AboutCipherController {

    private Desktop desktop = Desktop.getDesktop();
    private static String path;
    private static AboutCipherController instance = new AboutCipherController();

    public AboutCipherController() {
    }
    public static AboutCipherController getInstance(){
        return instance;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @FXML
    WebView webView;

    public void initialize() throws MalformedURLException {
        WebEngine webEngine = webView.getEngine();
        File file = new File(path);
        URL url = file.toURI().toURL();
        webEngine.load(url.toString());
        System.out.println(instance);
    }

}
