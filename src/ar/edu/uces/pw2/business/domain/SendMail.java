package ar.edu.uces.pw2.business.domain;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {

		private final static String SMTP_ACCOUNT_SERVER = "smtp.gmail.com"; // 
		private final static String SMTP_ACCOUNT_NAME = "web2alumax@gmail.com";//usuario 
		private final static String SMTP_ACCOUNT_PASS = "111aaa222bbb"; //contrase�a 
		
		public SendMail() {
			super();
		}

		public boolean sendEmail(String from, String to, String subject, String message) {
			
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
			props.put("mail.debug", "true");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.localhost", "QR");
			  
			Session s = Session.getInstance(props, null);
			s.setDebug(true);
			  
			MimeMessage mimeMessage = new MimeMessage(s);
			
			try {
				InternetAddress fromAddress = new InternetAddress(from, from);
				InternetAddress toAddress = new InternetAddress(to);
				
				mimeMessage.setSentDate(new Date());
				mimeMessage.setFrom(fromAddress);
				mimeMessage.addRecipient(Message.RecipientType.TO, toAddress);
				  
				mimeMessage.setSubject(subject);
				
				MimeMultipart multipart = new MimeMultipart();
				
				// first part (the html)
				BodyPart messageBodyPart = new MimeBodyPart();
				//String htmlText = "<H1>"+ message +"&quot;&lt;/H1&gt;&lt;img src=E:\Luciana\DeveloperTools\Eclipse\eclipse\prograweb2\order.qr&gt;&quot;
				String htmlText = "<H1>"+ message +"</H1><img src=\"cid:image\">";
				messageBodyPart.setContent(htmlText, "text/html");
				// add it
				multipart.addBodyPart(messageBodyPart);
				
				// second part (the image)
				messageBodyPart = new MimeBodyPart();
				DataSource fds = new FileDataSource(
						System.getProperty("user.dir")+"/prograweb2/order.qr");

				messageBodyPart.setDataHandler(new DataHandler(fds));
				messageBodyPart.setHeader("Content-ID", "<image>");
				
				multipart.addBodyPart(messageBodyPart);
				mimeMessage.setContent(multipart);

				Transport tr = s.getTransport("smtp");
				tr.connect(SMTP_ACCOUNT_SERVER, SMTP_ACCOUNT_NAME, SMTP_ACCOUNT_PASS);
				mimeMessage.saveChanges();
				tr.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
				tr.close();
				
			} catch (Exception e) {
				//FIXME: siempre mandar a un log los errores
				System.err.println("Error: " + e.getMessage() + ". Causa: " + e.getCause());
			}
			return false;
		}
}
