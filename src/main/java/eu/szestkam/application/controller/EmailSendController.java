package eu.szestkam.application.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

public class EmailSendController {

    protected Session session;
    private String emailLogin;




    private EmailMainController emailMainController;

    @FXML
    TextArea emailText;
    @FXML
    TextField emailAddressToSend;
    @FXML
    TextField subjectText;
    @FXML
    Label emailStatus;
    @FXML
    Label logonAddress;

    public void initialize(){

    }

    public void logOff(){

        try {
            changeWindowToLogin();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public void setEmailLogin(String emailLogin) {
        this.emailLogin = emailLogin;
        logonAddress.setText(emailLogin);
    }

    public void saveEmail() throws IOException {
        Document document = new Document();
        try {
            if (!subjectText.getText().equals("")) {
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(subjectText.getText() + ".pdf"));
                if (!emailText.getText().equals("")) {
                    document.open();
                    document.add(new Paragraph("Send to: " + emailAddressToSend.getText()));
                    document.add(new Paragraph("Subject: " + subjectText.getText() + "\n\n"));
                    document.add(new Paragraph(""));
                    document.add(new Paragraph(emailText.getText()));
                    document.close();
                } else {
                    //message error
                }
                writer.close();
            } else {
                //message error
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sendEmail(){

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("my"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(emailAddressToSend.getText())
            );
            message.setSubject(subjectText.getText());
            message.setText(emailText.getText());

            Transport.send(message);

            emailStatus.setText("Email is send to " + emailAddressToSend.getText());

        } catch (MessagingException e) {
            e.printStackTrace();
            emailStatus.setText("Email isn't send to " + emailAddressToSend.getText());
        }
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public void setEmailLoginController(EmailMainController emailMainController) {
        this.emailMainController = emailMainController;
    }

    public void changeWindowToLogin() throws MalformedURLException {
        FXMLLoader loader = new FXMLLoader(new File("D:\\SDA_Academy\\CryptoTrainnig\\CryptoTraining-master\\src\\" +
                "main\\java\\eu\\szestkam\\application\\resources\\" +
                "fxml\\EmailLogin.fxml").toURI().toURL());
        SplitPane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(pane);
        emailMainController.setScreen(pane);
        EmailLoginController emailLoginController = loader.getController();
        emailLoginController.setEmailLoginController(emailMainController);
    }

    public void setEmailMainController(EmailMainController emailMainController) {
        this.emailMainController = emailMainController;
    }
}


