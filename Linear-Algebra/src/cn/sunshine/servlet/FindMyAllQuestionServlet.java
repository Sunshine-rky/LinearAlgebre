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
 * Servlet implementation class FindMyAllQuestion
 */
@WebServlet("/FindMyAllQuestionServlet")
public class FindMyAllQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindMyAllQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			String u_email=(String)request.getSession().getAttribute("email");
			Question q=new Question();
			q.setU_email(u_email);
			QuestionAndAnswerService qa=new QuestionAndAnswerServiceImpl();
			List<Question> list=qa.findMyAllQuestion(q);
			request.setAttribute("list", list);
			int number=list.size();
			request.setAttribute("number", number);
			RequestDispatcher dis=request.getRequestDispatcher("myQA.jsp");
			dis.forward(request, response);
			System.out.println("hahaa");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//存入日志中
		Log log=new Log();
		 Date now = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String l_time= simpleDateFormat.format(now);
			
			String u_email=(String)request.getSession().getAttribute("email");
			String u_name=(String)request.getSession().getAttribute("name");
			log.setL_time(l_time);
			log.setU_email(u_email);
			log.setU_name(u_name);
			log.setL_behavior("查看自己提出所有问题");
			log.setL_modular("问答模块");
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
