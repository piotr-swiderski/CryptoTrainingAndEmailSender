package eu.szestkam.application.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.javafx.font.FontFactory;
import com.sun.xml.internal.fastinfoset.tools.FI_DOM_Or_XML_DOM_SAX_SAXEvent;
import eu.szestkam.cryptotraining.AtBash.AtBash;
import eu.szestkam.cryptotraining.Cipher;
import eu.szestkam.cryptotraining.cesar.CesarCipher;
import eu.szestkam.cryptotraining.matrix.Matrix;
import eu.szestkam.cryptotraining.rot_13.Rot13;
import eu.szestkam.cryptotraining.vigenere.Vigenere;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;


import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CipherController implements EventHandler<ActionEvent> {

    private MainController mainController;
    private Cipher cipher;
    private Desktop desktop = Desktop.getDesktop();
    private static String path = PathGuide.ADBASH.getPathGuide();

    @FXML
    ChoiceBox<String> choiceBox;
    @FXML
    TextField keyFiled;
    @FXML
    Label keyFieldDescript;
    @FXML
    TextField phraseField;
    @FXML
    TextArea textArea;

    @FXML
    public void initialize() {
        loadData();
    }

    private void loadData() {
        choiceBox.getItems().addAll("AdBash", "Cesar", "Matrix", "Rot", "Vigenere");
        choiceBox.getSelectionModel().select("AdBash");
        cipher = new AtBash();
        choiceBox.setOnAction(this);
        keyFiled.setVisible(false);
        keyFieldDescript.setVisible(false);
    }

    @FXML
    private void buttonEncode() {
        if (cipher.getClass().equals(Vigenere.class)) {
            System.out.println("Blabla");
            ((Vigenere) cipher).setKey(keyFiled.getText());
        }
        cipher.setPhrase(phraseField.getText());
        String encode = cipher.encode();
        textArea.setText("Encode: { " + encode + " }");

    }

    @FXML
    private void buttonDecode() {
        cipher.setPhrase(phraseField.getText());
        String decrypt = cipher.decrypt();
        textArea.setText("Decrypt: { " + decrypt + " }");
    }

    @FXML
    private void aboutCipher() throws IOException {
        Stage stage = new Stage();
        Pane root = null;
        AboutCipherController aboutCipherController = AboutCipherController.getInstance();
        aboutCipherController.setPath(path);
        FXMLLoader loader = new FXMLLoader(new File("D:\\SDA_Academy\\CryptoTrainnig\\" +
                "CryptoTraining-master\\src\\main\\java\\eu\\szestkam\\application\\" +
                "resources\\fxml\\AboutCipher.fxml").toURI().toURL());
        root = loader.load();
        stage.setTitle("About Cipher");
        stage.setScene(new Scene(root));
        stage.show();
    }


    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void buttonBack() throws IOException {
        FXMLLoader loader = new FXMLLoader(new File("D:\\SDA_Academy\\CryptoTrainnig\\CryptoTraining-master\\" +
                "src\\main\\java\\eu\\szestkam\\application\\resources\\fxml\\Menu.fxml").toURI().toURL());
        Pane pane = null;
        pane = loader.load();
        mainController.setScreen(pane);
        MenuController menuController = loader.getController();
        menuController.setMainController(mainController);
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == choiceBox) {
            switch (choiceBox.getValue()) {
                case "Vigenere":
                    cipher = new Vigenere();
                    showKeyField(true);
                    path = PathGuide.VIGENERE.getPathGuide();
                    break;
                case "AdBash":
                    cipher = new AtBash();
                    showKeyField(false);
                    path = PathGuide.ADBASH.getPathGuide();
                    break;
                case "Cesar":
                    cipher = new CesarCipher();
                    showKeyField(false);
                    path = PathGuide.CESAR.getPathGuide();
                    break;
                case "Rot":
                    cipher = new Rot13();
                    showKeyField(false);
                    path = PathGuide.ROT13.getPathGuide();
                    System.out.println(path);
                    break;
                case "Matrix":
                    cipher = new Matrix();
                    showKeyField(false);
                    path = PathGuide.MATRIX.getPathGuide();
                    break;
                default:
                    break;
            }
        }
    }

    private void showKeyField(boolean show) {
        keyFiled.setVisible(show);
        keyFieldDescript.setVisible(show);
    }


}
