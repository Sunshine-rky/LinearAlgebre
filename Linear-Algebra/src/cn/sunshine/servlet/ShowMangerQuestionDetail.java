package cn.sunshine.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sunshine.bean.Answer;
import cn.sunshine.bean.Question;
import cn.sunshine.service.QuestionAndAnswerService;
import cn.sunshine.serviceImpl.QuestionAndAnswerServiceImpl;

/**
 * Servlet implementation class ShowMangerQuestion
 */
@WebServlet("/ShowMangerQuestionDetail")
public class ShowMangerQuestionDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowMangerQuestionDetail() {
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
		RequestDispatcher dis=request.getRequestDispatcher("showManageQuestionDetail.jsp");
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
