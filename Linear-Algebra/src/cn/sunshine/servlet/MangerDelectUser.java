package cn.sunshine.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sunshine.bean.User;
import cn.sunshine.service.PeopleManagementService;
import cn.sunshine.serviceImpl.PeopleManagementServiceImpl;

/**
 * Servlet implementation class MangerDelectUser
 */
@WebServlet("/MangerDelectUser")
public class MangerDelectUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MangerDelectUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PeopleManagementService pms=new PeopleManagementServiceImpl();
	String u_email=request.getParameter("resPath");
	User u=new User();
	u.setU_email(u_email);
	pms.delect(u);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
