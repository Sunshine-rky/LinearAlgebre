package cn.sunshine.util;

import java.io.IOException;
import java.util.Date;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 

public class JavaMailUtil {
 

	public static String emailAccount = "1838191803@qq.com";

	public static String emailPassword = "ymkidhuutzwsejjd";

	public static String emailSMTPHost = "smtp.qq.com";

	public static String receiveMailAccount = "";
	
	public static  MimeMessage creatMimeMessage(Session session,String sendMail,String receiveMail,String html) throws MessagingException, IOException {
	
		MimeMessage message = new MimeMessage(session);
	
		message.setFrom(new InternetAddress(sendMail, "邮箱验证", "UTF-8"));
	
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "鬼怪的新娘", "UTF-8"));
		
		message.setSubject("邮箱验证֤","UTF-8");

		message.setContent(html,"text/html;charset=UTF-8");

		message.setSentDate(new Date());

		message.saveChanges();
		return message;
	} 
}
