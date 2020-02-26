package cn.sunshine.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sunshine.bean.Algorithm;
import cn.sunshine.service.AlgorithmService;
import cn.sunshine.serviceImpl.AlgorithmServiceImpl;

/**
 * Servlet implementation class ShowDownServlet
 */
@WebServlet("/ShowDownServlet")
public class ShowDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDownServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String file=getServletContext().getRealPath("file");	
        //System.out.println(file);
		//File downLoadFileDir=new File()
//		File downLoadFileDir =new File(getServletContext().getRealPath("file"));
//		File[] list=downLoadFileDir.listFiles();
//		request.setAttribute("fileList", list);
//		RequestDispatcher dis=request.getRequestDispatcher("downloadsuccess.jsp");
//		dis.forward(request, response);
		
	AlgorithmService as=new AlgorithmServiceImpl();
	try {
		List<Algorithm> list=as.download();
		request.setAttribute("fileList", list);
		System.out.println(list);
		RequestDispatcher dis=request.getRequestDispatcher("downloadsuccess.jsp");
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
