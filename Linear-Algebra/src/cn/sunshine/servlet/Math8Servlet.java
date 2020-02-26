package cn.sunshine.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.sunshine.bean.Log;
import cn.sunshine.service.LogService;
import cn.sunshine.serviceImpl.LogServiceImpl;
import cn.sunshine.util.MathUtil;
import cn.sunshine.util.MathUtilEigenValue;

/**
 * Servlet implementation class Math8Servlet
 */
@WebServlet("/Math8Servlet")
public class Math8Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Math8Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		ObjectMapper mapper=new ObjectMapper();
		String a=request.getParameter("a");
		a=a.substring(0,a.length()-3);
		double[][] arr=MathUtil.arryParser1(a);
		if(a.length()==0) {
			String err="请填入数据";
			mapper.writeValue(response.getWriter(), err);
		}else {
			if(arr==null) {
				String err="请填入合法数据";
				mapper.writeValue(response.getWriter(), err);
			}else {
				double[] arr1=MathUtilEigenValue.getCharacteristicValue(arr);
				String result=MathUtil.toString(arr1);
				mapper.writeValue(response.getWriter(), result);
//				for(int i=0;i<arr1.length;i++) {
//					System.out.println(arr1[i]);
//				}
			}
			
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
	  			log.setL_behavior("线性相关的判断");
	  			log.setL_modular("运算模块");
	  			LogService ls=new LogServiceImpl();
	  			ls.add(log);
		}
//		System.out.println(a.length());
//		for(int i=0;i<arr.length;i++) {
//			for(int j=0;j<arr[0].length;j++) {
//				System.out.print(arr[i][j]+"\t");
//			}
//			System.out.println();
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
