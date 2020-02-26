package cn.sunshine.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.sunshine.bean.Log;
import cn.sunshine.bean.User;
import cn.sunshine.service.LogService;
import cn.sunshine.service.UserService;
import cn.sunshine.serviceImpl.LogServiceImpl;
import cn.sunshine.serviceImpl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ñ��뷽ʽ
		request.setCharacterEncoding("utf-8");
		//����bean������
		User user=new User();
		//��ȡ������
		String u_email=request.getParameter("u_email");
		String u_name=request.getParameter("u_name");
		String u_password=request.getParameter("u_password");
		user.setU_email(u_email);
		user.setU_password(u_password);
		user.setU_name(u_name);
		//����service����
		UserService us=new UserServiceImpl();
		System.out.println(us.login(user)+" success");
		User ul=us.login(user);
		HttpSession session=request.getSession();
		session.setAttribute("user", user);
		request.getSession().setAttribute("email", u_email);
		request.getSession().setAttribute("name", u_name);
		System.out.println(u_name+"ttbv");
		System.out.println(u_email+"ttbv");
		//System.out.println(ul.getU_role());
		if(ul==null) {
			//�����޴���ʱ,��Ҫ����ת��
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			//response.sendRedirect("/login.jsp");
			System.out.println("hahah");
		}else {//���д���ʱ,��Ҫ�ض���
			if("user".equals(ul.getU_role())) {//�������ͨ�û�,��ת��user��ҳ
				response.sendRedirect(request.getContextPath()+"/userHome.jsp");
				}else {//����ǹ���Ա,��ת��manger��ҳ
					response.sendRedirect(request.getContextPath()+"/mangerHome.jsp");
				}
		}
	

		//存入日志中
				Log log=new Log();
				 Date now = new Date();
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String l_time= simpleDateFormat.format(now);
					
					
					log.setL_time(l_time);
					log.setU_email(u_email);
					log.setU_name(u_name);
					log.setL_behavior("登录功能");
					log.setL_modular("登录注册模块");
					LogService ls=new LogServiceImpl();
					ls.add(log);
				
		
		
	
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
