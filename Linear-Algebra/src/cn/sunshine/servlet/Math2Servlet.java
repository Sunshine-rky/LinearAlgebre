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
import cn.sunshine.util.MathUtilGauss;

/**
 * Servlet implementation class Math2Servlet
 */
@WebServlet("/Math2Servlet")
public class Math2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Math2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String a=request.getParameter("a");
		System.out.println(a.length());
//		a=a.substring(0, a.length()-3);
		
//		for(int i=0;i<arr.length;i++) {
//			for(int j=0;j<arr[0].length;j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
		
		
		String b=request.getParameter("b");
//		a=a.substring(0, a.length()-3);
		System.out.println(b.length());
		

		System.out.println();
		System.out.println();
		System.out.println();
		ObjectMapper mapper = new ObjectMapper();
		//两个地方不能为空
		if((a.length()-1)==0&&(b.length()-1)==0) {
			String err="请填入数据";
			mapper.writeValue(response.getWriter(), err);
		}else {
			
			double[][] arr=MathUtil.arryParser1(a);
			double[] arr1=MathUtil.arrayPaser2(b);
			for(int i=0;i<arr1.length;i++) {
			System.out.println(arr1[i]);
		}
			//考虑数据格式是否匹配
			if((arr==null)||(arr.length!=arr1.length)) {
				
			String err="请填入符合规范的数据";
			mapper.writeValue(response.getWriter(), err);
		}else {
		
			double[] arr2=MathUtilGauss.solveEquations(arr, arr1);
			String result=MathUtil.toString(arr2);
			mapper.writeValue(response.getWriter(), result);
			
			for(int i=0;i<arr2.length;i++) {
			System.out.println(arr2[i]);
				}
		}
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
			log.setL_behavior("解线性方程组");
			log.setL_modular("运算模块");
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
