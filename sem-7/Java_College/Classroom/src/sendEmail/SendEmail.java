package sendEmail;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {

    public static void main(String[] args) {
        // email ID of Recipient.
        String recipient = "neupaanerabin7@gmail.com";

        // email ID of Sender.
        String sender = "rabinneupane07@gmail.com"; // Replace with your actual email address

        // using host as localhost
        String host = "smtp.gmail.com"; // Replace with the correct SMTP server for your email provider

        // Getting system properties
        Properties properties = System.getProperties();

        // Setting up mail server
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", "587"); // For TLS, use port 587
        properties.setProperty("mail.smtp.starttls.enable", "true");

        // Set username and password for authentication
        String username = "rabinneupane07@gmail.com"; // Replace with your actual email address
        String password = "  "; // Replace with your actual email password
        properties.setProperty("mail.smtp.auth", "true");

        // Creating session object to get properties
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From Field: adding sender's email to the from field.
            message.setFrom(new InternetAddress(sender));

            // Set To Field: adding recipient's email to the to field.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

            // Set Subject: subject of the email
            message.setSubject("This is Subject");

            // Set body of the email.
            message.setText("This is a test mail");

            // Send email.
            Transport.send(message);
            System.out.println("Mail successfully sent");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
