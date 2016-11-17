package com.pojos.java;
import java.util.*; 
import javax.mail.*;
import javax.mail.internet.*;

public class EmailGenerator {
	public static void run(String recipient, String subject, String body) {
		//Look up the Mail Session in JNDI:
		try {
			final String username = "revaturefrontdeskassistant@gmail.com";
			final String password = "thepassword";

			//System.out.println("In EmailGenerator");
			//InitialContext ic = new InitialContext();
			//Session session = (Session) ic.lookup("myMailSession");

			Properties props = new Properties();
			//props.put("mail.store.protocol", "imap");
			//props.put("mail.transport.protocol", "smtp");
			//props.put("mail.from", "revaturefrontdeskassistant@gmail.com");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props, 
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				}
			);

			//Construct a MimeMessage. In the following example, to, subject, and messageTxt are String variables containing input 
			//from the user.
			Message msg = new MimeMessage(session);
			msg.setFrom();
			msg.setRecipients(Message.RecipientType.TO, 
					InternetAddress.parse(recipient, false));
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			// Content is stored in a MIME multi-part message with one body part.
			MimeBodyPart mbp = new MimeBodyPart();
			mbp.setText(body);
			Multipart mp = new MimeMultipart();
			mp.addBodyPart(mbp);
			msg.setContent(mp);

			//Send the message.
			Transport.send(msg);
		} catch(AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
				
				
				
	}
}
