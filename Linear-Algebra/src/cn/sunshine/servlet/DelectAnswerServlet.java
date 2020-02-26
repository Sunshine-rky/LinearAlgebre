package cn.sunshine.servlet;

import java.io.IOException;
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
 * Servlet implementation class DelectAnswerServlet
 */
@WebServlet("/DelectAnswerServlet")
public class DelectAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelectAnswerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Answer a=new Answer();
		String a_content=request.getParameter("resPath");
		a.setA_content(a_content);
		QuestionAndAnswerService qas=new QuestionAndAnswerServiceImpl();
		qas.delectAnswer(a);
//		qas.SubAnswerNumber(a);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
