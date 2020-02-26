package cn.sunshine.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sunshine.bean.Log;
import cn.sunshine.bean.Question;
import cn.sunshine.service.LogService;
import cn.sunshine.service.QuestionAndAnswerService;
import cn.sunshine.serviceImpl.LogServiceImpl;
import cn.sunshine.serviceImpl.QuestionAndAnswerServiceImpl;

/**
 * Servlet implementation class ShoeAllQuestion
 */
@WebServlet("/ShowAllQuestion")
public class ShowAllQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuestionAndAnswerService qa=new QuestionAndAnswerServiceImpl();
	try {
		
		List<Question> list=qa.findAllQuestion();
		
		request.setAttribute("fileList", list);
		
		RequestDispatcher dis=request.getRequestDispatcher("showAllQuestion.jsp");
		dis.forward(request, response);
		//存入日志中
		Log log=new Log();
		 Date now = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String l_time= simpleDateFormat.format(now);
			
			String u_email=(String)request.getSession().getAttribute("email");
			String u_name=(String)request.getSession().getAttribute("name");
			System.out.println(u_email+"haha");
			System.out.println(u_name+"haha");
			log.setL_time(l_time);
			log.setU_email(u_email);
			log.setU_name(u_name);
			log.setL_behavior("用户浏览");
			log.setL_modular("问答模块");
			LogService ls=new LogServiceImpl();
			ls.add(log);
			for (Question question : list) {
			String q_title=question.getQ_title();
					request.getSession().setAttribute("q_title",q_title);
				}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
