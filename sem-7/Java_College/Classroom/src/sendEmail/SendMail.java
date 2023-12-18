package sendEmail;

import java.net.Authenticator;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail extends Authenticator {
	static String from = "rabinneupane07@gmail.com";
	static String pass = "egwj cqku vszs xxjt";
	static InternetAddress to;

	public static void main(String[] args) throws MessagingException {

		// Get the session object

		Properties properties = System.getProperties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		// Start TLS (transport layer Security
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.user", from);
		properties.put("mail.smtp.user", pass);
//		properties.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(properties);

		// Compose the message

		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("rabinneupane07@gmail.com"));
		to = new InternetAddress("neupanerabin7@gmail.com");
		msg.addRecipient(Message.RecipientType.TO, to);
		msg.setSubject("Test Java Mail");
		msg.setText("Try mail");

		// Send message
		Transport transport = session.getTransport("smtp");
		transport.connect("smtp.gmail.com", from, pass);
		transport.sendMessage(msg, msg.getAllRecipients());
		System.out.println("message send successfully");

	}

}
