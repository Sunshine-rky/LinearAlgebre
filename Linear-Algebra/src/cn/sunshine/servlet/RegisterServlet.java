package cn.sunshine.servlet;

import java.io.IOException;
//import java.lang.reflect.InvocationTargetException;
//import java.util.UUID;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.sunshine.bean.Log;

//import org.apache.commons.beanutils.BeanUtils;

import cn.sunshine.bean.User;
import cn.sunshine.service.LogService;
//import cn.sunshine.exception.UserException;
import cn.sunshine.service.UserService;
import cn.sunshine.serviceImpl.LogServiceImpl;
import cn.sunshine.serviceImpl.UserServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sessionCode = (String) request.getSession().getAttribute("code");
		System.out.println(sessionCode);
		if (sessionCode != null) {
			String inputCode = request.getParameter("code");

			System.out.println("输入的验证码为" + inputCode);

			if (sessionCode.toLowerCase().equals(inputCode.toLowerCase())) {

				String u_name = request.getParameter("name");
				String u_password = request.getParameter("password");
				Date now = new Date();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String u_registertime = simpleDateFormat.format(now);
				String u_email = (String) request.getSession().getAttribute("email");
				User user = new User();
				user.setU_email(u_email);
				user.setU_name(u_name);
				user.setU_password(u_password);
				user.setU_registertime(u_registertime);

				UserService us = new UserServiceImpl();
				us.register(user);
				HttpSession session = request.getSession();
				session.setAttribute("user", user);

				// 存入日志中
				Log log = new Log();

				String l_time = simpleDateFormat.format(now);

				log.setL_time(l_time);
				log.setU_email(u_email);
				log.setU_name(u_name);
				log.setL_behavior("用户注册");
				log.setL_modular("登录注册模块");
				LogService ls = new LogServiceImpl();
				ls.add(log);

				request.getRequestDispatcher("/success.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/fail.jsp").forward(request, response);
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
