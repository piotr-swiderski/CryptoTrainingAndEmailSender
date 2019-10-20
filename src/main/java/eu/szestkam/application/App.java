package eu.szestkam.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(new File("D:\\SDA_Academy\\CryptoTrainnig\\CryptoTraining-master\\" +
                "src\\main\\java\\eu\\szestkam\\application\\resources\\fxml\\MainPane.fxml").toURI().toURL());
        Parent root = loader.load();

        primaryStage.setTitle("Cipher Application");
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.show();


    }
}
