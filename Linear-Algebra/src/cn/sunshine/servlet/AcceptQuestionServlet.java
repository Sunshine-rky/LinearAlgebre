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
 * Servlet implementation class AcceptQuestionServlet
 */
@WebServlet("/AcceptQuestionServlet")
public class AcceptQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u_email=request.getParameter("resPath");
		String q_title=request.getParameter("resPath1");
		Answer a=new Answer();
		a.setQ_title(q_title);
		a.setU_email(u_email);
		QuestionAndAnswerService qas=new QuestionAndAnswerServiceImpl();
		qas.addMoney(a);
		qas.changeState(a);
		
		//存入日志中
		Log log=new Log();
		 Date now = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String l_time= simpleDateFormat.format(now);
			
			String u_name=(String)request.getSession().getAttribute("name");
			log.setL_time(l_time);
			log.setU_email(u_email);
			log.setU_name(u_name);
			log.setL_behavior("采纳问题");
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
