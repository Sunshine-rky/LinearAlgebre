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
 * Servlet implementation class Math32Servlet
 */
@WebServlet("/Math32Servlet")
public class Math32Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Math32Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String a = request.getParameter("a");
	
        System.out.println(a.length());
        String b=request.getParameter("b");
      
      
        System.out.println(b.length());
        ObjectMapper mapper=new ObjectMapper();
        int a1=a.length()-1;
        int b1=b.length();
        if(a1==0||b1==0) {
        	String err="请填入完整数据";
        	mapper.writeValue(response.getWriter(), err);
        	}
        else {
        	double[][] arr1=MathUtil.arryParser1(a);
        	  double[][] arr2=MathUtil.arryParser1(b);
        	if(arr1==null||arr2==null) {
        
    		String err="请填入符合规定的数据";
    		mapper.writeValue(response.getWriter(), err);
    	}
        else {
        	  double[][] result=MathUtil.multiply(arr1, arr2);
        	if(result==null) {
        		String err="两个矩阵的形式不符合";
        		mapper.writeValue(response.getWriter(), err);
        	}else {
        		
        		for(int i=0; i<result.length; i++) {
                    for(int j=0; j<result[0].length; j++) {
                        //System.out.print(c[i][j] + "\t");// "\t"代表一个制表位
                    	
                    	System.out.print(result[i][j]+ "\t");
                    }
                    System.out.println();
                }
        		String result1 = MathUtil.toString1(result);
				mapper.writeValue(response.getWriter(), result1);
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
  			log.setL_behavior("矩阵乘法");
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
