package cn.sunshine.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sunshine.bean.User;
import cn.sunshine.service.UserService;
import cn.sunshine.serviceImpl.UserServiceImpl;

/**
 * Servlet implementation class ShowMy
 */
@WebServlet("/ShowMy")
public class ShowMy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowMy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u_email=(String)request.getSession().getAttribute("email");
		UserService us=new UserServiceImpl();
		User u=new User();
		u.setU_email(u_email);
       User user=us.findMy(u);
       request.setAttribute("fileList",user);
       RequestDispatcher dis=request.getRequestDispatcher("showMy.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
