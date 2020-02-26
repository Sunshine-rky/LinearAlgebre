package cn.sunshine.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sunshine.bean.Answer;
import cn.sunshine.bean.Log;
import cn.sunshine.service.LogService;
import cn.sunshine.service.QuestionAndAnswerService;
import cn.sunshine.serviceImpl.LogServiceImpl;
import cn.sunshine.serviceImpl.QuestionAndAnswerServiceImpl;

/**
 * Servlet implementation class AnswerQuestionServlet
 */
@WebServlet("/AnswerQuestionServlet")
public class AnswerQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnswerQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String u_email=(String)request.getSession().getAttribute("email");
		String u_name=(String)request.getSession().getAttribute("name");
		String q_title=request.getParameter("q_title");
		String a_content=request.getParameter("a_content");
		
        Date now = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String a_time= simpleDateFormat.format(now);
		Answer a=new Answer();
		a.setA_content(a_content);
		a.setA_time(a_time);
		a.setQ_title(q_title);
		a.setA_content(a_content);
		a.setU_email(u_email);
		a.setU_name(u_name);
		QuestionAndAnswerService qa=new QuestionAndAnswerServiceImpl();
		qa.answerQuestion(a);
		
		//存入日志中
				Log log=new Log();
				
					log.setL_time(a_time);
					log.setU_email(u_email);
					log.setU_name(u_name);
					log.setL_behavior("用户回答");
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
