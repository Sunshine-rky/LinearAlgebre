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

/**
 * Servlet implementation class Math5Servlet
 */
@WebServlet("/Math5Servlet")
public class Math5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Math5Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		String name = request.getParameter("a");
        System.out.println(name.length());
		name = name.substring(0, name.length() - 3);
	
		
		
		if (name.length() == 0) {
			String err = "  请填入数据";
			mapper.writeValue(response.getWriter(), err);
		}else { 
			double [][] arr=MathUtil.arryParser1(name);
			if(arr==null) {
				String err="  填入数据格式有问题";
				mapper.writeValue(response.getWriter(), err);
			}else  if(arr.length!=arr[0].length){
				String err="  填入数据格式有问题";
				mapper.writeValue(response.getWriter(), err);
			}else {
				
				double[][] c=MathUtil.getMatrixInversion(arr);
				String result=MathUtil.toString1(c);
				mapper.writeValue(response.getWriter(),"结果为"+result);
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
  			log.setL_behavior("实现逆矩阵");
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
