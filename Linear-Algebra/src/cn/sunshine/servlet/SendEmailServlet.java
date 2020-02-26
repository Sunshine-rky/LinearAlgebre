package cn.sunshine.servlet;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sunshine.util.JavaMailUtil;
import cn.sunshine.util.RandomUtil;
import cn.sunshine.util.htmlText;



@WebServlet("/SendEmailServlet")
public class SendEmailServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("发送验证码啦");
		try {
			String email = req.getParameter("email");
			req.getSession().setAttribute("email", email);
			JavaMailUtil.receiveMailAccount = email; 
			Properties props = new Properties();
		
			props.setProperty("mail.debug", "true");
			// ���ͷ�������Ҫ�����֤
			props.setProperty("mail.smtp.auth", "true");
		
			props.setProperty("mail.host", JavaMailUtil.emailSMTPHost);
	
			props.setProperty("mail.transport.protocol", "smtp");
			
			Session session = Session.getInstance(props);
	
			session.setDebug(true);
	
			String code = RandomUtil.getRandom();
			System.out.println("发送的验证码为" + code);
			String html = htmlText.html(code);
			MimeMessage message = JavaMailUtil.creatMimeMessage(session, JavaMailUtil.emailAccount,
					JavaMailUtil.receiveMailAccount, html);
 
			
			Transport transport = session.getTransport();
			
			transport.connect(JavaMailUtil.emailAccount, JavaMailUtil.emailPassword);
			// 6�������ʼ�,���������ռ��˵�ַ
			transport.sendMessage(message,message.getAllRecipients());
		
			transport.close();
		
			req.getSession().setAttribute("code", code);
			
		} catch (Exception e) {
			e.printStackTrace();
			req.getSession().setAttribute("error", "�ʼ�����ʧ��");
		}
	}
}

