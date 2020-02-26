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

import cn.sunshine.bean.Question;

import cn.sunshine.service.QuestionAndAnswerService;

import cn.sunshine.serviceImpl.QuestionAndAnswerServiceImpl;

/**
 * Servlet implementation class ShowAllQuestionServlet
 */
@WebServlet("/ShowAllCheckQuestionServlet")
public class ShowAllCheckQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllCheckQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuestionAndAnswerService qa=new QuestionAndAnswerServiceImpl();
		
		try {
			
			List<Question> list=qa.checkQuestion();
			
			request.setAttribute("fileList", list);
			
			RequestDispatcher dis=request.getRequestDispatcher("showAllCheckQuestion.jsp");
			dis.forward(request, response);
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
