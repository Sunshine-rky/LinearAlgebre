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

import cn.sunshine.bean.Answer;
import cn.sunshine.bean.Log;
import cn.sunshine.bean.Question;
import cn.sunshine.service.LogService;
import cn.sunshine.service.QuestionAndAnswerService;
import cn.sunshine.serviceImpl.LogServiceImpl;
import cn.sunshine.serviceImpl.QuestionAndAnswerServiceImpl;

/**
 * Servlet implementation class ShowQuestionDetail
 */
@WebServlet("/ShowQuestionDetail")
public class ShowQuestionDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowQuestionDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String q_title=request.getParameter("resPath");
		Question q=new Question();
		q.setQ_title(q_title);
		QuestionAndAnswerService qa=new QuestionAndAnswerServiceImpl();
		Question q1=qa.showQuestionDetial(q);
		System.out.println(q1);
		request.setAttribute("fileList", q1);
		Answer a=new Answer();
		a.setQ_title(q_title);
		//List<Answer> a=qa.findAllAnswer(a);
		try {
			List<Answer> list=qa.findAllAnswer(a);
			request.setAttribute("list", list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dis=request.getRequestDispatcher("showQuestionDetail.jsp");
		dis.forward(request, response);
		
		
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
					log.setL_behavior("查看详情");
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
