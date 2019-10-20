package eu.szestkam.application;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class EmailSendApp extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(new File("D:\\SDA_Academy\\CryptoTrainnig\\CryptoTraining-master\\src\\main\\java\\eu\\szestkam\\application\\resources\\fxml\\EmailMainPane.fxml").toURI().toURL());
        StackPane pane = null;
        pane = loader.load();
        primaryStage.setScene(new Scene(pane,600,400));
        primaryStage.show();

    }



}
