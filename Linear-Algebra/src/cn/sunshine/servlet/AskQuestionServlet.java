package cn.sunshine.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * Servlet implementation class AskQuestionServlet
 */
@WebServlet("/AskQuestionServlet")
public class AskQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AskQuestionServlet() {
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
		String q_content=request.getParameter("q_content");
		String q_money=request.getParameter("q_money");
        Date now = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String q_time= simpleDateFormat.format(now);

		Question q=new Question();
		q.setU_email(u_email);
		q.setU_name(u_name);
		q.setQ_title(q_title);
		q.setQ_time(q_time);
	    q.setQ_content(q_content);
		q.setQ_money(q_money);
		QuestionAndAnswerService qa=new QuestionAndAnswerServiceImpl();
		qa.askQuestion(q);
		
		//存入日志中
		Log l=new Log();
		l.setL_behavior("用户提问");
		l.setL_modular("问答模块");
		l.setL_time(q_time);
		l.setU_email(u_email);
		l.setU_name(u_name);
		LogService is=new LogServiceImpl();
		is.add(l);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
