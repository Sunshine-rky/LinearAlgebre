package cn.sunshine.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sunshine.bean.Algorithm;
import cn.sunshine.service.AlgorithmService;
import cn.sunshine.serviceImpl.AlgorithmServiceImpl;

/**
 * Servlet implementation class MangerAlterFileServlet
 */
@WebServlet("/MangerAlterFileServlet")
public class MangerAlterFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MangerAlterFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String file=request.getParameter("resPath");
		//Algorithm a=new Algorithm();
		AlgorithmService as=new AlgorithmServiceImpl();
		try {
	
			List<Algorithm> list=as.query();
			for (Algorithm s : list) {
			String file1=s.getM_location();
			
			String fileName = file1.substring(file1.lastIndexOf("\\")+1,file1.length());
			System.out.println(file);
			System.out.println(fileName);
			if(file.equals(fileName)) {
				System.out.println("haaa");
				String filePath =file1;
				ProcessBuilder pb = new ProcessBuilder();
				List<String> commands = new ArrayList<>();
				// 命令和参数在一个集合内
				commands.add("notepad.exe");
				commands.add(filePath);
				pb.command(commands);
				pb.start();
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//String fileName = headerInfo.substring(headerInfo.lastIndexOf("\\")+1,headerInfo.length()-1);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
