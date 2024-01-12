package com.dikshitsapkota.emailSending;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
        String msg =" hi";
        String subject = "subject ";
        String to ="dikshitsapkota99@gmail.com";
        String from = "javadeveloper9610@gmail.com";
        
        sendEmail(msg,subject,to,from);
        
    }

	private static void sendEmail(String msg, String subject, String to, String from) {
		//host :where to send
		//for gmail host is "smtp.gmail.com"
		String host ="smtp.gmail.com";
		Properties properties = System.getProperties();
//		System.out.println(properties);
		//setting important information to the properties object
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		properties.put("mail.transport.protocol", "smtp");

		
		//step 1:to get session object
		
		Session session =Session.getInstance(properties, new Authenticator()
				{
					protected PasswordAuthentication getPasswordAuthentication()
					{
						return new PasswordAuthentication("javadeveloper9610@gmail.com","skce cxir sziu jmwy");
						
					}
				}
		);
		session.setDebug(true);
		//step 2: compose the message
		MimeMessage mm = new MimeMessage(session);
		try
		{
			mm.setFrom(new InternetAddress(from));
			mm.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			mm.setSubject(subject);
			mm.setText(msg);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
//		step 3:
		try {
			Transport.send(mm);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
