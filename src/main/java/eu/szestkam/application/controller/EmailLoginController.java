package eu.szestkam.application.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmailLoginController {

    private EmailMainController emailMainController;
    protected Session session;
    private static List<String> emailAddressList = new ArrayList<>();

    @FXML
    PasswordField passwordField;
    @FXML
    Label loginStatus;
    @FXML
    ComboBox<String> comboBoxEmail;


    public void initialize(){
        comboBoxEmail.setEditable(true);
        comboBoxEmail.getItems().addAll(emailAddressList);
        session = null;
    }

    public void closeEmail(){
        Platform.exit();
    }

    public void login() {
        final String username = comboBoxEmail.getValue();
        final String password = passwordField.getText();


        if(!username.matches("[\\w._]*"+"@gmail.com")){
            loginStatus.setText("Email adress is wrong");
            throw new IllegalArgumentException("Wrong emial adress");
        }
        addAddressToList(comboBoxEmail.getValue());
        if(password.isEmpty()){
            loginStatus.setText("Password is wrong");
            throw new IllegalArgumentException("Password can't by empty");
        }

        int port = 587;
        String host = "smtp.gmail.com";
        try {
            Properties prop = new Properties();
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true"); //TLS

            session = Session.getInstance(prop,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });

            Transport transport = session.getTransport("smtp");
            transport.connect(host,port,username,password);
            System.out.println("Connect");
            changeWindowToSend();
        } catch (NoSuchProviderException e) {
            System.out.println("Not connect");
            e.printStackTrace();
        } catch (MessagingException e) {
            System.out.println("Not connect");
            loginStatus.setText("Email or password is wrong");
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }


    public void setEmailLoginController(EmailMainController emailMainController) {
        this.emailMainController = emailMainController;
    }

    public void changeWindowToSend() throws MalformedURLException {
        FXMLLoader loader = new FXMLLoader(new File("D:\\SDA_Academy\\CryptoTrainnig\\CryptoTraining-master\\src\\" +
                "main\\java\\eu\\szestkam\\application\\resources\\" +
                "fxml\\EmailWindow.fxml").toURI().toURL());
        SplitPane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(pane);
        emailMainController.setScreen(pane);
        EmailSendController emailSendController = loader.getController();
        emailSendController.setEmailLoginController(emailMainController);
        emailSendController.setSession(session);
        emailSendController.setEmailLogin(comboBoxEmail.getValue());
    }


    private void addAddressToList(String address){
        emailAddressList.add(address);
        comboBoxEmail.getItems().addAll(emailAddressList);
    }


}
