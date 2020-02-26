package cn.sunshine.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

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
 * Servlet implementation class MangerDeleteServlet
 */
@WebServlet("/MangerDeleteServlet")
public class MangerDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MangerDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String file=request.getParameter("resPath");
		Algorithm a=new Algorithm();
		AlgorithmService as=new AlgorithmServiceImpl();
		try {
	
			List<Algorithm> list=as.query();
			for (Algorithm s : list) {
			String file1=s.getM_location();
			
			String fileName = file1.substring(file1.lastIndexOf("\\")+1,file1.length());
			System.out.println(file);
			System.out.println(fileName);
			if(file.equals(fileName)) {
				//把数据库里的地址删除
				a.setM_location(file1);
				as.delete(a);
				//删除服务器里的文件
				  String filePath = file1;
				  File realfile = new File(filePath);
				  // 路径为文件且不为空则进行删除
			        if (realfile.isFile() && realfile.exists()) {
			            boolean delete = realfile.delete();
			            if (delete) {
			                System.out.println("删除成功!");
			            }
			        }
		
			}
			}
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
